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
package com.ashampoo.kim.format.tiff.constants

import com.ashampoo.kim.format.tiff.taginfos.TagInfoAscii
import com.ashampoo.kim.format.tiff.taginfos.TagInfoByte
import com.ashampoo.kim.format.tiff.taginfos.TagInfoBytes
import com.ashampoo.kim.format.tiff.taginfos.TagInfoDirectory
import com.ashampoo.kim.format.tiff.taginfos.TagInfoDouble
import com.ashampoo.kim.format.tiff.taginfos.TagInfoGpsText
import com.ashampoo.kim.format.tiff.taginfos.TagInfoLong
import com.ashampoo.kim.format.tiff.taginfos.TagInfoLongs
import com.ashampoo.kim.format.tiff.taginfos.TagInfoRational
import com.ashampoo.kim.format.tiff.taginfos.TagInfoRationals
import com.ashampoo.kim.format.tiff.taginfos.TagInfoSLong
import com.ashampoo.kim.format.tiff.taginfos.TagInfoSRational
import com.ashampoo.kim.format.tiff.taginfos.TagInfoShort
import com.ashampoo.kim.format.tiff.taginfos.TagInfoShortOrLong
import com.ashampoo.kim.format.tiff.taginfos.TagInfoShorts
import com.ashampoo.kim.format.tiff.taginfos.TagInfoUndefined
import com.ashampoo.kim.format.tiff.taginfos.TagInfoUndefineds
import com.ashampoo.kim.format.tiff.taginfos.TagInfoUnknowns

@Suppress("MagicNumber", "LargeClass", "StringLiteralDuplication")
object ExifTag {

    val EXIF_TAG_INTEROPERABILITY_INDEX = TagInfoAscii(
        "InteroperabilityIndex", 0x0001, -1,
        TiffDirectoryType.EXIF_DIRECTORY_INTEROP_IFD
    )

    val EXIF_TAG_INTEROPERABILITY_VERSION = TagInfoUndefined(
        "InteroperabilityVersion", 0x0002,
        TiffDirectoryType.EXIF_DIRECTORY_INTEROP_IFD
    )

    val EXIF_TAG_PROCESSING_SOFTWARE = TagInfoAscii(
        "ProcessingSoftware", 0x000b, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_IFD0
    )

    val EXIF_TAG_SOFTWARE = TagInfoAscii(
        "Software", 0x0131, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_IFD0
    )

    val EXIF_TAG_PREVIEW_IMAGE_START_IFD0 = TagInfoLong(
        "PreviewImageStart", 0x0111,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_IFD0, true
    )

    val EXIF_TAG_PREVIEW_IMAGE_START_SUB_IFD1 = TagInfoLong(
        "PreviewImageStart", 0x0111,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_SUB_IFD1, true
    )

    val EXIF_TAG_JPG_FROM_RAW_START_SUB_IFD2 = TagInfoLong(
        "JpgFromRawStart", 0x0111,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_SUB_IFD2, true
    )

    val EXIF_TAG_PREVIEW_IMAGE_LENGTH_IFD0 = TagInfoLong(
        "PreviewImageLength", 0x0117,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_IFD0
    )

    val EXIF_TAG_PREVIEW_IMAGE_LENGTH_SUB_IFD1 = TagInfoLong(
        "PreviewImageLength", 0x0117,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_SUB_IFD1
    )

    val EXIF_TAG_JPG_FROM_RAW_LENGTH_SUB_IFD2 = TagInfoLong(
        "JpgFromRawLength", 0x0117,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_SUB_IFD2
    )

    val EXIF_TAG_PREVIEW_IMAGE_START_MAKER_NOTES = TagInfoLong(
        "PreviewImageStart", 0x0201,
        TiffDirectoryType.EXIF_DIRECTORY_MAKER_NOTES
    )

    val EXIF_TAG_JPG_FROM_RAW_START_SUB_IFD = TagInfoLong(
        "JpgFromRawStart", 0x0201,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_SUB_IFD, true
    )

    val EXIF_TAG_JPG_FROM_RAW_START_IFD2 = TagInfoLong(
        "JpgFromRawStart", 0x0201,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_IFD2, true
    )

    val EXIF_TAG_OTHER_IMAGE_START = TagInfoLong(
        "OtherImageStart", 0x0201,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN, true
    )

    val EXIF_TAG_PREVIEW_IMAGE_LENGTH_MAKER_NOTES = TagInfoLong(
        "PreviewImageLength", 0x0202,
        TiffDirectoryType.EXIF_DIRECTORY_MAKER_NOTES
    )

    val EXIF_TAG_JPG_FROM_RAW_LENGTH_SUB_IFD = TagInfoLong(
        "JpgFromRawLength", 0x0202,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_SUB_IFD
    )

    val EXIF_TAG_JPG_FROM_RAW_LENGTH_IFD2 = TagInfoLong(
        "JpgFromRawLength", 0x0202,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_IFD2
    )

    val EXIF_TAG_OTHER_IMAGE_LENGTH = TagInfoLong(
        "OtherImageLength", 0x0202,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_APPLICATION_NOTES = TagInfoBytes(
        "ApplicationNotes", 0x02bc, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_MATTEING = TagInfoUnknowns(
        "Matteing", 0x80e3, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_DATA_TYPE = TagInfoUnknowns(
        "DataType", 0x80e4, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_IMAGE_DEPTH = TagInfoUnknowns(
        "ImageDepth", 0x80e5, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_TILE_DEPTH = TagInfoUnknowns(
        "TileDepth", 0x80e6, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_MODEL_2 = TagInfoUnknowns(
        "Model2", 0x827d, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_EXPOSURE_TIME = TagInfoRationals(
        "ExposureTime", 0x829a, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_FNUMBER = TagInfoRationals(
        "FNumber", 0x829d, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_IPTC_NAA = TagInfoLong(
        "IPTC-NAA", 0x83bb,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_IFD0
    )

    val EXIF_TAG_INTERGRAPH_PACKET_DATA = TagInfoShorts(
        "IntergraphPacketData", 0x847e, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_INTERGRAPH_FLAG_REGISTERS = TagInfoLongs(
        "IntergraphFlagRegisters", 0x847f, 16,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_SITE = TagInfoAscii(
        "Site", 0x84e0, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_COLOR_SEQUENCE = TagInfoAscii(
        "ColorSequence", 0x84e1, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_IT8HEADER = TagInfoAscii(
        "IT8Header", 0x84e2, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_RASTER_PADDING = TagInfoShort(
        "RasterPadding", 0x84e3,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_BITS_PER_RUN_LENGTH = TagInfoShort(
        "BitsPerRunLength", 0x84e4,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_BITS_PER_EXTENDED_RUN_LENGTH = TagInfoShort(
        "BitsPerExtendedRunLength", 0x84e5,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_COLOR_TABLE = TagInfoBytes(
        "ColorTable", 0x84e6, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_IMAGE_COLOR_INDICATOR = TagInfoByte(
        "ImageColorIndicator", 0x84e7,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_BACKGROUND_COLOR_INDICATOR = TagInfoByte(
        "BackgroundColorIndicator", 0x84e8,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_IMAGE_COLOR_VALUE = TagInfoBytes(
        "ImageColorValue", 0x84e9, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_BACKGROUND_COLOR_VALUE = TagInfoBytes(
        "BackgroundColorValue", 0x84ea, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_PIXEL_INTENSITY_RANGE = TagInfoBytes(
        "PixelIntensityRange", 0x84eb, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_TRANSPARENCY_INDICATOR = TagInfoByte(
        "TransparencyIndicator", 0x84ec,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_COLOR_CHARACTERIZATION = TagInfoAscii(
        "ColorCharacterization", 0x84ed, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_HCUSAGE = TagInfoShortOrLong(
        "HCUsage", 0x84ee, 1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_SEMINFO = TagInfoAscii(
        "SEMInfo", 0x8546, 1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_IFD0
    )

    val EXIF_TAG_AFCP_IPTC = TagInfoLong(
        "AFCP_IPTC", 0x8568,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_LEAF_DATA = TagInfoLong(
        "LeafData", 0x8606,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_PHOTOSHOP_SETTINGS = TagInfoBytes(
        "PhotoshopSettings", 0x8649, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_EXIF_OFFSET = TagInfoDirectory(
        "ExifOffset", 0x8769,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )
    val EXIF_TAG_EXPOSURE_PROGRAM = TagInfoShort(
        "ExposureProgram", 0x8822,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    const val EXPOSURE_PROGRAM_VALUE_MANUAL = 1
    const val EXPOSURE_PROGRAM_VALUE_PROGRAM_AE = 2
    const val EXPOSURE_PROGRAM_VALUE_APERTURE_PRIORITY_AE = 3
    const val EXPOSURE_PROGRAM_VALUE_SHUTTER_SPEED_PRIORITY_AE = 4
    const val EXPOSURE_PROGRAM_VALUE_CREATIVE_SLOW_SPEED = 5
    const val EXPOSURE_PROGRAM_VALUE_ACTION_HIGH_SPEED = 6
    const val EXPOSURE_PROGRAM_VALUE_PORTRAIT = 7
    const val EXPOSURE_PROGRAM_VALUE_LANDSCAPE = 8

    val EXIF_TAG_SPECTRAL_SENSITIVITY = TagInfoAscii(
        "SpectralSensitivity", 0x8824, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_GPSINFO = TagInfoDirectory(
        "GPSInfo", 0x8825,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_ISO = TagInfoShorts(
        "PhotographicSensitivity", 0x8827, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_OPTO_ELECTRIC_CONV_FACTOR = TagInfoUndefineds(
        "Opto - Electric Conv Factor", 0x8828, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_LEAF_SUB_IFD = TagInfoLong(
        "LeafSubIFD", 0x888a,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_EXIF_VERSION = TagInfoUndefineds(
        "ExifVersion", 0x9000, 4,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_DATE_TIME_ORIGINAL = TagInfoAscii(
        "DateTimeOriginal", 0x9003, 20,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_DATE_TIME_DIGITIZED = TagInfoAscii(
        "DateTimeDigitized", 0x9004, 20,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_COMPONENTS_CONFIGURATION = TagInfoUndefineds(
        "ComponentsConfiguration", 0x9101, 4,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_COMPRESSED_BITS_PER_PIXEL = TagInfoRational(
        "CompressedBitsPerPixel", 0x9102,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_SHUTTER_SPEED_VALUE = TagInfoSRational(
        "ShutterSpeedValue", 0x9201,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_APERTURE_VALUE = TagInfoRational(
        "ApertureValue", 0x9202,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_BRIGHTNESS_VALUE = TagInfoSRational(
        "BrightnessValue", 0x9203,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_EXPOSURE_COMPENSATION = TagInfoSRational(
        "ExposureCompensation", 0x9204,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_MAX_APERTURE_VALUE = TagInfoRational(
        "MaxApertureValue", 0x9205,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_SUBJECT_DISTANCE = TagInfoRationals(
        "Subject Distance", 0x9206, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_METERING_MODE = TagInfoShort(
        "MeteringMode", 0x9207,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    const val METERING_MODE_VALUE_AVERAGE = 1
    const val METERING_MODE_VALUE_CENTER_WEIGHTED_AVERAGE = 2
    const val METERING_MODE_VALUE_SPOT = 3
    const val METERING_MODE_VALUE_MULTI_SPOT = 4
    const val METERING_MODE_VALUE_MULTI_SEGMENT = 5
    const val METERING_MODE_VALUE_PARTIAL = 6
    const val METERING_MODE_VALUE_OTHER = 255

    val EXIF_TAG_LIGHT_SOURCE = TagInfoShort(
        "LightSource", 0x9208,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    const val LIGHT_SOURCE_VALUE_DAYLIGHT = 1
    const val LIGHT_SOURCE_VALUE_FLUORESCENT = 2
    const val LIGHT_SOURCE_VALUE_TUNGSTEN = 3
    const val LIGHT_SOURCE_VALUE_FLASH = 4
    const val LIGHT_SOURCE_VALUE_FINE_WEATHER = 9
    const val LIGHT_SOURCE_VALUE_CLOUDY = 10
    const val LIGHT_SOURCE_VALUE_SHADE = 11
    const val LIGHT_SOURCE_VALUE_DAYLIGHT_FLUORESCENT = 12
    const val LIGHT_SOURCE_VALUE_DAY_WHITE_FLUORESCENT = 13
    const val LIGHT_SOURCE_VALUE_COOL_WHITE_FLUORESCENT = 14
    const val LIGHT_SOURCE_VALUE_WHITE_FLUORESCENT = 15
    const val LIGHT_SOURCE_VALUE_STANDARD_LIGHT_A = 17
    const val LIGHT_SOURCE_VALUE_STANDARD_LIGHT_B = 18
    const val LIGHT_SOURCE_VALUE_STANDARD_LIGHT_C = 19
    const val LIGHT_SOURCE_VALUE_D55 = 20
    const val LIGHT_SOURCE_VALUE_D65 = 21
    const val LIGHT_SOURCE_VALUE_D75 = 22
    const val LIGHT_SOURCE_VALUE_D50 = 23
    const val LIGHT_SOURCE_VALUE_ISO_STUDIO_TUNGSTEN = 24
    const val LIGHT_SOURCE_VALUE_OTHER = 255

    val EXIF_TAG_FLASH = TagInfoShort(
        "Flash", 0x9209,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    const val FLASH_VALUE_NO_FLASH = 0x0
    const val FLASH_VALUE_FIRED = 0x1
    const val FLASH_VALUE_FIRED_RETURN_NOT_DETECTED = 0x5
    const val FLASH_VALUE_FIRED_RETURN_DETECTED = 0x7
    const val FLASH_VALUE_ON_DID_NOT_FIRE = 0x8
    const val FLASH_VALUE_ON = 0x9
    const val FLASH_VALUE_ON_RETURN_NOT_DETECTED = 0xd
    const val FLASH_VALUE_ON_RETURN_DETECTED = 0xf
    const val FLASH_VALUE_OFF = 0x10
    const val FLASH_VALUE_OFF_DID_NOT_FIRE_RETURN_NOT_DETECTED = 0x14
    const val FLASH_VALUE_AUTO_DID_NOT_FIRE = 0x18
    const val FLASH_VALUE_AUTO_FIRED = 0x19
    const val FLASH_VALUE_AUTO_FIRED_RETURN_NOT_DETECTED = 0x1d
    const val FLASH_VALUE_AUTO_FIRED_RETURN_DETECTED = 0x1f
    const val FLASH_VALUE_NO_FLASH_FUNCTION = 0x20
    const val FLASH_VALUE_OFF_NO_FLASH_FUNCTION = 0x30
    const val FLASH_VALUE_FIRED_RED_EYE_REDUCTION = 0x41
    const val FLASH_VALUE_FIRED_RED_EYE_REDUCTION_RETURN_NOT_DETECTED = 0x45
    const val FLASH_VALUE_FIRED_RED_EYE_REDUCTION_RETURN_DETECTED = 0x47
    const val FLASH_VALUE_ON_RED_EYE_REDUCTION = 0x49
    const val FLASH_VALUE_ON_RED_EYE_REDUCTION_RETURN_NOT_DETECTED = 0x4d
    const val FLASH_VALUE_ON_RED_EYE_REDUCTION_RETURN_DETECTED = 0x4f
    const val FLASH_VALUE_OFF_RED_EYE_REDUCTION = 0x50
    const val FLASH_VALUE_AUTO_DID_NOT_FIRE_RED_EYE_REDUCTION = 0x58
    const val FLASH_VALUE_AUTO_FIRED_RED_EYE_REDUCTION = 0x59
    const val FLASH_VALUE_AUTO_FIRED_RED_EYE_REDUCTION_RETURN_NOT_DETECTED = 0x5d
    const val FLASH_VALUE_AUTO_FIRED_RED_EYE_REDUCTION_RETURN_DETECTED = 0x5f

    val EXIF_TAG_FOCAL_LENGTH = TagInfoRationals(
        "FocalLength", 0x920a, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_SUBJECT_AREA = TagInfoShorts(
        "SubjectArea", 0x9214, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_STO_NITS = TagInfoDouble(
        "StoNits", 0x923f,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_MAKER_NOTE = TagInfoUndefineds(
        "MakerNote", 0x927c, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_USER_COMMENT = TagInfoGpsText(
        "UserComment", 0x9286,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_SUB_SEC_TIME = TagInfoAscii(
        "SubSecTime", 0x9290, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_SUB_SEC_TIME_ORIGINAL = TagInfoAscii(
        "SubSecTimeOriginal", 0x9291, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_SUB_SEC_TIME_DIGITIZED = TagInfoAscii(
        "SubSecTimeDigitized", 0x9292, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_OFFSET_TIME_ORIGINAL = TagInfoAscii(
        "OffsetTimeOriginal", 0x9011, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_FLASHPIX_VERSION = TagInfoUndefineds(
        "FlashpixVersion", 0xa000, 4,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_EXIF_IMAGE_WIDTH = TagInfoShort(
        "ExifImageWidth", 0xa002,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_EXIF_IMAGE_LENGTH = TagInfoShort(
        "ExifImageLength", 0xa003,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_RELATED_SOUND_FILE = TagInfoAscii(
        "RelatedSoundFile", 0xa004, 13,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_INTEROP_OFFSET = TagInfoDirectory(
        "InteropOffset", 0xa005,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_FLASH_ENERGY_EXIF_IFD = TagInfoRationals(
        "FlashEnergy", 0xa20b, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_SPATIAL_FREQUENCY_RESPONSE_2 = TagInfoUndefineds(
        "SpatialFrequencyResponse", 0xa20c, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_NOISE_2 = TagInfoUnknowns(
        "Noise", 0xa20d, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_FOCAL_PLANE_XRESOLUTION_EXIF_IFD = TagInfoRational(
        "FocalPlaneXResolution", 0xa20e,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_FOCAL_PLANE_YRESOLUTION_EXIF_IFD = TagInfoRational(
        "FocalPlaneYResolution", 0xa20f,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_FOCAL_PLANE_RESOLUTION_UNIT_EXIF_IFD = TagInfoShort(
        "FocalPlaneResolutionUnit", 0xa210,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    const val FOCAL_PLANE_RESOLUTION_UNIT_EXIF_IFD_VALUE_NONE = 1
    const val FOCAL_PLANE_RESOLUTION_UNIT_EXIF_IFD_VALUE_INCHES = 2
    const val FOCAL_PLANE_RESOLUTION_UNIT_EXIF_IFD_VALUE_CM = 3
    const val FOCAL_PLANE_RESOLUTION_UNIT_EXIF_IFD_VALUE_MM = 4
    const val FOCAL_PLANE_RESOLUTION_UNIT_EXIF_IFD_VALUE_UM = 5

    val EXIF_TAG_IMAGE_NUMBER = TagInfoUnknowns(
        "ImageNumber", 0xa211, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_SECURITY_CLASSIFICATION = TagInfoUnknowns(
        "SecurityClassification", 0xa212, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_IMAGE_HISTORY = TagInfoUnknowns(
        "ImageHistory", 0xa213, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_SUBJECT_LOCATION = TagInfoShorts(
        "SubjectLocation", 0xa214, 2,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_EXPOSURE_INDEX_EXIF_IFD = TagInfoRational(
        "ExposureIndex", 0xa215,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_TIFF_EPSTANDARD_ID_2 = TagInfoUnknowns(
        "TIFF-EPStandardID", 0xa216, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_SENSING_METHOD_EXIF_IFD = TagInfoShort(
        "SensingMethod", 0xa217,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    const val SENSING_METHOD_EXIF_IFD_VALUE_NOT_DEFINED = 1
    const val SENSING_METHOD_EXIF_IFD_VALUE_ONE_CHIP_COLOR_AREA = 2
    const val SENSING_METHOD_EXIF_IFD_VALUE_TWO_CHIP_COLOR_AREA = 3
    const val SENSING_METHOD_EXIF_IFD_VALUE_THREE_CHIP_COLOR_AREA = 4
    const val SENSING_METHOD_EXIF_IFD_VALUE_COLOR_SEQUENTIAL_AREA = 5
    const val SENSING_METHOD_EXIF_IFD_VALUE_TRILINEAR = 7
    const val SENSING_METHOD_EXIF_IFD_VALUE_COLOR_SEQUENTIAL_LINEAR = 8

    val EXIF_TAG_FILE_SOURCE = TagInfoUndefined(
        "FileSource", 0xa300,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    const val FILE_SOURCE_VALUE_FILM_SCANNER = 1
    const val FILE_SOURCE_VALUE_REFLECTION_PRINT_SCANNER = 2
    const val FILE_SOURCE_VALUE_DIGITAL_CAMERA = 3

    val EXIF_TAG_SCENE_TYPE = TagInfoUndefined(
        "SceneType", 0xa301,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_CFAPATTERN = TagInfoUndefineds(
        "CFAPattern", 0xa302, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_CUSTOM_RENDERED = TagInfoShort(
        "CustomRendered", 0xa401,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    const val CUSTOM_RENDERED_VALUE_NORMAL = 0
    const val CUSTOM_RENDERED_VALUE_CUSTOM = 1

    val EXIF_TAG_EXPOSURE_MODE = TagInfoShort(
        "ExposureMode", 0xa402,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    const val EXPOSURE_MODE_VALUE_AUTO = 0
    const val EXPOSURE_MODE_VALUE_MANUAL = 1
    const val EXPOSURE_MODE_VALUE_AUTO_BRACKET = 2

    val EXIF_TAG_WHITE_BALANCE_1 = TagInfoShort(
        "WhiteBalance", 0xa403,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    const val WHITE_BALANCE_1_VALUE_AUTO = 0
    const val WHITE_BALANCE_1_VALUE_MANUAL = 1

    val EXIF_TAG_DIGITAL_ZOOM_RATIO = TagInfoRational(
        "DigitalZoomRatio", 0xa404,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_FOCAL_LENGTH_IN_35MM_FORMAT = TagInfoShort(
        "FocalLengthIn35mmFormat", 0xa405,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_SCENE_CAPTURE_TYPE = TagInfoShort(
        "SceneCaptureType", 0xa406,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    const val SCENE_CAPTURE_TYPE_VALUE_STANDARD = 0
    const val SCENE_CAPTURE_TYPE_VALUE_LANDSCAPE = 1
    const val SCENE_CAPTURE_TYPE_VALUE_PORTRAIT = 2
    const val SCENE_CAPTURE_TYPE_VALUE_NIGHT = 3

    val EXIF_TAG_GAIN_CONTROL = TagInfoShort(
        "GainControl", 0xa407,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    const val GAIN_CONTROL_VALUE_NONE = 0
    const val GAIN_CONTROL_VALUE_LOW_GAIN_UP = 1
    const val GAIN_CONTROL_VALUE_HIGH_GAIN_UP = 2
    const val GAIN_CONTROL_VALUE_LOW_GAIN_DOWN = 3
    const val GAIN_CONTROL_VALUE_HIGH_GAIN_DOWN = 4

    val EXIF_TAG_CONTRAST_1 = TagInfoShort(
        "Contrast", 0xa408,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    const val CONTRAST_1_VALUE_NORMAL = 0
    const val CONTRAST_1_VALUE_LOW = 1
    const val CONTRAST_1_VALUE_HIGH = 2

    val EXIF_TAG_SATURATION_1 = TagInfoShort(
        "Saturation", 0xa409,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    const val SATURATION_1_VALUE_NORMAL = 0
    const val SATURATION_1_VALUE_LOW = 1
    const val SATURATION_1_VALUE_HIGH = 2

    val EXIF_TAG_SHARPNESS_1 = TagInfoShort(
        "Sharpness", 0xa40a,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    const val SHARPNESS_1_VALUE_NORMAL = 0
    const val SHARPNESS_1_VALUE_SOFT = 1
    const val SHARPNESS_1_VALUE_HARD = 2

    val EXIF_TAG_DEVICE_SETTING_DESCRIPTION = TagInfoUndefineds(
        "DeviceSettingDescription", 0xa40b, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_SUBJECT_DISTANCE_RANGE = TagInfoShort(
        "SubjectDistanceRange", 0xa40c,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    const val SUBJECT_DISTANCE_RANGE_VALUE_MACRO = 1
    const val SUBJECT_DISTANCE_RANGE_VALUE_CLOSE = 2
    const val SUBJECT_DISTANCE_RANGE_VALUE_DISTANT = 3

    val EXIF_TAG_IMAGE_UNIQUE_ID = TagInfoAscii(
        "ImageUniqueID", 0xa420, 33,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_CAMERA_OWNER_NAME = TagInfoAscii(
        "CameraOwnerName", 0xa430, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_BODY_SERIAL_NUMBER = TagInfoAscii(
        "BodySerialNumber", 0xa431, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_LENS_SPECIFICATION = TagInfoRationals(
        "LensSpecification", 0xa432, 4,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_LENS_MAKE = TagInfoAscii(
        "LensMake", 0xa433, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_LENS_MODEL = TagInfoAscii(
        "LensModel", 0xa434, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_LENS_SERIAL_NUMBER = TagInfoAscii(
        "LensSerialNumber", 0xa435, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_GAMMA = TagInfoRational(
        "Gamma", 0xa500,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_ANNOTATIONS = TagInfoUnknowns(
        "Annotations", 0xc44f, -1,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_UNKNOWN
    )

    val EXIF_TAG_PRINT_IM = TagInfoUndefined(
        "PrintIM", 0xc4a5,
        TiffDirectoryType.Companion.EXIF_DIRECTORY_IFD0
    )

    val EXIF_TAG_OFFSET_SCHEMA = TagInfoSLong(
        "OffsetSchema", 0xea1d,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_OWNER_NAME = TagInfoAscii(
        "OwnerName", 0xfde8, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_SERIAL_NUMBER = TagInfoAscii(
        "SerialNumber", 0xfde9, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_LENS = TagInfoAscii(
        "Lens", 0xfdea, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_RAW_FILE = TagInfoAscii(
        "RawFile", 0xfe4c, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_CONVERTER = TagInfoAscii(
        "Converter", 0xfe4d, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_WHITE_BALANCE_2 = TagInfoAscii(
        "WhiteBalance", 0xfe4e, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_EXPOSURE = TagInfoAscii(
        "Exposure", 0xfe51, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_SHADOWS = TagInfoAscii(
        "Shadows", 0xfe52, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_BRIGHTNESS = TagInfoAscii(
        "Brightness", 0xfe53, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_CONTRAST_2 = TagInfoAscii(
        "Contrast", 0xfe54, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_SATURATION_2 = TagInfoAscii(
        "Saturation", 0xfe55, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_SHARPNESS_2 = TagInfoAscii(
        "Sharpness", 0xfe56, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_SMOOTHNESS = TagInfoAscii(
        "Smoothness", 0xfe57, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val EXIF_TAG_MOIRE_FILTER = TagInfoAscii(
        "MoireFilter", 0xfe58, -1,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    /** Rating tag used by Windows */
    val EXIF_TAG_RATING = TagInfoShort(
        "Rating", 0x4746,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    /** Rating tag used by Windows, value in percent */
    val EXIF_TAG_RATING_PERCENT = TagInfoShort(
        "RatingPercent", 0x4749,
        TiffDirectoryType.EXIF_DIRECTORY_EXIF_IFD
    )

    val ALL_EXIF_TAGS = listOf(
        EXIF_TAG_INTEROPERABILITY_INDEX, EXIF_TAG_INTEROPERABILITY_VERSION,
        EXIF_TAG_PROCESSING_SOFTWARE,
        EXIF_TAG_SOFTWARE,
        EXIF_TAG_PREVIEW_IMAGE_START_IFD0,
        EXIF_TAG_PREVIEW_IMAGE_START_SUB_IFD1,
        EXIF_TAG_JPG_FROM_RAW_START_SUB_IFD2,
        EXIF_TAG_PREVIEW_IMAGE_LENGTH_IFD0,
        EXIF_TAG_PREVIEW_IMAGE_LENGTH_SUB_IFD1,
        EXIF_TAG_JPG_FROM_RAW_LENGTH_SUB_IFD2,
        EXIF_TAG_PREVIEW_IMAGE_START_MAKER_NOTES,
        EXIF_TAG_JPG_FROM_RAW_START_SUB_IFD,
        EXIF_TAG_JPG_FROM_RAW_START_IFD2, EXIF_TAG_OTHER_IMAGE_START,
        EXIF_TAG_PREVIEW_IMAGE_LENGTH_MAKER_NOTES,
        EXIF_TAG_JPG_FROM_RAW_LENGTH_SUB_IFD,
        EXIF_TAG_JPG_FROM_RAW_LENGTH_IFD2, EXIF_TAG_OTHER_IMAGE_LENGTH,
        EXIF_TAG_APPLICATION_NOTES,
        EXIF_TAG_MATTEING, EXIF_TAG_DATA_TYPE,
        EXIF_TAG_IMAGE_DEPTH, EXIF_TAG_TILE_DEPTH, EXIF_TAG_MODEL_2,
        EXIF_TAG_EXPOSURE_TIME,
        EXIF_TAG_FNUMBER, EXIF_TAG_IPTC_NAA,
        EXIF_TAG_INTERGRAPH_PACKET_DATA,
        EXIF_TAG_INTERGRAPH_FLAG_REGISTERS,
        EXIF_TAG_SITE, EXIF_TAG_COLOR_SEQUENCE,
        EXIF_TAG_IT8HEADER, EXIF_TAG_RASTER_PADDING,
        EXIF_TAG_BITS_PER_RUN_LENGTH,
        EXIF_TAG_BITS_PER_EXTENDED_RUN_LENGTH, EXIF_TAG_COLOR_TABLE,
        EXIF_TAG_IMAGE_COLOR_INDICATOR,
        EXIF_TAG_BACKGROUND_COLOR_INDICATOR, EXIF_TAG_IMAGE_COLOR_VALUE,
        EXIF_TAG_BACKGROUND_COLOR_VALUE, EXIF_TAG_PIXEL_INTENSITY_RANGE,
        EXIF_TAG_TRANSPARENCY_INDICATOR, EXIF_TAG_COLOR_CHARACTERIZATION,
        EXIF_TAG_HCUSAGE, EXIF_TAG_SEMINFO, EXIF_TAG_AFCP_IPTC,
        EXIF_TAG_LEAF_DATA,
        EXIF_TAG_PHOTOSHOP_SETTINGS, EXIF_TAG_EXIF_OFFSET,
        EXIF_TAG_EXPOSURE_PROGRAM,
        EXIF_TAG_SPECTRAL_SENSITIVITY, EXIF_TAG_GPSINFO, EXIF_TAG_ISO,
        EXIF_TAG_OPTO_ELECTRIC_CONV_FACTOR,
        EXIF_TAG_LEAF_SUB_IFD,
        EXIF_TAG_EXIF_VERSION, EXIF_TAG_DATE_TIME_ORIGINAL,
        EXIF_TAG_DATE_TIME_DIGITIZED, EXIF_TAG_COMPONENTS_CONFIGURATION,
        EXIF_TAG_COMPRESSED_BITS_PER_PIXEL, EXIF_TAG_SHUTTER_SPEED_VALUE,
        EXIF_TAG_APERTURE_VALUE, EXIF_TAG_BRIGHTNESS_VALUE,
        EXIF_TAG_EXPOSURE_COMPENSATION, EXIF_TAG_MAX_APERTURE_VALUE,
        EXIF_TAG_SUBJECT_DISTANCE, EXIF_TAG_IMAGE_UNIQUE_ID,
        EXIF_TAG_CAMERA_OWNER_NAME,
        EXIF_TAG_BODY_SERIAL_NUMBER,
        EXIF_TAG_LENS_SPECIFICATION,
        EXIF_TAG_LENS_MAKE,
        EXIF_TAG_LENS_MODEL,
        EXIF_TAG_LENS_SERIAL_NUMBER,
        EXIF_TAG_METERING_MODE,
        EXIF_TAG_LIGHT_SOURCE, EXIF_TAG_FLASH, EXIF_TAG_FOCAL_LENGTH,
        EXIF_TAG_SUBJECT_AREA,
        EXIF_TAG_STO_NITS, EXIF_TAG_SUB_SEC_TIME,
        EXIF_TAG_SUB_SEC_TIME_ORIGINAL, EXIF_TAG_SUB_SEC_TIME_DIGITIZED,
        EXIF_TAG_OFFSET_TIME_ORIGINAL,
        EXIF_TAG_FLASHPIX_VERSION,
        EXIF_TAG_EXIF_IMAGE_WIDTH, EXIF_TAG_EXIF_IMAGE_LENGTH,
        EXIF_TAG_RELATED_SOUND_FILE, EXIF_TAG_INTEROP_OFFSET,
        EXIF_TAG_FLASH_ENERGY_EXIF_IFD,
        EXIF_TAG_SPATIAL_FREQUENCY_RESPONSE_2, EXIF_TAG_NOISE_2,
        EXIF_TAG_FOCAL_PLANE_XRESOLUTION_EXIF_IFD,
        EXIF_TAG_FOCAL_PLANE_YRESOLUTION_EXIF_IFD,
        EXIF_TAG_FOCAL_PLANE_RESOLUTION_UNIT_EXIF_IFD,
        EXIF_TAG_IMAGE_NUMBER, EXIF_TAG_SECURITY_CLASSIFICATION,
        EXIF_TAG_IMAGE_HISTORY, EXIF_TAG_SUBJECT_LOCATION,
        EXIF_TAG_EXPOSURE_INDEX_EXIF_IFD, EXIF_TAG_TIFF_EPSTANDARD_ID_2,
        EXIF_TAG_SENSING_METHOD_EXIF_IFD, EXIF_TAG_FILE_SOURCE,
        EXIF_TAG_SCENE_TYPE, EXIF_TAG_CFAPATTERN, EXIF_TAG_CUSTOM_RENDERED,
        EXIF_TAG_EXPOSURE_MODE, EXIF_TAG_WHITE_BALANCE_1,
        EXIF_TAG_DIGITAL_ZOOM_RATIO, EXIF_TAG_FOCAL_LENGTH_IN_35MM_FORMAT,
        EXIF_TAG_SCENE_CAPTURE_TYPE, EXIF_TAG_GAIN_CONTROL,
        EXIF_TAG_CONTRAST_1, EXIF_TAG_SATURATION_1, EXIF_TAG_SHARPNESS_1,
        EXIF_TAG_DEVICE_SETTING_DESCRIPTION,
        EXIF_TAG_SUBJECT_DISTANCE_RANGE, EXIF_TAG_IMAGE_UNIQUE_ID,
        EXIF_TAG_GAMMA,
        EXIF_TAG_ANNOTATIONS, EXIF_TAG_PRINT_IM,
        EXIF_TAG_OFFSET_SCHEMA, EXIF_TAG_OWNER_NAME,
        EXIF_TAG_SERIAL_NUMBER, EXIF_TAG_LENS, EXIF_TAG_RAW_FILE,
        EXIF_TAG_CONVERTER, EXIF_TAG_WHITE_BALANCE_2, EXIF_TAG_EXPOSURE,
        EXIF_TAG_SHADOWS, EXIF_TAG_BRIGHTNESS, EXIF_TAG_CONTRAST_2,
        EXIF_TAG_SATURATION_2, EXIF_TAG_SHARPNESS_2, EXIF_TAG_SMOOTHNESS,
        EXIF_TAG_MOIRE_FILTER,
        EXIF_TAG_USER_COMMENT, //
        EXIF_TAG_MAKER_NOTE,
        EXIF_TAG_RATING,
        EXIF_TAG_RATING_PERCENT
    )
}
