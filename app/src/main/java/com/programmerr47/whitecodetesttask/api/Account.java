package com.programmerr47.whitecodetesttask.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Class-Holder. This class keeps access token that receives from vk server
 * and id of user that has been logged in.
 *
 * @author Michael Spitsin
 * @since 2014-08
 */
public class Account {
    private static final String ACCESS_TOKEN = "VK.ACCESS_TOKEN";
    private static final String USER_ID = "VK.USER_ID";

    private Context mContext;
    private String mAccessToken;
    private String mUserId;

    public Account(Context context) {
        mContext = context;
        restore();
    }

    @SuppressWarnings("unused")
    public String getAccessToken() {
        return mAccessToken;
    }

    @SuppressWarnings("unused")
    public String getUserId() {
        return mUserId;
    }

    @SuppressWarnings("unused")
    public void setAccessToken(String accessToken) {
        mAccessToken = accessToken;
    }

    @SuppressWarnings("unused")
    public void setUserId(String userId) {
        mUserId = userId;
    }

    /**
     * Checks has object all fields or not.
     *
     * @return true, if access toke and user id exist or false otherwise
     */
    @SuppressWarnings("unused")
    public boolean isCorrect() {
        return (mAccessToken != null) && (mUserId != null);
    }

    /**
     * Saves necessary data using {@link android.content.SharedPreferences}.
     */
    @SuppressWarnings("unused")
    public void save() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(ACCESS_TOKEN, mAccessToken);
        editor.putString(USER_ID, mUserId);

        editor.apply();
    }

    /**
     * Clear all data, that saved.
     */
    @SuppressWarnings("unused")
    public void clear(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = prefs.edit();

        editor.remove(ACCESS_TOKEN);
        editor.remove(USER_ID);

        editor.apply();

        mAccessToken = null;
        mUserId = null;
    }

    /**
     * Restores access token and user id for further use.
     */
    private void restore() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        mAccessToken = prefs.getString(ACCESS_TOKEN, null);
        mUserId = prefs.getString(USER_ID, null);
    }
}
