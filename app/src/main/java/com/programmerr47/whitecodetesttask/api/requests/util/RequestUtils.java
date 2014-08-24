package com.programmerr47.whitecodetesttask.api.requests.util;

import com.programmerr47.whitecodetesttask.api.util.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/**
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public class RequestUtils {
    private static final String LOG_TAG = "REQUEST_UTILS";

    public static JSONObject sendGetRequest(String url) {
        HttpURLConnection connection=null;
        try{
            connection = (HttpURLConnection)new URL(url).openConnection();
            connection.setConnectTimeout(6000);
            connection.setReadTimeout(6000);
            connection.setUseCaches(false);
            connection.setDoOutput(false);
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept-Encoding", "gzip");

            InputStream is = new BufferedInputStream(connection.getInputStream(), 8192);
            String enc=connection.getHeaderField("Content-Encoding");
            if(enc!=null && enc.equalsIgnoreCase("gzip")) {
                is = new GZIPInputStream(is);
            }
            return new JSONObject(Util.convertStreamToString(is));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } finally{
            if(connection!=null)
                connection.disconnect();
        }
    }
}
