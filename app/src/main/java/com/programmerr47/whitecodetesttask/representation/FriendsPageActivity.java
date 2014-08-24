package com.programmerr47.whitecodetesttask.representation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.programmerr47.whitecodetesttask.R;
import com.programmerr47.whitecodetesttask.api.Account;
import com.programmerr47.whitecodetesttask.api.accessoryEnums.UserInfoOptionalField;
import com.programmerr47.whitecodetesttask.api.requests.requestParams.UsersGetParams;
import com.programmerr47.whitecodetesttask.api.responseObjects.User;
import com.programmerr47.whitecodetesttask.representation.tasks.GetUserInfoTask;
import com.programmerr47.whitecodetesttask.representation.tasks.OnTaskFinishedListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity for representing list (that contained and handled in {@link FriendsPageFragment})
 * of friends. <strong>Look at</strong> fiend_list_item.xml file for see the layout of one
 * list element.
 *
 * @author Michael Spitsin
 * @since 2014-08-20
 */
public class FriendsPageActivity extends Activity implements OnTaskFinishedListener, View.OnClickListener {

    private static final int REQUEST_LOGIN_CODE = 47;

    private Account mAccount;

    private FriendsPageFragment mFriendsPageFragment;
    private TextView mUserShortInfoView;
    private Button mLogoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_list_page);
        mAccount = new Account(this);

        mUserShortInfoView = (TextView) findViewById(R.id.userShorInfoView);
        if (mAccount.isCorrect()) {
            mUserShortInfoView.setText(R.string.LOADING);
        } else {
            mUserShortInfoView.setText(R.string.YOU_ARE_NOT_LOGIN);
        }
        setUserShortInfo();

        mLogoutButton = (Button) findViewById(R.id.logoutButton);
        if (mAccount.isCorrect()) {
            mLogoutButton.setText(R.string.LOGOUT);
        } else {
            mLogoutButton.setText(R.string.LOGIN);
        }
        mLogoutButton.setOnClickListener(this);

        mFriendsPageFragment = (FriendsPageFragment) getFragmentManager().findFragmentById(R.id.friendsPageFragment);

        if (!mAccount.isCorrect()) {
            openLoginPage();
        } else {
            mFriendsPageFragment.setAccount(mAccount);
        }
    }

    private void setUserShortInfo() {
        if (getString(R.string.LOADING).equals(mUserShortInfoView.getText())) {
            List<UserInfoOptionalField> fields = new ArrayList<UserInfoOptionalField>();
            fields.add(UserInfoOptionalField.nickname);
            fields.add(UserInfoOptionalField.maiden_name);

            UsersGetParams params = new UsersGetParams.Builder()
                    .setFields(fields)
                    .build();

            GetUserInfoTask task = new GetUserInfoTask(mAccount);
            task.setOnTaskFinishedListener(this);
            task.execute(params);
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
                Log.v("REQUESTS", "Access token = " + mAccount.getAccessToken());
                Log.v("REQUESTS", "User id = " + mAccount.getUserId());
                //0af9a261917d796eaa9583efbd51f96e788f28a3b8b8c1c3996cae1b98a4ee5bbff408d0ef77076d7e1dc
                //42284313
                mUserShortInfoView.setText(R.string.LOADING);
                mLogoutButton.setText(R.string.LOGOUT);
                setUserShortInfo();
                mFriendsPageFragment.setAccount(mAccount);
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

    @Override
    public void onTaskFinished(String taskName, Object extraObject) {
        if (GetUserInfoTask.class.getName().equals(taskName)) {
            if ((extraObject != null) && (mUserShortInfoView != null)) {
                User currentlyLoggedUserInfo = (User) extraObject;

                String info = currentlyLoggedUserInfo.getFirstName() + " " + currentlyLoggedUserInfo.getNickName() + " " + currentlyLoggedUserInfo.getLastName();
                if ((currentlyLoggedUserInfo.getMaidenName() != null) && !currentlyLoggedUserInfo.getMaidenName().equals("")) {
                    info += " (" + currentlyLoggedUserInfo.getMaidenName() + ")";
                }

                mUserShortInfoView.setText(info);
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.logoutButton) {
            mAccount.clear();
            mFriendsPageFragment.logout();
            mUserShortInfoView.setText(R.string.YOU_ARE_NOT_LOGIN);
            mLogoutButton.setText(R.string.LOGIN);

            openLoginPage();
        }
    }
}
