package com.programmerr47.whitecodetesttask.api.responseObjects.summary;

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

    private String id;
    private String countryId;
    private String cityId;
    private String name;
    private int yearFrom;
    private int yearTo;
    private int yearGraduated;
}
