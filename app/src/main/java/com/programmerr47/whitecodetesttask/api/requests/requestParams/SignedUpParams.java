package com.programmerr47.whitecodetesttask.api.requests.requestParams;

import com.programmerr47.whitecodetesttask.api.Account;
import com.programmerr47.whitecodetesttask.api.util.Constants;

/**
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public class SignedUpParams implements RequestParams{
    private static final String ACCESS_TOKEN_PARAM_NAME = "access_token";
    private static final String API_VERSION_PARAM_NAME = "v";

    private String accessToken;
    private String version;

    protected SignedUpParams(Builder builder) {
        this.accessToken = builder.accessToken;
        this.version = builder.version;
    }

    public void signUp(Account account) {
        this.accessToken = account.getAccessToken();
        this.version = Constants.API_VERSION;
    }

    @Override
    public String getQuery() {
        StringBuilder result = new StringBuilder();

        ParamUtils.addParameterIfNeed(result, ACCESS_TOKEN_PARAM_NAME, accessToken);
        ParamUtils.addParameterIfNeed(result, API_VERSION_PARAM_NAME, version);

        return ParamUtils.removeFirstCharacterIfDelimiter(result.toString());
    }

    @Override
    public String toString() {
        return getQuery();
    }

    public static class Builder {
        private String accessToken;
        private String version;

        public Builder setAccessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public Builder setVersion(String version) {
            this.version = version;
            return this;
        }

        public SignedUpParams build() {
            return new SignedUpParams(this);
        }
    }
}
