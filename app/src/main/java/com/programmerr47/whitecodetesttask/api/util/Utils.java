package com.programmerr47.whitecodetesttask.api.util;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Arrays;
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

    public static String convertStreamToString(InputStream is) throws IOException {
        InputStreamReader r = new InputStreamReader(is);
        StringWriter sw = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Log.v("UTILS", "InputStream = " + is);
            for (int n; (n = r.read(buffer)) != -1;) {
                Log.v("UTILS", "buffer = " + Arrays.toString(buffer));
                sw.write(buffer, 0, n);
            }
        }
        finally{
            try {
                is.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return sw.toString();
    }
}
