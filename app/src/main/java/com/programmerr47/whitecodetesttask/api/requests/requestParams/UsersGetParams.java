package com.programmerr47.whitecodetesttask.api.requests.requestParams;

import com.programmerr47.whitecodetesttask.api.accessoryEnums.UserInfoOptionalField;
import com.programmerr47.whitecodetesttask.api.accessoryEnums.NameCase;

import java.util.List;

/**
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public class UsersGetParams extends SignedUpParams {
    private static final String USER_IDS_PARAM_NAME = "user_ids";
    private static final String FIELDS_PARAM_NAME = "fields";
    private static final String NAME_CASE_PARAM_NAME = "name_case";

    private List<String> userIds;
    private List<UserInfoOptionalField> fields;
    private NameCase nameCase;

    protected UsersGetParams(Builder builder) {
        super(builder);
        this.userIds = builder.userIds;
        this.fields = builder.fields;
        this.nameCase = builder.nameCase;
    }

    @SuppressWarnings("unused")
    public List<String> getUserIds() {
        return userIds;
    }

    @Override
    public String getQuery() {
        StringBuilder result = new StringBuilder(super.getQuery());

        ParamUtils.addCollectionParametersIfNeed(result, USER_IDS_PARAM_NAME, userIds);
        ParamUtils.addCollectionParametersIfNeed(result, FIELDS_PARAM_NAME, fields);
        ParamUtils.addParameterIfNeed(result, NAME_CASE_PARAM_NAME, nameCase);

        return ParamUtils.removeFirstCharacterIfDelimiter(result.toString());
    }

    public static class Builder extends SignedUpParams.Builder {
        private List<String> userIds;
        private List<UserInfoOptionalField> fields;
        private NameCase nameCase;

        public Builder setUserIds(List<String> userIds) {
            this.userIds = userIds;
            return this;
        }

        public Builder setFields(List<UserInfoOptionalField> fields) {
            this.fields = fields;
            return this;
        }

        public Builder setNameCase(NameCase nameCase) {
            this.nameCase = nameCase;
            return this;
        }

        public UsersGetParams build() {
            return new UsersGetParams(this);
        }
    }
}
