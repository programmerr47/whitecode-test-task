package com.programmerr47.whitecodetesttask;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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
    private FriendsPageFragment mFriendsPageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_list_page);
        mAccount = new Account(this);

        if (!mAccount.hasAccessToken()) {
            openLoginPage();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.friends_page_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.actionAbout:
                openAboutPage();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_LOGIN_CODE) {
            if (resultCode == RESULT_OK) {
                mAccount.setAccessToken(data.getStringExtra(LoginActivity.INTENT_RESULT_ACCESS_TOKEN));
                mAccount.setUserId(data.getStringExtra(LoginActivity.INTENT_RESULT_USER_ID));
                mAccount.save();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void openLoginPage() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, REQUEST_LOGIN_CODE);
    }

    private void openAboutPage() {
        //TODO
    }
}
