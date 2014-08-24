package com.programmerr47.whitecodetesttask.api.accessoryEnums;

/**
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public enum OccupationType {
    work,
    school,
    university;

    public static OccupationType optValue(String name) {
        try {
            return valueOf(name);
        } catch (NullPointerException e) {
            return null;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
