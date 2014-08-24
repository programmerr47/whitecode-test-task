package com.programmerr47.whitecodetesttask.representation.tasks;

import android.content.Intent;

import com.programmerr47.whitecodetesttask.api.Account;
import com.programmerr47.whitecodetesttask.api.accessoryEnums.FriendInfoOptionalField;
import com.programmerr47.whitecodetesttask.api.accessoryEnums.FriendsOrder;
import com.programmerr47.whitecodetesttask.api.accessoryEnums.NameCase;
import com.programmerr47.whitecodetesttask.api.accessoryEnums.UserInfoOptionalField;
import com.programmerr47.whitecodetesttask.api.requests.APIRequests;
import com.programmerr47.whitecodetesttask.api.requests.FriendRequests;
import com.programmerr47.whitecodetesttask.api.requests.UsersRequests;
import com.programmerr47.whitecodetesttask.api.requests.requestParams.FriendsGetParams;
import com.programmerr47.whitecodetesttask.api.requests.requestParams.UsersGetParams;
import com.programmerr47.whitecodetesttask.api.responseObjects.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Spitsin
 * @since 2014-08-24
 */
public class GetFriendsInfoTask extends AsyncTaskWithListener<FriendsGetParams, Void, List<User>> {
    private static final int USER_PACK = 200;

    private Account account;

    public GetFriendsInfoTask(Account account) {
        this.account = account;
    }

    @Override
    protected List<User> doInBackground(FriendsGetParams... friendsGetParamsArray) {
        if (friendsGetParamsArray.length > 0) {
            FriendsGetParams params = friendsGetParamsArray[0];
            List<FriendInfoOptionalField> friendFields = params.getFields();
            List<UserInfoOptionalField> userFields = convertFriendOptFieldsToUserOptFields(friendFields);

            APIRequests requests = new APIRequests(account);
            FriendRequests friendRequests = requests.getFriendsRequests();
            UsersRequests usersRequests = requests.getUsersRequests();

            List<Integer> friendIds = friendRequests.get(new FriendsGetParams.Builder().setOrder(FriendsOrder.name).build());
            if ((friendIds != null) && (friendIds.size() > 0)) {
                List<User> result = new ArrayList<User>();
                List<String> userIdsPack = new ArrayList<String>();
                int counter = 0;

                for (Integer friendId : friendIds) {
                    if (counter < USER_PACK) {
                        userIdsPack.add("" + friendId);
                        counter++;
                    } else {
                        handleIdsPack(userIdsPack, userFields, params.getNameCase(), usersRequests, result);

                        counter = 0;
                        userIdsPack.clear();
                    }
                }

                if (counter > 0) {
                    handleIdsPack(userIdsPack, userFields, params.getNameCase(), usersRequests, result);
                }

                return result;
            }
        }

        return new ArrayList<User>();
    }

    private void handleIdsPack(List<String> ids, List<UserInfoOptionalField> fields, NameCase nameCase, UsersRequests usersRequests, List<User> allFriends) {
        UsersGetParams usersGetParams = new UsersGetParams.Builder()
                .setUserIds(ids)
                .setFields(fields)
                .setNameCase(nameCase)
                .build();

        List<User> users = usersRequests.get(usersGetParams);

        if (users != null) {
            allFriends.addAll(users);
        }
    }

    private List<UserInfoOptionalField> convertFriendOptFieldsToUserOptFields(List<FriendInfoOptionalField> friendFields) {
        List<UserInfoOptionalField> result = new ArrayList<UserInfoOptionalField>();

        for (FriendInfoOptionalField friendField : friendFields) {
            UserInfoOptionalField userField = UserInfoOptionalField.optValue(friendField.toString());

            if (userField != null) {
                result.add(userField);
            }
        }

        return result;
    }
}
