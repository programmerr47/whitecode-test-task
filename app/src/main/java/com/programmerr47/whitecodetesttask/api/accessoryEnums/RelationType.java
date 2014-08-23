package com.programmerr47.whitecodetesttask.api.accessoryEnums;

/**
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public enum RelationType {
    NOT_MARRIED,
    HAS_PARTNER,
    ENGAGED,
    MARRIED,
    COMPLICATED,
    IN_ACTIVE_SEARCH,
    IN_LOVE;

    public static RelationType getFromInt(int relationId) {
        switch (relationId) {
            case 1:
                return NOT_MARRIED;
            case 2:
                return HAS_PARTNER;
            case 3:
                return ENGAGED;
            case 4:
                return MARRIED;
            case 5:
                return COMPLICATED;
            case 6:
                return IN_ACTIVE_SEARCH;
            case 7:
                return IN_LOVE;
            default:
                return null;
        }
    }
}
