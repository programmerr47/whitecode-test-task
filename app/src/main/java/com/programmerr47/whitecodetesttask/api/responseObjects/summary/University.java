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
    
    private int id;
    private int countryId;
    private int cityId;
    private String name;
    private int facultyId;
    private String facultyName;
    private int chairId;
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

    @SuppressWarnings("unused")
    public int getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public int getCountryId() {
        return countryId;
    }

    @SuppressWarnings("unused")
    public int getCityId() {
        return cityId;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public int getFacultyId() {
        return facultyId;
    }

    @SuppressWarnings("unused")
    public String getFacultyName() {
        return facultyName;
    }

    @SuppressWarnings("unused")
    public int getChairId() {
        return chairId;
    }

    @SuppressWarnings("unused")
    public String getChairName() {
        return chairName;
    }

    @SuppressWarnings("unused")
    public int getGraduationYear() {
        return graduationYear;
    }

    private static class Builder {
        private int id;
        private int countryId;
        private int cityId;
        private String name;
        private int facultyId;
        private String facultyName;
        private int chairId;
        private String chairName;
        private int graduationYear;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setCountryId(int countryId) {
            this.countryId = countryId;
            return this;
        }

        public Builder setCityId(int cityId) {
            this.cityId = cityId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setFacultyId(int facultyId) {
            this.facultyId = facultyId;
            return this;
        }

        public Builder setFacultyName(String facultyName) {
            this.facultyName = facultyName;
            return this;
        }

        public Builder setChairId(int chairId) {
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
    @SuppressWarnings("unused")
    public static University getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setId(jsonObject.optInt(ID_TAG, 0))
                    .setCountryId(jsonObject.optInt(COUNTRY_TAG, 0))
                    .setCityId(jsonObject.optInt(CITY_TAG, 0))
                    .setName(jsonObject.optString(NAME_TAG, null))
                    .setFacultyId(jsonObject.optInt(FACULTY_TAG, 0))
                    .setFacultyName(jsonObject.optString(FACULTY_NAME_TAG, null))
                    .setChairId(jsonObject.optInt(CHAIR_TAG, 0))
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
    @SuppressWarnings("unused")
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
