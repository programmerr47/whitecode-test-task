package com.programmerr47.whitecodetesttask.api.responseObjects.summary;

import com.programmerr47.whitecodetesttask.api.util.OccupationType;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Object for representing occupation from their database.
 *
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public class Occupation {
    private static final String TYPE_TAG = "type";
    private static final String ID_TAG = "id";
    private static final String NAME_TAG = "name";

    private OccupationType type;
    private String id;
    private String name;

    private Occupation(Builder builder) {
        this.type = builder.type;
        this.id = builder.id;
        this.name = builder.name;
    }

    @SuppressWarnings("unused")
    public OccupationType getType() {
        return type;
    }

    @SuppressWarnings("unused")
    public String getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    private static class Builder {
        private OccupationType type;
        private String id;
        private String name;

        public Builder setType(OccupationType type) {
            this.type = type;
            return this;
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Occupation build() {
            return new Occupation(this);
        }
    }

    /**
     * Creates {@link Occupation} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of Occupation or null, if json is null
     */
    @SuppressWarnings("unused")
    public static Occupation getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setType(OccupationType.valueOf(jsonObject.optString(TYPE_TAG, null)))
                    .setId(jsonObject.optString(ID_TAG, null))
                    .setName(jsonObject.optString(NAME_TAG, null))
                    .build();
        }
    }

    /**
     * Creates list of {@link Occupation} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of Occupation or null, if json is null
     */
    @SuppressWarnings("unused")
    public static List<Occupation> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<Occupation> resultList = new ArrayList<Occupation>();
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
