package com.programmerr47.whitecodetesttask.api.responseObjects.summary;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for representing any relative of user.
 *
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public class Relative {
    private static final String ID_TAG = "id";
    private static final String TYPE_TAG = "type";
    private static final String NAME_TAG = "name";

    private int userId;
    private String type;
    private String name;

    private Relative(Builder builder) {
        this.userId = builder.userId;
        this.type = builder.type;
        this.name = builder.name;
    }

    @SuppressWarnings("unused")
    public int getUserId() {
        return userId;
    }

    @SuppressWarnings("unused")
    public String getType() {
        return type;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    private static class Builder {
        private int userId;
        private String type;
        private String name;

        public Builder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Relative build() {
            return new Relative(this);
        }
    }

    /**
     * Creates {@link Relative} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of Relative or null, if json is null
     */
    @SuppressWarnings("unused")
    public static Relative getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setUserId(jsonObject.optInt(ID_TAG, 0))
                    .setName(jsonObject.optString(NAME_TAG, null))
                    .setType(jsonObject.optString(TYPE_TAG, null))
                    .build();
        }
    }

    /**
     * Creates list of {@link Relative} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of Relative or null, if json is null
     */
    @SuppressWarnings("unused")
    public static List<Relative> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<Relative> resultList = new ArrayList<Relative>();
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
