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
package com.ashampoo.kim.format.jpeg.segments

import com.ashampoo.kim.input.ByteReader
import io.ktor.utils.io.charsets.Charset
import io.ktor.utils.io.core.String

abstract class GenericSegment : Segment {

    val segmentBytes: ByteArray

    constructor(marker: Int, markerLength: Int, byteReader: ByteReader) : super(marker, markerLength) {
        segmentBytes = byteReader.readBytes("segmentBytes", markerLength)
    }

    constructor(marker: Int, bytes: ByteArray) : super(marker, bytes.size) {
        segmentBytes = bytes
    }

    fun getSegmentDataAsString(charset: Charset): String =
        String(segmentBytes, charset = charset)
}
