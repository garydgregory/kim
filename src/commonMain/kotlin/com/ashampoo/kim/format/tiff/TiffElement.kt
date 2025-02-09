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
package com.ashampoo.kim.format.tiff

abstract class TiffElement(
    val offset: Long,
    val length: Int
) {

    abstract class DataElement(
        offset: Long,
        length: Int,
        val bytes: ByteArray
    ) : TiffElement(offset, length)

    class Stub(offset: Long, length: Int) : TiffElement(offset, length) {

        override fun toString(): String = "Stub, offset: $offset, length: $length, last: ${offset + length}"

    }

    companion object {
        val COMPARATOR = compareBy { e: TiffElement -> e.offset }
    }
}
