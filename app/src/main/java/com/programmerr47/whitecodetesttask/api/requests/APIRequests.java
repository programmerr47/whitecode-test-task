package com.programmerr47.whitecodetesttask.api.requests;

import com.programmerr47.whitecodetesttask.api.Account;

/**
 * Basic class for all requests.
 *
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public class APIRequests {

    private Account account;

    private FriendRequests friendRequests;
    private UsersRequests usersRequests;

    public APIRequests(Account account) {
        this.account = account;

        friendRequests = new FriendRequests(account);
        usersRequests = new UsersRequests(account);
    }

    public FriendRequests getFriendsRequests() {
        return friendRequests;
    }

    public UsersRequests getUsersRequests() {
        return usersRequests;
    }
}
