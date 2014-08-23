package com.programmerr47.whitecodetesttask.api.requests;

import com.programmerr47.whitecodetesttask.api.Account;
import com.programmerr47.whitecodetesttask.api.requests.requestParams.FriendsGetParams;
import com.programmerr47.whitecodetesttask.api.requests.util.RequestUtils;
import com.programmerr47.whitecodetesttask.api.util.Constants;
import com.programmerr47.whitecodetesttask.api.util.JSONUtil;

import org.json.JSONObject;

import java.util.List;

/**
 * Class that holds all friends requests.
 * For more information use: https://vk.com/dev/friends
 * <br><br>
 * <strong>Note that</strong> now implemented only get method.
 *
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public class FriendRequests {
    private static final String RESPONSE_TAG = "response";
    private static final String ITEMS_TAG = "items";

    private static final String FRIENDS_GET_METHOD_NAME = "friends.get";

    private Account account;

    public FriendRequests(Account account) {
        this.account = account;
    }

    public List<Integer> get(FriendsGetParams params) {
        params.signUp(account);

        String url = Constants.VK_BASE_URL + FRIENDS_GET_METHOD_NAME + Constants.REQUEST_PARAMS_BEGIN_SYMBOL + params;
        JSONObject response = RequestUtils.sendGetRequest(url);

        if (response == null) {
            return null;
        }

        return JSONUtil.getIntegerList(response.optJSONObject(RESPONSE_TAG).optJSONArray(ITEMS_TAG));
    }
}
