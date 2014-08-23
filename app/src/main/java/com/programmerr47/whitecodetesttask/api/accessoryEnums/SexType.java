package com.programmerr47.whitecodetesttask.api.accessoryEnums;

/**
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public enum SexType {
    MAN,
    WOMAN,
    UNKNOWN;

    public static SexType getFromInt(int secTypeId) {
        switch (secTypeId) {
            case 0:
                return UNKNOWN;
            case 1:
                return WOMAN;
            case 2:
                return MAN;
            default:
                return null;
        }
    }
}
