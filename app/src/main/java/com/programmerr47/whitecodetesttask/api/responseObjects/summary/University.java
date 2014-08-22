package com.programmerr47.whitecodetesttask.api.responseObjects.summary;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Object for representing university from their database.
 *
 * @author Michael Spitsin
 * @since 2014-08-22
 */
public class University {
    private static final String ID_TAG = "id";
    private static final String COUNTRY_TAG = "country";
    private static final String CITY_TAG = "city";
    private static final String NAME_TAG = "name";
    private static final String FACULTY_TAG = "faculty";
    private static final String FACULTY_NAME_TAG = "faculty_name";
    private static final String CHAIR_TAG = "chair";
    private static final String CHAIR_NAME_TAG = "chair_name";
    private static final String GRADUATION_TAG = "graduation";
    
    private String id;
    private String countryId;
    private String cityId;
    private String name;
    private String facultyId;
    private String facultyName;
    private String chairId;
    private String chairName;
    private int graduationYear;

    private University(Builder builder) {
        this.id = builder.id;
        this.countryId = builder.countryId;
        this.cityId = builder.cityId;
        this.name = builder.name;
        this.facultyId = builder.facultyId;
        this.facultyName = builder.facultyName;
        this.chairId = builder.chairId;
        this.chairName = builder.chairName;
        this.graduationYear = builder.graduationYear;
    }

    public String getId() {
        return id;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getCityId() {
        return cityId;
    }

    public String getName() {
        return name;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public String getChairId() {
        return chairId;
    }

    public String getChairName() {
        return chairName;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    private static class Builder {
        private String id;
        private String countryId;
        private String cityId;
        private String name;
        private String facultyId;
        private String facultyName;
        private String chairId;
        private String chairName;
        private int graduationYear;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setCountryId(String countryId) {
            this.countryId = countryId;
            return this;
        }

        public Builder setCityId(String cityId) {
            this.cityId = cityId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setFacultyId(String facultyId) {
            this.facultyId = facultyId;
            return this;
        }

        public Builder setFacultyName(String facultyName) {
            this.facultyName = facultyName;
            return this;
        }

        public Builder setChairId(String chairId) {
            this.chairId = chairId;
            return this;
        }

        public Builder setChairName(String chairName) {
            this.chairName = chairName;
            return this;
        }

        public Builder setGraduationYear(int graduationYear) {
            this.graduationYear = graduationYear;
            return this;
        }

        public University build() {
            return new University(this);
        }
    }


    /**
     * Creates {@link University} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of University or null, if json is null
     */
    public static University getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setId(jsonObject.optString(ID_TAG, null))
                    .setCountryId(jsonObject.optString(COUNTRY_TAG, null))
                    .setCityId(jsonObject.optString(CITY_TAG, null))
                    .setName(jsonObject.optString(NAME_TAG, null))
                    .setFacultyId(jsonObject.optString(FACULTY_TAG, null))
                    .setFacultyName(jsonObject.optString(FACULTY_NAME_TAG, null))
                    .setChairId(jsonObject.optString(CHAIR_TAG, null))
                    .setChairName(jsonObject.optString(CHAIR_NAME_TAG, null))
                    .setGraduationYear(jsonObject.optInt(GRADUATION_TAG, 0))
                    .build();
        }
    }

    /**
     * Creates list of {@link University} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of University or null, if json is null
     */
    public static List<University> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<University> resultList = new ArrayList<University>();
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
