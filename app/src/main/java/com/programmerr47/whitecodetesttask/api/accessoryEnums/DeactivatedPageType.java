package com.programmerr47.whitecodetesttask.api.accessoryEnums;

/**
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public enum DeactivatedPageType {
    deleted,
    banned;

    public static DeactivatedPageType optValue(String name) {
       try {
           return valueOf(name);
       } catch (NullPointerException e) {
           return null;
       } catch (IllegalArgumentException e) {
           return null;
       }
    }
}
