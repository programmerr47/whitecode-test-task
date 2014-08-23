package com.programmerr47.whitecodetesttask.api.util;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Common function for post-handle some JSON Objects.
 *
 * @author Michael Spitsin
 * @since 2014-07-25
 */
public class JSONUtil {

    /**
     * Converts jsonArray (that consists of strings) to list of strings.
     *
     * @param jsonArray
     * @return list of strings that contained in given JSON Array
     */
    public static List<String> getStringList(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }

        List<String> result = new ArrayList<String>();
        for (int i = 0; i < jsonArray.length(); i++) {
            String element = jsonArray.optString(i, null);

            if (element != null) {
                result.add(element);
            }
        }

        return result;
    }

    /**
     * Converts jsonArray (that consists of integers) to list of integers.
     *
     * @param jsonArray
     * @return list of integers that contained in given JSON Array
     */
    public static List<Integer> getIntegerList(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < jsonArray.length(); i++) {
            int element = jsonArray.optInt(i, 0);

            if (element != 0) {
                result.add(element);
            }
        }

        return result;
    }

    public static boolean intToBoolean(int i) {
        return i != 0;
    }
}
