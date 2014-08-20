package com.programmerr47.whitecodetesttask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.programmerr47.whitecodetesttask.api.Account;

/**
 * Activity for representing list (that contained and handled in {@link FriendsPageFragment})
 * of friends. <strong>Look at</strong> fiend_list_item.xml file for see the layout of one
 * list element.
 *
 * @author Michael Spitsin
 * @since 2014-08-20
 */
public class FriendsPageActivity extends Activity{

    private static final int REQUEST_LOGIN_CODE = 47;

    private Account mAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAccount = new Account(this);

        if (mAccount.hasAccessToken()) {

        } else {
            openLoginPage();
        }
    }

    private void openLoginPage() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, REQUEST_LOGIN_CODE);
    }
}
