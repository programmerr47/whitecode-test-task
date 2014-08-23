package com.programmerr47.whitecodetesttask.api.accessoryEnums;

/**
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public enum PoliticalType {
    COMMUNIST,
    SOCIALIST,
    MODERATE,
    LIBERAL,
    CONSERVATIVE,
    MONARCHIC,
    ULTRACONSERVATIVE,
    INDIFFERENT,
    LIBERTARIAN;

    public static PoliticalType getFromInt(int relationId) {
        switch (relationId) {
            case 1:
                return COMMUNIST;
            case 2:
                return SOCIALIST;
            case 3:
                return MODERATE;
            case 4:
                return LIBERAL;
            case 5:
                return CONSERVATIVE;
            case 6:
                return MONARCHIC;
            case 7:
                return ULTRACONSERVATIVE;
            case 8:
                return INDIFFERENT;
            case 9:
                return LIBERTARIAN;
            default:
                return null;
        }
    }
}
