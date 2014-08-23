package com.programmerr47.whitecodetesttask.api.accessoryEnums;

/**
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public enum MainInLifeType {
    FAMILY_AND_CHILDREN,
    CAREER_AND_MONEY,
    ENTERTAINMENT_AND_LEISURE,
    SCIENCE_AND_RESEARCH,
    IMPROVEMENT_OF_THE_WORLD,
    SELF_DEVELOPMENT,
    BEAUTY_AND_ART,
    FAME_AND_INFLUENCE;

    public static MainInLifeType getFromInt(int relationId) {
        switch (relationId) {
            case 1:
                return FAMILY_AND_CHILDREN;
            case 2:
                return CAREER_AND_MONEY;
            case 3:
                return ENTERTAINMENT_AND_LEISURE;
            case 4:
                return SCIENCE_AND_RESEARCH;
            case 5:
                return IMPROVEMENT_OF_THE_WORLD;
            case 6:
                return SELF_DEVELOPMENT;
            case 7:
                return BEAUTY_AND_ART;
            case 8:
                return FAME_AND_INFLUENCE;
            default:
                return null;
        }
    }
}
