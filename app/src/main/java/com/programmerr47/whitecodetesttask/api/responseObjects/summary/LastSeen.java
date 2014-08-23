package com.programmerr47.whitecodetesttask.api.responseObjects.summary;

import com.programmerr47.whitecodetesttask.api.accessoryEnums.Platform;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Object for representing the last stay of user in vk from som platform.
 *
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public class LastSeen {
    private static final String TIME_TAG = "time";
    private static final String PLATFORM_TAG = "platform";

    private int time;
    private Platform platform;

    private LastSeen(Builder builder) {
        this.time = builder.time;
        this.platform = builder.platform;
    }

    @SuppressWarnings("unused")
    public int getTime() {
        return time;
    }

    @SuppressWarnings("unused")
    public Platform getPlatform() {
        return platform;
    }

    private static class Builder {
        private int time;
        private Platform platform;

        public Builder setTime(int time) {
            this.time = time;
            return this;
        }

        public Builder setPlatform(Platform platform) {
            this.platform = platform;
            return this;
        }

        public LastSeen build() {
            return new LastSeen(this);
        }
    }

    /**
     * Creates {@link LastSeen} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of School or null, if json is null
     */
    @SuppressWarnings("unused")
    public static LastSeen getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setTime(jsonObject.optInt(TIME_TAG, 0))
                    .setPlatform(Platform.getFromInt(jsonObject.optInt(PLATFORM_TAG, 7)))
                    .build();
        }
    }

    /**
     * Creates list of {@link School} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of School or null, if json is null
     */
    @SuppressWarnings("unused")
    public static List<LastSeen> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<LastSeen> resultList = new ArrayList<LastSeen>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.optJSONObject(i);
                if (jsonObject != null) {
                    resultList.add(getFromJSONObject(jsonObject));
                }
            }
            return resultList;
        }
    }
}
