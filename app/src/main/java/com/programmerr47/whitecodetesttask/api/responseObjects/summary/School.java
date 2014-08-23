package com.programmerr47.whitecodetesttask.api.responseObjects.summary;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Object for representing school from their database.
 *
 * @author Michael Spitsin
 * @since 2014-08-22
 */
public class School {
    private static final String ID_TAG = "id";
    private static final String COUNTRY_TAG = "country";
    private static final String CITY_TAG = "city";
    private static final String NAME_TAG = "name";
    private static final String YEAR_FROM_TAG = "year_from";
    private static final String YEAR_TO_TAG = "year_to";
    private static final String YEAR_GRADUATED_TAG = "year_graduated";
    private static final String CLASS_TAG = "class";
    private static final String SPECIALITY_TAG = "speciality";
    private static final String TYPE_TAG = "type";
    private static final String TYPE_STR_TAG = "type_str";

    private int id;
    private int countryId;
    private int cityId;
    private String name;
    private int yearFrom;
    private int yearTo;
    private int yearGraduated;
    private String schoolClass;
    private String speciality;
    private int typeId;
    private String typeStr;

    public School(Builder builder) {
        this.id = builder.id;
        this.countryId = builder.countryId;
        this.cityId = builder.cityId;
        this.name = builder.name;
        this.yearFrom = builder.yearFrom;
        this.yearTo = builder.yearTo;
        this.yearGraduated = builder.yearGraduated;
        this.schoolClass = builder.schoolClass;
        this.speciality = builder.speciality;
        this.typeId = builder.typeId;
        this.typeStr = builder.typeStr;
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
    public int getYearFrom() {
        return yearFrom;
    }

    @SuppressWarnings("unused")
    public int getYearTo() {
        return yearTo;
    }

    @SuppressWarnings("unused")
    public int getYearGraduated() {
        return yearGraduated;
    }

    @SuppressWarnings("unused")
    public String getSchoolClass() {
        return schoolClass;
    }

    @SuppressWarnings("unused")
    public String getSpeciality() {
        return speciality;
    }

    @SuppressWarnings("unused")
    public int getTypeId() {
        return typeId;
    }

    @SuppressWarnings("unused")
    public String getTypeStr() {
        return typeStr;
    }

    private static class Builder {
        private int id;
        private int countryId;
        private int cityId;
        private String name;
        private int yearFrom;
        private int yearTo;
        private int yearGraduated;
        private String schoolClass;
        private String speciality;
        private int typeId;
        private String typeStr;
    
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
    
        public Builder setYearFrom(int yearFrom) {
            this.yearFrom = yearFrom;
            return this;
        }
    
        public Builder setYearTo(int yearTo) {
            this.yearTo = yearTo;
            return this;
        }
    
        public Builder setYearGraduated(int yearGraduated) {
            this.yearGraduated = yearGraduated;
            return this;
        }
    
        public Builder setSchoolClass(String schoolClass) {
            this.schoolClass = schoolClass;
            return this;
        }
    
        public Builder setSpeciality(String speciality) {
            this.speciality = speciality;
            return this;
        }
    
        public Builder setType(int typeId) {
            this.typeId = typeId;
            return this;
        }
    
        public Builder setTypeStr(String typeStr) {
            this.typeStr = typeStr;
            return this;
        }
    
        public School build() {
            return new School(this);
        }
    }

    /**
     * Creates {@link School} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of School or null, if json is null
     */
    @SuppressWarnings("unused")
    public static School getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setId(jsonObject.optInt(ID_TAG, 0))
                    .setCountryId(jsonObject.optInt(COUNTRY_TAG, 0))
                    .setCityId(jsonObject.optInt(CITY_TAG, 0))
                    .setName(jsonObject.optString(NAME_TAG, null))
                    .setYearFrom(jsonObject.optInt(YEAR_FROM_TAG, 0))
                    .setYearTo(jsonObject.optInt(YEAR_TO_TAG, 0))
                    .setYearGraduated(jsonObject.optInt(YEAR_GRADUATED_TAG, 0))
                    .setSchoolClass(jsonObject.optString(CLASS_TAG, null))
                    .setSpeciality(jsonObject.optString(SPECIALITY_TAG, null))
                    .setType(jsonObject.optInt(TYPE_TAG, 0))
                    .setTypeStr(jsonObject.optString(TYPE_STR_TAG, null))
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
    public static List<School> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<School> resultList = new ArrayList<School>();
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
