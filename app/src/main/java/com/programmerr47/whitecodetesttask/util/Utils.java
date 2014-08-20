package com.programmerr47.whitecodetesttask.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Container for all general functions.
 *
 * @author Michael Spitsin
 * @since 2014-08-20
 */
public class Utils {

    public static String extractPattern(String string, String pattern){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(string);
        if (!m.find())
            return null;
        return m.toMatchResult().group(1);
    }
}
