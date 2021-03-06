package com.programmerr47.whitecodetesttask.api.requests.requestParams;

/**
 * Main interface for all classes, that represents optional (and not) parameters of
 * some queries in api requests.
 *
 * @author Michael Spitsin
 * @since 2014-08-15
 */
public interface RequestParams {

    /**
     * Calls when building final url for api request.
     *
     * @return query with certain params
     */
    String getQuery();
}