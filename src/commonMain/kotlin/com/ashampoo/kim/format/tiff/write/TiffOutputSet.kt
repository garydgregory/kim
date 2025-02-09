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
import com.ashampoo.kim.common.GpsUtil.MINUTES_PER_HOUR
import com.ashampoo.kim.common.ImageWriteException
import com.ashampoo.kim.common.RationalNumber.Companion.valueOf
import com.ashampoo.kim.format.tiff.constants.GpsTag
import com.ashampoo.kim.format.tiff.constants.TiffConstants
import com.ashampoo.kim.format.tiff.constants.TiffConstants.DEFAULT_TIFF_BYTE_ORDER
import kotlin.math.abs

@Suppress("TooManyFunctions")
class TiffOutputSet(
    val byteOrder: ByteOrder = DEFAULT_TIFF_BYTE_ORDER
) {

    private val directories = mutableListOf<TiffOutputDirectory>()

    fun getOutputItems(outputSummary: TiffOutputSummary): List<TiffOutputItem> {

        val outputItems = mutableListOf<TiffOutputItem>()

        for (directory in directories)
            outputItems.addAll(directory.getOutputItems(outputSummary))

        return outputItems
    }

    fun addDirectory(directory: TiffOutputDirectory): TiffOutputDirectory {

        if (findDirectory(directory.type) != null)
            throw ImageWriteException("Output set already contains a directory of that type.")

        directories.add(directory)

        return directory
    }

    fun getDirectories(): List<TiffOutputDirectory> = directories

    fun getOrCreateRootDirectory(): TiffOutputDirectory =
        findDirectory(TiffConstants.DIRECTORY_TYPE_ROOT) ?: addRootDirectory()

    fun getOrCreateExifDirectory(): TiffOutputDirectory {

        /* The EXIF directory requires root directory. */
        getOrCreateRootDirectory()

        return findDirectory(TiffConstants.DIRECTORY_TYPE_EXIF) ?: addExifDirectory()
    }

    fun getOrCreateGPSDirectory(): TiffOutputDirectory {

        /* The GPS directory requires EXIF directory */
        getOrCreateExifDirectory()

        return findDirectory(TiffConstants.DIRECTORY_TYPE_GPS) ?: addGPSDirectory()
    }

    fun findDirectory(directoryType: Int): TiffOutputDirectory? {

        for (directory in directories)
            if (directory.type == directoryType)
                return directory

        return null
    }

    /**
     * A convenience method to update GPS values in EXIF metadata.
     *
     * @param longitude Longitude in degrees E, negative values are W.
     * @param latitude  latitude in degrees N, negative values are S.
     */
    fun setGPSInDegrees(longitude: Double, latitude: Double) {

        val gpsDirectory = getOrCreateGPSDirectory()

        gpsDirectory.removeField(GpsTag.GPS_TAG_GPS_VERSION_ID)
        gpsDirectory.add(GpsTag.GPS_TAG_GPS_VERSION_ID, GpsTag.GPS_VERSION)

        val longitudeRef = if (longitude < 0) "W" else "E"
        val latitudeRef = if (latitude < 0) "S" else "N"

        gpsDirectory.removeField(GpsTag.GPS_TAG_GPS_LONGITUDE_REF)
        gpsDirectory.add(GpsTag.GPS_TAG_GPS_LONGITUDE_REF, longitudeRef)

        gpsDirectory.removeField(GpsTag.GPS_TAG_GPS_LATITUDE_REF)
        gpsDirectory.add(GpsTag.GPS_TAG_GPS_LATITUDE_REF, latitudeRef)

        run {

            var value = abs(longitude)

            val longitudeDegrees = value.toLong().toDouble()
            value %= 1.0
            value *= MINUTES_PER_HOUR

            val longitudeMinutes = value.toLong().toDouble()
            value %= 1.0
            value *= MINUTES_PER_HOUR

            val longitudeSeconds = value

            gpsDirectory.removeField(GpsTag.GPS_TAG_GPS_LONGITUDE)
            gpsDirectory.add(
                GpsTag.GPS_TAG_GPS_LONGITUDE,
                arrayOf(
                    valueOf(longitudeDegrees),
                    valueOf(longitudeMinutes),
                    valueOf(longitudeSeconds)
                )
            )
        }

        run {

            var value = abs(latitude)

            val latitudeDegrees = value.toLong().toDouble()

            value %= 1.0
            value *= MINUTES_PER_HOUR

            val latitudeMinutes = value.toLong().toDouble()

            value %= 1.0
            value *= MINUTES_PER_HOUR

            val latitudeSeconds = value

            gpsDirectory.removeField(GpsTag.GPS_TAG_GPS_LATITUDE)
            gpsDirectory.add(
                GpsTag.GPS_TAG_GPS_LATITUDE,
                arrayOf(
                    valueOf(latitudeDegrees),
                    valueOf(latitudeMinutes),
                    valueOf(latitudeSeconds)
                )
            )
        }
    }

    fun findField(tag: Int): TiffOutputField? {

        for (directory in directories) {

            val field = directory.findField(tag)

            if (null != field)
                return field
        }

        return null
    }

    fun addRootDirectory(): TiffOutputDirectory =
        addDirectory(TiffOutputDirectory(TiffConstants.DIRECTORY_TYPE_ROOT, byteOrder))

    fun addExifDirectory(): TiffOutputDirectory =
        addDirectory(TiffOutputDirectory(TiffConstants.DIRECTORY_TYPE_EXIF, byteOrder))

    fun addGPSDirectory(): TiffOutputDirectory =
        addDirectory(TiffOutputDirectory(TiffConstants.DIRECTORY_TYPE_GPS, byteOrder))
}
