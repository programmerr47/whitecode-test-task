package com.programmerr47.whitecodetesttask.api.accessoryEnums;

/**
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public enum RelationToAnythingType {
    VERY_NEGATIVE,
    NEGATIVE,
    NEUTRAL,
    COMPROMISE,
    POSITIVE;

    public static RelationToAnythingType getFromInt(int relationId) {
        switch (relationId) {
            case 1:
                return VERY_NEGATIVE;
            case 2:
                return NEGATIVE;
            case 3:
                return NEUTRAL;
            case 4:
                return COMPROMISE;
            case 5:
                return POSITIVE;
            default:
                return null;
        }
    }
}
