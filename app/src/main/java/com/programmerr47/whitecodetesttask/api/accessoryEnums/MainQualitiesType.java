package com.programmerr47.whitecodetesttask.api.accessoryEnums;

/**
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public enum MainQualitiesType {
    INTELLIGENCE_AND_CREATIVITY,
    KINDNESS_AND_HONESTY,
    BEAUTY_AND_HEALTH,
    POWER_AND_WEALTH,
    COURAGE_AND_PERSEVERANCE,
    HUMOR_AND_LIFELOVE;

    public static MainQualitiesType getFromInt(int relationId) {
        switch (relationId) {
            case 1:
                return INTELLIGENCE_AND_CREATIVITY;
            case 2:
                return KINDNESS_AND_HONESTY;
            case 3:
                return BEAUTY_AND_HEALTH;
            case 4:
                return POWER_AND_WEALTH;
            case 5:
                return COURAGE_AND_PERSEVERANCE;
            case 6:
                return HUMOR_AND_LIFELOVE;
            default:
                return null;
        }
    }
}
