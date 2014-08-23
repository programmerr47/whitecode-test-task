package com.programmerr47.whitecodetesttask.api.util;

/**
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public enum Platform {
    mobile,
    iphone,
    ipad,
    android,
    wphone,
    windows,
    web;

    public static Platform getPlatformFromInt(int platformId) {
        switch (platformId) {
            case 1:
                return mobile;
            case 2:
                return iphone;
            case 3:
                return ipad;
            case 4:
                return android;
            case 5:
                return wphone;
            case 6:
                return windows;
            case 7:
                return web;
            default:
                throw new IllegalArgumentException();
        }
    }
}
