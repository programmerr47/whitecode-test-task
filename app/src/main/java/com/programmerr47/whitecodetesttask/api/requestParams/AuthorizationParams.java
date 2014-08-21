package com.programmerr47.whitecodetesttask.api.requestParams;

import com.programmerr47.whitecodetesttask.api.util.DisplayType;
import com.programmerr47.whitecodetesttask.api.util.Permissions;

import java.util.List;

/**
 * Class that represents params for authorization url
 *
 * @author Michael Spitsin
 * @since 2014-08-21
 */
public class AuthorizationParams implements RequestParams {
    private static final String CLIENT_ID_PARAM_NAME = "client_id";
    private static final String SCOPE_PARAM_NAME = "scope";
    private static final String REDIRECT_URI_PARAM_NAME = "redirect_uri";
    private static final String DISPLAY_PARAM_NAME = "display";
    private static final String VERSION_PARAM_NAME = "v";
    private static final String RESPONSE_TYPE_PARAM_NAME = "response_type";
    private static final String REVOKE_PARAM_NAME = "revoke";

    private String appId;
    private List<Permissions> permissions;
    private String redirectUrl;
    private DisplayType displayType;
    private String apiVersion;
    private String responseType = "token";
    private String revoke;

    private AuthorizationParams(Builder builder) {
        this.appId = builder.appId;
        this.permissions = builder.permissions;
        this.redirectUrl = builder.redirectUrl;
        this.displayType = builder.displayType;
        this.apiVersion = builder.apiVersion;
        this.revoke = builder.revoke;
    }

    @Override
    public String getQuery() {
        StringBuilder result = new StringBuilder();

        ParamUtils.addParameterIfNeed(result, CLIENT_ID_PARAM_NAME, appId);
        ParamUtils.addCollectionParametersIfNeed(result, SCOPE_PARAM_NAME, permissions);
        ParamUtils.addParameterIfNeed(result, REDIRECT_URI_PARAM_NAME, redirectUrl);
        ParamUtils.addParameterIfNeed(result, DISPLAY_PARAM_NAME, displayType);
        ParamUtils.addParameterIfNeed(result, VERSION_PARAM_NAME, apiVersion);
        ParamUtils.addParameterIfNeed(result, RESPONSE_TYPE_PARAM_NAME, responseType);
        ParamUtils.addParameterIfNeed(result, REVOKE_PARAM_NAME, revoke);

        return ParamUtils.removeFirstCharacterIfDelimiter(result.toString());
    }

    @Override
    public String toString() {
        return getQuery();
    }

    public static class Builder {
        private String appId;
        private List<Permissions> permissions;
        private String redirectUrl;
        private DisplayType displayType;
        private String apiVersion;
        private String revoke;

        public Builder setAppId(String appId) {
            this.appId = appId;
            return this;
        }

        public Builder setPermissions(List<Permissions> permissions) {
            this.permissions = permissions;
            return this;
        }

        public Builder setRedirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
            return this;
        }

        public Builder setDisplayType(DisplayType displayType) {
            this.displayType = displayType;
            return this;
        }

        public Builder setApiVersion(String apiVersion) {
            this.apiVersion = apiVersion;
            return this;
        }

        public Builder setRevoke(String revoke) {
            this.revoke = revoke;
            return this;
        }

        public AuthorizationParams build() {
            return new AuthorizationParams(this);
        }
    }
}
