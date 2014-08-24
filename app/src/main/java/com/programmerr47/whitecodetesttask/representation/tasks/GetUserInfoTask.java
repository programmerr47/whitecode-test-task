package com.programmerr47.whitecodetesttask.representation.tasks;

import com.programmerr47.whitecodetesttask.api.Account;
import com.programmerr47.whitecodetesttask.api.requests.APIRequests;
import com.programmerr47.whitecodetesttask.api.requests.UsersRequests;
import com.programmerr47.whitecodetesttask.api.requests.requestParams.UsersGetParams;
import com.programmerr47.whitecodetesttask.api.responseObjects.User;

import java.util.List;

/**
 * @author Michael Spitsin
 * @since 2014-08-24
 */
public class GetUserInfoTask extends AsyncTaskWithListener<UsersGetParams, Void, User> {

    Account account;

    public GetUserInfoTask(Account account) {
        this.account = account;
    }

    @Override
    protected User doInBackground(UsersGetParams... usersGetParamsArray) {
        if (usersGetParamsArray.length > 0) {
            UsersGetParams params = usersGetParamsArray[0];
            APIRequests requests = new APIRequests(account);
            UsersRequests usersRequests = requests.getUsersRequests();

            List<User> users = usersRequests.get(params);
            if ((users != null) && (users.size() > 0)) {
                return users.get(0);
            } else if (users == null) {
                connectionError();
            }
        }

        return null;
    }
}
