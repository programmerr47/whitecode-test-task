package com.programmerr47.whitecodetesttask.api.requests.util;

import android.util.Log;

import com.programmerr47.whitecodetesttask.api.util.Utils;

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
            connection.setConnectTimeout(30000);
            connection.setReadTimeout(30000);
            connection.setUseCaches(false);
            connection.setDoOutput(false);
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept-Encoding", "gzip");
            int code=connection.getResponseCode();
            Log.v(LOG_TAG, "code = " + code);
            Log.v(LOG_TAG, "getContentEncoding = " + connection.getContentEncoding());
            Log.v(LOG_TAG, "getRequestMethod = " + connection.getRequestMethod());
            Log.v(LOG_TAG, "getResponseMessage = " + connection.getResponseMessage());
            Log.v(LOG_TAG, "getInputStream = " + connection.getInputStream());

            InputStream is = new BufferedInputStream(connection.getInputStream(), 8192);
            String enc=connection.getHeaderField("Content-Encoding");
            if(enc!=null && enc.equalsIgnoreCase("gzip")) {
                is = new GZIPInputStream(is);
            }
            return new JSONObject(Utils.convertStreamToString(is));
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
