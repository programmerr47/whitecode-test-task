package com.programmerr47.whitecodetesttask.api.accessoryEnums;

/**
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public enum Platform {
    MOBILE,
    IPHONE,
    IPAD,
    ANDROID,
    WPHONE,
    WINDOWS,
    WEB;

    public static Platform getFromInt(int platformId) {
        switch (platformId) {
            case 1:
                return MOBILE;
            case 2:
                return IPHONE;
            case 3:
                return IPAD;
            case 4:
                return ANDROID;
            case 5:
                return WPHONE;
            case 6:
                return WINDOWS;
            case 7:
                return WEB;
            default:
                throw new IllegalArgumentException();
        }
    }
}
