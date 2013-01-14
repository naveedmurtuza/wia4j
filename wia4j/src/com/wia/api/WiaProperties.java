package com.wia.api;

/**
 *
 * @author Naveed Quadri
 */
public interface WiaProperties {

    /**
     * Possible values for {@link  WIA_DPS_DOCUMENT_HANDLING_SELECT }
     */
    public static final int PROPERTY_DOCUMENT_FEEDER = 1;
    public static final int PROPERTY_FLATBED = 2;
    /**
     *
     */
    public static final int PROPERTY_DOCUMENT_FEEDER_READY = 1;
    /**
     * @see
     * http://msdn.microsoft.com/en-us/library/windows/hardware/ff552739%28v=vs.85%29.aspx
     * @see Wiadef.h
     */
    public static final int WIA_DIP_DEV_ID = 2;
    public static final int WIA_DIP_VEND_DESC = 3; //Manufacturer
    public static final int WIA_DIP_DEV_DESC = 4;//Description
    public static final int WIA_DIP_DEV_TYPE = 5;
    public static final int WIA_DIP_PORT_NAME = 6;
    public static final int WIA_DIP_DEV_NAME = 7;
    public static final int WIA_DIP_SERVER_NAME = 8;
    public static final int WIA_DIP_REMOTE_DEV_ID = 9;
    public static final int WIA_DIP_UI_CLSID = 10;
    public static final int WIA_DIP_HW_CONFIG = 11;// 0xb
    public static final int WIA_DIP_BAUDRATE = 12;// 0xc
    public static final int WIA_DIP_STI_GEN_CAPABILITIES = 13;// 0xd
    public static final int WIA_DIP_WIA_VERSION = 14;// 0xe
    public static final int WIA_DIP_DRIVER_VERSION = 15;// 0xf
    public static final int WIA_DIP_PNP_ID = 16;// 0x10
    public static final int WIA_DIP_STI_DRIVER_VERSION = 17;// 0x11
    public static final int WIA_DPA_FIRMWARE_VERSION = 1026;// 0x402
    public static final int WIA_DPA_CONNECT_STATUS = 1027;// 0x403
    public static final int WIA_DPA_DEVICE_TIME = 1028;// 0x404
    public static final int WIA_DPC_PICTURES_TAKEN = 2050;// 0x802
    public static final int WIA_DPC_PICTURES_REMAINING = 2051;// 0x803
    public static final int WIA_DPC_EXPOSURE_MODE = 2052;// 0x804
    public static final int WIA_DPC_EXPOSURE_COMP = 2053;// 0x805
    public static final int WIA_DPC_EXPOSURE_TIME = 2054;// 0x806
    public static final int WIA_DPC_FNUMBER = 2055;// 0x807
    public static final int WIA_DPC_FLASH_MODE = 2056;// 0x808
    public static final int WIA_DPC_FOCUS_MODE = 2057;// 0x809
    public static final int WIA_DPC_FOCUS_MANUAL_DIST = 2058;// 0x80a
    public static final int WIA_DPC_ZOOM_POSITION = 2059;// 0x80b
    public static final int WIA_DPC_PAN_POSITION = 2060;// 0x80c
    public static final int WIA_DPC_TILT_POSITION = 2061;// 0x80d
    public static final int WIA_DPC_TIMER_MODE = 2062;// 0x80e
    public static final int WIA_DPC_TIMER_VALUE = 2063;// 0x80f
    public static final int WIA_DPC_POWER_MODE = 2064;// 0x810
    public static final int WIA_DPC_BATTERY_STATUS = 2065;// 0x811
    public static final int WIA_DPC_THUMB_WIDTH = 2066;// 0x812
    public static final int WIA_DPC_THUMB_HEIGHT = 2067;// 0x813
    public static final int WIA_DPC_PICT_WIDTH = 2068;// 0x814
    public static final int WIA_DPC_PICT_HEIGHT = 2069;// 0x815
    public static final int WIA_DPC_DIMENSION = 2070;// 0x816
    public static final int WIA_DPC_COMPRESSION_SETTING = 2071;// 0x817
    public static final int WIA_DPC_FOCUS_METERING = 2072;// 0x818
    public static final int WIA_DPC_TIMELAPSE_INTERVAL = 2073;// 0x819
    public static final int WIA_DPC_TIMELAPSE_NUMBER = 2074;// 0x81a
    public static final int WIA_DPC_BURST_INTERVAL = 2075;// 0x81b
    public static final int WIA_DPC_BURST_NUMBER = 2076;// 0x81c
    public static final int WIA_DPC_EFFECT_MODE = 2077;// 0x81d
    public static final int WIA_DPC_DIGITAL_ZOOM = 2078;// 0x81e
    public static final int WIA_DPC_SHARPNESS = 2079;// 0x81f
    public static final int WIA_DPC_CONTRAST = 2080;// 0x820
    public static final int WIA_DPC_CAPTURE_MODE = 2081;// 0x821
    public static final int WIA_DPC_CAPTURE_DELAY = 2082;// 0x822
    public static final int WIA_DPC_EXPOSURE_INDEX = 2083;// 0x823
    public static final int WIA_DPC_EXPOSURE_METERING_MODE = 2084;// 0x824
    public static final int WIA_DPC_FOCUS_METERING_MODE = 2085;// 0x825
    public static final int WIA_DPC_FOCUS_DISTANCE = 2086;// 0x826
    public static final int WIA_DPC_FOCAL_LENGTH = 2087;// 0x827
    public static final int WIA_DPC_RGB_GAIN = 2088;// 0x828
    public static final int WIA_DPC_WHITE_BALANCE = 2089;// 0x829
    public static final int WIA_DPC_UPLOAD_URL = 2090;// 0x82a
    public static final int WIA_DPC_ARTIST = 2091;// 0x82b
    public static final int WIA_DPC_COPYRIGHT_INFO = 2092;// 0x82c
    public static final int WIA_DPS_HORIZONTAL_BED_SIZE = 3074;// 0xc02
    public static final int WIA_DPS_VERTICAL_BED_SIZE = 3075;// 0xc03
    public static final int WIA_DPS_HORIZONTAL_SHEET_FEED_SIZE = 3076;// 0xc04
    public static final int WIA_DPS_VERTICAL_SHEET_FEED_SIZE = 3077;// 0xc05
    public static final int WIA_DPS_SHEET_FEEDER_REGISTRATION = 3078;// 0xc06
    public static final int WIA_DPS_HORIZONTAL_BED_REGISTRATION = 3079;// 0xc07
    public static final int WIA_DPS_VERTICAL_BED_REGISTRATION = 3080;// 0xc08
    public static final int WIA_DPS_PLATEN_COLOR = 3081;// 0xc09
    public static final int WIA_DPS_PAD_COLOR = 3082;// 0xc0a
    public static final int WIA_DPS_FILTER_SELECT = 3083;// 0xc0b
    public static final int WIA_DPS_DITHER_SELECT = 3084;// 0xc0c
    public static final int WIA_DPS_DITHER_PATTERN_DATA = 3085;// 0xc0d
    public static final int WIA_DPS_DOCUMENT_HANDLING_CAPABILITIES = 3086;// 0xc0e
    public static final int WIA_DPS_DOCUMENT_HANDLING_STATUS = 3087;// 0xc0f
    public static final int WIA_DPS_DOCUMENT_HANDLING_SELECT = 3088;// 0xc10
    public static final int WIA_DPS_DOCUMENT_HANDLING_CAPACITY = 3089;// 0xc11
    public static final int WIA_DPS_OPTICAL_XRES = 3090;// 0xc12
    public static final int WIA_DPS_OPTICAL_YRES = 3091;// 0xc13
    public static final int WIA_DPS_ENDORSER_CHARACTERS = 3092;// 0xc14
    public static final int WIA_DPS_ENDORSER_STRING = 3093;// 0xc15
    public static final int WIA_DPS_SCAN_AHEAD_PAGES = 3094;// 0xc16
    public static final int WIA_DPS_MAX_SCAN_TIME = 3095;// 0xc17
    public static final int WIA_DPS_PAGES = 3096;// 0xc18
    public static final int WIA_DPS_PAGE_SIZE = 3097;// 0xc19
    public static final int WIA_DPS_PAGE_WIDTH = 3098;// 0xc1a
    public static final int WIA_DPS_PAGE_HEIGHT = 3099;// 0xc1b
    public static final int WIA_DPS_PREVIEW = 3100;// 0xc1c
    public static final int WIA_DPS_TRANSPARENCY = 3101;// 0xc1d
    public static final int WIA_DPS_TRANSPARENCY_SELECT = 3102;// 0xc1e
    public static final int WIA_DPS_SHOW_PREVIEW_CONTROL = 3103;// 0xc1f
    public static final int WIA_DPS_MIN_HORIZONTAL_SHEET_FEED_SIZE = 3104;// 0xc20
    public static final int WIA_DPS_MIN_VERTICAL_SHEET_FEED_SIZE = 3105;// 0xc21
    public static final int WIA_DPS_TRANSPARENCY_CAPABILITIES = 3106;// 0xc22
    public static final int WIA_DPS_TRANSPARENCY_STATUS = 3107;// 0xc23
    public static final int WIA_DPF_MOUNT_POINT = 3330;// 0xd02
    public static final int WIA_DPV_LAST_PICTURE_TAKEN = 3586;// 0xe02
    public static final int WIA_DPV_IMAGES_DIRECTORY = 3587;// 0xe03
    public static final int WIA_DPV_DSHOW_DEVICE_PATH = 3588;// 0xe04
    public static final int WIA_IPA_ITEM_NAME = 4098;// 0x1002
    public static final int WIA_IPA_FULL_ITEM_NAME = 4099;// 0x1003
    public static final int WIA_IPA_ITEM_TIME = 4100;// 0x1004
    public static final int WIA_IPA_ITEM_FLAGS = 4101;// 0x1005
    public static final int WIA_IPA_ACCESS_RIGHTS = 4102;// 0x1006
    public static final int WIA_IPA_DATATYPE = 4103;// 0x1007
    public static final int WIA_IPA_DEPTH = 4104;// 0x1008
    public static final int WIA_IPA_PREFERRED_FORMAT = 4105;// 0x1009
    public static final int WIA_IPA_FORMAT = 4106;// 0x100a
    public static final int WIA_IPA_COMPRESSION = 4107;// 0x100b
    public static final int WIA_IPA_TYMED = 4108;// 0x100c
    public static final int WIA_IPA_CHANNELS_PER_PIXEL = 4109;// 0x100d
    public static final int WIA_IPA_BITS_PER_CHANNEL = 4110;// 0x100e
    public static final int WIA_IPA_PLANAR = 4111;// 0x100f
    public static final int WIA_IPA_PIXELS_PER_LINE = 4112;// 0x1010
    public static final int WIA_IPA_BYTES_PER_LINE = 4113;// 0x1011
    public static final int WIA_IPA_NUMBER_OF_LINES = 4114;// 0x1012
    public static final int WIA_IPA_GAMMA_CURVES = 4115;// 0x1013
    public static final int WIA_IPA_ITEM_SIZE = 4116;// 0x1014
    public static final int WIA_IPA_COLOR_PROFILE = 4117;// 0x1015
    public static final int WIA_IPA_MIN_BUFFER_SIZE = 4118;// 0x1016
    public static final int WIA_IPA_BUFFER_SIZE = 4118;// 0x1016
    public static final int WIA_IPA_REGION_TYPE = 4119;// 0x1017
    public static final int WIA_IPA_ICM_PROFILE_NAME = 4120;// 0x1018
    public static final int WIA_IPA_APP_COLOR_MAPPING = 4121;// 0x1019
    public static final int WIA_IPA_PROP_STREAM_COMPAT_ID = 4122;// 0x101a
    public static final int WIA_IPA_FILENAME_EXTENSION = 4123;// 0x101b
    public static final int WIA_IPA_SUPPRESS_PROPERTY_PAGE = 4124;// 0x101c
    public static final int WIA_IPC_THUMBNAIL = 5122;// 0x1402
    public static final int WIA_IPC_THUMB_WIDTH = 5123;// 0x1403
    public static final int WIA_IPC_THUMB_HEIGHT = 5124;// 0x1404
    public static final int WIA_IPC_AUDIO_AVAILABLE = 5125;// 0x1405
    public static final int WIA_IPC_AUDIO_DATA_FORMAT = 5126;// 0x1406
    public static final int WIA_IPC_AUDIO_DATA = 5127;// 0x1407
    public static final int WIA_IPC_NUM_PICT_PER_ROW = 5128;// 0x1408
    public static final int WIA_IPC_SEQUENCE = 5129;// 0x1409
    public static final int WIA_IPC_TIMEDELAY = 5130;// 0x140a
    public static final int WIA_IPS_CUR_INTENT = 6146;// 0x1802
    public static final int WIA_IPS_XRES = 6147;// 0x1803
    public static final int WIA_IPS_YRES = 6148;// 0x1804
    public static final int WIA_IPS_XPOS = 6149;// 0x1805
    public static final int WIA_IPS_YPOS = 6150;// 0x1806
    public static final int WIA_IPS_XEXTENT = 6151;// 0x1807
    public static final int WIA_IPS_YEXTENT = 6152;// 0x1808
    public static final int WIA_IPS_PHOTOMETRIC_INTERP = 6153;// 0x1809
    public static final int WIA_IPS_BRIGHTNESS = 6154;// 0x180a
    public static final int WIA_IPS_CONTRAST = 6155;// 0x180b
    public static final int WIA_IPS_ORIENTATION = 6156;// 0x180c
    public static final int WIA_IPS_ROTATION = 6157;// 0x180d
    public static final int WIA_IPS_MIRROR = 6158;// 0x180e
    public static final int WIA_IPS_THRESHOLD = 6159;// 0x180f
    public static final int WIA_IPS_INVERT = 6160;// 0x1810
    public static final int WIA_IPS_WARM_UP_TIME = 6161;// 0x1811
//#if (_WIN32_WINNT >= 0x0600)
//
// New properties, property names and values introduced in Windows Vista:
//
    public static final int WIA_DPS_USER_NAME = 3112;// 0xc28
    public static final int WIA_DPS_SERVICE_ID = 3113;// 0xc29
    public static final int WIA_DPS_DEVICE_ID = 3114;// 0xc2a
    public static final int WIA_DPS_GLOBAL_IDENTITY = 3115;// 0xc2b
    public static final int WIA_DPS_SCAN_AVAILABLE_ITEM = 3116;// 0xc2c
    public static final int WIA_IPS_DESKEW_X = 6162;// 0x1812
    public static final int WIA_IPS_DESKEW_Y = 6163;// 0x1813
    public static final int WIA_IPS_SEGMENTATION = 6164;// 0x1814
    public static final int WIA_IPS_MAX_HORIZONTAL_SIZE = 6165;// 0x1815
    public static final int WIA_IPS_MAX_VERTICAL_SIZE = 6166;// 0x1816
    public static final int WIA_IPS_MIN_HORIZONTAL_SIZE = 6167;// 0x1817
    public static final int WIA_IPS_MIN_VERTICAL_SIZE = 6168;// 0x1818
    public static final int WIA_IPS_TRANSFER_CAPABILITIES = 6169;// 0x1819
    public static final int WIA_IPS_SHEET_FEEDER_REGISTRATION = 3078;// 0xc06
    public static final int WIA_IPS_DOCUMENT_HANDLING_SELECT = 3088;// 0xc10
    public static final int WIA_IPS_OPTICAL_XRES = 3090;// 0xc12
    public static final int WIA_IPS_OPTICAL_YRES = 3091;// 0xc13
    public static final int WIA_IPS_PAGES = 3096;// 0xc18
    public static final int WIA_IPS_PAGE_SIZE = 3097;// 0xc19
    public static final int WIA_IPS_PAGE_WIDTH = 3098;// 0xc1a
    public static final int WIA_IPS_PAGE_HEIGHT = 3099;// 0xc1b
    public static final int WIA_IPS_PREVIEW = 3100;// 0xc1c
    public static final int WIA_IPS_SHOW_PREVIEW_CONTROL = 3103;// 0xc1f
    public static final int WIA_IPS_FILM_SCAN_MODE = 3104;// 0xc20
    public static final int WIA_IPS_LAMP = 3105;// 0xc21
    public static final int WIA_IPS_LAMP_AUTO_OFF = 3106;// 0xc22
    public static final int WIA_IPS_AUTO_DESKEW = 3107;// 0xc23
    public static final int WIA_IPS_SUPPORTS_CHILD_ITEM_CREATION = 3108;// 0xc24
    public static final int WIA_IPS_XSCALING = 3109;// 0xc25
    public static final int WIA_IPS_YSCALING = 3110;// 0xc26
    public static final int WIA_IPS_PREVIEW_TYPE = 3111;// 0xc27
    public static final int WIA_IPA_ITEM_CATEGORY = 4125;// 0x101d
    public static final int WIA_IPA_UPLOAD_ITEM_SIZE = 4126;// 0x101e
    public static final int WIA_IPA_ITEMS_STORED = 4127;// 0x101f
    public static final int WIA_IPA_RAW_BITS_PER_CHANNEL = 4128;// 0x1020
    public static final int WIA_IPS_FILM_NODE_NAME = 4129;// 0x1021
}
