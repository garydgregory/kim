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
package com.ashampoo.kim.format.tiff.taginfos

import com.ashampoo.kim.format.tiff.constants.TiffDirectoryType
import com.ashampoo.kim.format.tiff.fieldtypes.FieldType

open class TagInfoByte : TagInfo {

    constructor(name: String, tag: Int, directoryType: TiffDirectoryType?) :
        super(name, tag, FieldType.BYTE, 1, directoryType)

    constructor(
        name: String,
        tag: Int,
        fieldTypes: List<FieldType>,
        directoryType: TiffDirectoryType?
    ) : super(name, tag, fieldTypes, 1, directoryType)

    constructor(
        name: String,
        tag: Int,
        fieldType: FieldType,
        directoryType: TiffDirectoryType?
    ) : super(name, tag, fieldType, 1, directoryType)

    fun encodeValue(value: Byte): ByteArray =
        byteArrayOf(value)
}
