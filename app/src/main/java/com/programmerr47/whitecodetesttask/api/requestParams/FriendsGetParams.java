package com.programmerr47.whitecodetesttask.api.requestParams;

import com.programmerr47.whitecodetesttask.api.util.FriendInfoOptionalFields;
import com.programmerr47.whitecodetesttask.api.util.FriendsOrder;
import com.programmerr47.whitecodetesttask.api.util.NameCase;

import java.util.List;

/**
 * @author Michael Spitsin
 * @since 2014-08-22
 */
public class FriendsGetParams implements RequestParams{
    private static final String USER_ID_PARAM_NAME = "user_id";
    private static final String ORDER_PARAM_NAME = "order";
    private static final String LIST_ID_PARAM_NAME = "list_id";
    private static final String COUNT_PARAM_NAME = "count";
    private static final String OFFSET_PARAM_NAME = "offset";
    private static final String FIELDS_TYPE_PARAM_NAME = "fields";
    private static final String NAME_CASE_PARAM_NAME = "name_case";

    private String userId;
    private FriendsOrder order;
    private String listId;
    private String count;
    private String offset;
    private List<FriendInfoOptionalFields> fields;
    private NameCase nameCase;

    private FriendsGetParams(Builder builder) {
        this.userId = builder.userId;
        this.order = builder.order;
        this.listId = builder.listId;
        this.count = builder.count;
        this.offset = builder.offset;
        this.fields = builder.fields;
        this.nameCase = builder.nameCase;
    }

    @Override
    public String getQuery() {
        StringBuilder result = new StringBuilder();

        ParamUtils.addParameterIfNeed(result, USER_ID_PARAM_NAME, userId);
        ParamUtils.addParameterIfNeed(result, ORDER_PARAM_NAME, order);
        ParamUtils.addParameterIfNeed(result, LIST_ID_PARAM_NAME, listId);
        ParamUtils.addParameterIfNeed(result, COUNT_PARAM_NAME, count);
        ParamUtils.addParameterIfNeed(result, OFFSET_PARAM_NAME, offset);
        ParamUtils.addCollectionParametersIfNeed(result, FIELDS_TYPE_PARAM_NAME, fields);
        ParamUtils.addParameterIfNeed(result, NAME_CASE_PARAM_NAME, nameCase);

        return ParamUtils.removeFirstCharacterIfDelimiter(result.toString());
    }

    @Override
    public String toString() {
        return getQuery();
    }

    public static class Builder {
        private String userId;
        private FriendsOrder order;
        private String listId;
        private String count;
        private String offset;
        private List<FriendInfoOptionalFields> fields;
        private NameCase nameCase;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setOrder(FriendsOrder order) {
            this.order = order;
            return this;
        }

        public Builder setListId(String listId) {
            this.listId = listId;
            return this;
        }

        public Builder setCount(String count) {
            this.count = count;
            return this;
        }

        public Builder setOffset(String offset) {
            this.offset = offset;
            return this;
        }

        public Builder setFields(List<FriendInfoOptionalFields> fields) {
            this.fields = fields;
            return this;
        }

        public Builder setNameCase(NameCase nameCase) {
            this.nameCase = nameCase;
            return this;
        }

        public FriendsGetParams build() {
            return new FriendsGetParams(this);
        }
    }
}
