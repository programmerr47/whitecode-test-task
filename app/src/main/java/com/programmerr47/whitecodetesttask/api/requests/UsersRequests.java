package com.programmerr47.whitecodetesttask.api.requests;

import com.programmerr47.whitecodetesttask.api.Account;
import com.programmerr47.whitecodetesttask.api.requests.requestParams.UsersGetParams;
import com.programmerr47.whitecodetesttask.api.requests.util.RequestUtils;
import com.programmerr47.whitecodetesttask.api.responseObjects.User;
import com.programmerr47.whitecodetesttask.api.util.Constants;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that holds all users requests.
 * For more information use: https://vk.com/dev/users
 * <br><br>
 * <strong>Note that</strong> now implemented only get method.
 *
 * @author Michael Spitsin
 * @since 2014-08-23
 */
@SuppressWarnings("unused")
public class UsersRequests {
    private static final String RESPONSE_TAG = "response";

    private static final String USERS_GET_METHOD_NAME = "users.get";

    private Account account;

    public UsersRequests(Account account) {
        this.account = account;
    }

    public List<User> get(UsersGetParams params) {
        if ((params.getUserIds() != null) && (params.getUserIds().size() > 1000)) {
            throw new IllegalArgumentException();
        }

        params.signUp(account);

        String url = Constants.VK_BASE_URL + USERS_GET_METHOD_NAME + Constants.REQUEST_PARAMS_BEGIN_SYMBOL + params;
        JSONObject response = RequestUtils.sendGetRequest(url);

        if (response == null) {
            return null;
        }

        if (response.optJSONArray(RESPONSE_TAG) == null) {
            return new ArrayList<User>();
        }

        return User.getFromJSONArray(response.optJSONArray(RESPONSE_TAG));
    }
}
