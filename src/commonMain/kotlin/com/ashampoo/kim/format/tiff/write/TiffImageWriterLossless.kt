/*
 * Copyright 2023 Ashampoo GmbH & Co. KG
 * Copyright 2007-2023 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ashampoo.kim.format.tiff.write

import com.ashampoo.kim.common.ByteOrder
import com.ashampoo.kim.common.ImageReadException
import com.ashampoo.kim.common.ImageWriteException
import com.ashampoo.kim.format.tiff.TiffElement
import com.ashampoo.kim.format.tiff.TiffReader
import com.ashampoo.kim.format.tiff.constants.ExifTag
import com.ashampoo.kim.format.tiff.constants.TiffConstants
import com.ashampoo.kim.format.tiff.constants.TiffConstants.TIFF_HEADER_SIZE
import com.ashampoo.kim.input.ByteArrayByteReader
import com.ashampoo.kim.output.BinaryByteWriter.Companion.createBinaryByteWriter
import com.ashampoo.kim.output.BufferByteWriter
import com.ashampoo.kim.output.ByteWriter
import io.ktor.utils.io.core.use

class TiffImageWriterLossless(
    byteOrder: ByteOrder = TiffConstants.DEFAULT_TIFF_BYTE_ORDER,
    private val exifBytes: ByteArray
) : TiffImageWriterBase(byteOrder) {

    private fun analyzeOldTiff(frozenFields: Map<Int, TiffOutputField>): List<TiffElement> {

        return try {

            val byteReader = ByteArrayByteReader(exifBytes)

            val contents = TiffReader().read(byteReader)

            val elements = mutableListOf<TiffElement>()

            val directories = contents.directories

            for (directory in directories) {

                elements.add(directory)

                for (field in directory.getDirectoryEntries()) {

                    val oversizeValue = field.createOversizeValueElement()

                    if (oversizeValue != null) {

                        val frozenField = frozenFields[field.tag]

                        if (frozenField != null &&
                            frozenField.separateValue != null &&
                            frozenField.bytesEqual(field.byteArrayValue)
                        ) {
                            frozenField.separateValue.offset = field.offset.toLong()
                        } else {
                            elements.add(oversizeValue)
                        }
                    }
                }

                val jpegImageData = directory.jpegImageData

                if (jpegImageData != null)
                    elements.add(jpegImageData)
            }

            elements.sortWith(TiffElement.COMPARATOR)

            val rewritableElements = mutableListOf<TiffElement>()

            var start: TiffElement? = null

            var index: Long = -1

            for (element in elements) {

                val lastElementByte = element.offset + element.length

                if (start == null) {

                    start = element

                } else if (element.offset - index > OFFSET_TOLERANCE) {

                    rewritableElements.add(TiffElement.Stub(start.offset, (index - start.offset).toInt()))

                    start = element
                }

                index = lastElementByte
            }

            if (start != null)
                rewritableElements.add(TiffElement.Stub(start.offset, (index - start.offset).toInt()))

            rewritableElements

        } catch (e: ImageReadException) {
            throw ImageWriteException(e.message, e)
        }
    }

    override fun write(byteWriter: ByteWriter, outputSet: TiffOutputSet) {

        /*
         * There are some fields whose address in the file must not change,
         * unless of course their value is changed.
         * If MakerNotes offset changes, it's broken.
         */
        val frozenFields = mutableMapOf<Int, TiffOutputField>()

        val makerNoteField = outputSet.findField(ExifTag.EXIF_TAG_MAKER_NOTE.tag)

        if (makerNoteField != null && makerNoteField.separateValue != null)
            frozenFields[ExifTag.EXIF_TAG_MAKER_NOTE.tag] = makerNoteField

        val analysis = analyzeOldTiff(frozenFields)

        val oldLength = exifBytes.size

        if (analysis.isEmpty())
            throw ImageWriteException("Couldn't analyze old tiff data.")

        if (analysis.size == 1) {

            val onlyElement = analysis[0]

            val newLength: Long = onlyElement.offset + onlyElement.length + TIFF_HEADER_SIZE

            /*
             * Check if there are no gaps in the old data. If so, it's safe to complete overwrite.
             */
            if (onlyElement.offset == TIFF_HEADER_SIZE.toLong() && newLength == oldLength.toLong()) {
                TiffImageWriterLossy(byteOrder).write(byteWriter, outputSet)
                return
            }
        }

        val frozenFieldOffsets = mutableMapOf<Long, TiffOutputField>()

        for ((_, frozenField) in frozenFields)
            if (frozenField.separateValue!!.offset != TiffOutputItem.UNDEFINED_VALUE)
                frozenFieldOffsets[frozenField.separateValue.offset] = frozenField

        val outputSummary = validateDirectories(outputSet)

        val allOutputItems = outputSet.getOutputItems(outputSummary)

        val outputItems = mutableListOf<TiffOutputItem>()

        for (outputItem in allOutputItems)
            if (!frozenFieldOffsets.containsKey(outputItem.offset))
                outputItems.add(outputItem)

        val outputLength = updateOffsetsStep(analysis, outputItems)

        outputSummary.updateOffsets(byteOrder)

        writeStep(byteWriter, outputSet, analysis, outputItems, outputLength)
    }

    private fun updateOffsetsStep(
        analysis: List<TiffElement>,
        outputItems: List<TiffOutputItem>
    ): Long {

        /* Items we cannot fit into a gap, we shall append to tail. */
        var overflowIndex = exifBytes.size.toLong()

        /* Make a copy and ensure it's correctly sorted. */
        val unusedElements = analysis
            .sortedWith(TiffElement.COMPARATOR.reversed())
            .toMutableList()

        /* Any items that represent a gap at the end of the exif segment, can be discarded. */
        while (!unusedElements.isEmpty()) {

            val element = unusedElements[0]

            val elementEnd = element.offset + element.length

            if (elementEnd != overflowIndex)
                break

            /* Discarding a tail element. Should only happen once. */
            overflowIndex -= element.length.toLong()

            unusedElements.removeAt(0)
        }

        unusedElements.sortWith(ELEMENT_SIZE_COMPARATOR.reversed())

        // make copy.
        val unplacedItems = mutableListOf<TiffOutputItem>()

        unplacedItems.addAll(outputItems)
        unplacedItems.sortWith(ITEM_SIZE_COMPARATOR)
        unplacedItems.reverse()

        while (!unplacedItems.isEmpty()) {

            /* Pop off largest unplaced item. */
            val outputItem = unplacedItems.removeAt(0)

            val outputItemLength = outputItem.getItemLength()

            var bestFit: TiffElement? = null

            /* Search for the smallest possible element large enough to hold the item. */
            for (element in unusedElements) {

                if (element.length < outputItemLength)
                    break

                bestFit = element
            }

            if (bestFit == null) {

                /* Overflow if we couldn't place this item. */
                if (overflowIndex and 1L != 0L)
                    overflowIndex += 1

                outputItem.offset = overflowIndex

                overflowIndex += outputItemLength.toLong()

            } else {

                var offset = bestFit.offset
                var length = bestFit.length

                /* Offsets have to be a multiple of 2 */
                if (offset and 1L != 0L) {
                    offset += 1
                    length -= 1
                }

                outputItem.offset = offset

                unusedElements.remove(bestFit)

                if (length > outputItemLength) {

                    /* Not a perfect fit. */
                    val excessOffset = offset + outputItemLength
                    val excessLength = length - outputItemLength

                    unusedElements.add(TiffElement.Stub(excessOffset, excessLength))

                    /* Make sure the new element is in the correct order. */
                    unusedElements.sortWith(ELEMENT_SIZE_COMPARATOR)
                    unusedElements.reverse()
                }
            }
        }

        return overflowIndex
    }

    private fun writeStep(
        byteWriter: ByteWriter,
        outputSet: TiffOutputSet,
        analysis: List<TiffElement>,
        outputItems: List<TiffOutputItem>,
        outputLength: Long
    ) {

        val rootDirectory = outputSet.getOrCreateRootDirectory()

        val outputByteArray = ByteArray(outputLength.toInt())

        /* Copy old data that inclued makers notes and other stuff. */
        exifBytes.copyInto(
            destination = outputByteArray,
            endIndex = minOf(exifBytes.size, outputByteArray.size)
        )

        val headerBinaryStream = createBinaryByteWriter(BufferByteWriter(outputByteArray, 0), byteOrder)

        writeImageFileHeader(headerBinaryStream, rootDirectory.offset)

        /*
         * Zero out the parsed pieces of old exif segment, in case we don't overwrite them.
         */
        for (element in analysis)
            outputByteArray.fill(
                element = 0.toByte(),
                fromIndex = element.offset.toInt(),
                toIndex = minOf(element.offset + element.length, outputByteArray.size.toLong()).toInt(),
            )

        /* Write in the new items */
        for (outputItem in outputItems) {

            val offset = outputItem.offset.toInt()

            val newByteWriter = BufferByteWriter(outputByteArray, offset)

            createBinaryByteWriter(newByteWriter, byteOrder).use { bos ->
                outputItem.writeItem(bos)
            }
        }

        byteWriter.write(outputByteArray)
    }

    companion object {

        const val OFFSET_TOLERANCE = 3

        private val ELEMENT_SIZE_COMPARATOR =
            compareBy { element: TiffElement -> element.length }

        private val ITEM_SIZE_COMPARATOR =
            compareBy { item: TiffOutputItem -> item.getItemLength() }
    }
}
