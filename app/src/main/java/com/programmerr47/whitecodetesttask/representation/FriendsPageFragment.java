package com.programmerr47.whitecodetesttask.representation;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.programmerr47.whitecodetesttask.R;
import com.programmerr47.whitecodetesttask.api.Account;
import com.programmerr47.whitecodetesttask.api.accessoryEnums.FriendInfoOptionalField;
import com.programmerr47.whitecodetesttask.api.requests.requestParams.FriendsGetParams;
import com.programmerr47.whitecodetesttask.api.responseObjects.User;
import com.programmerr47.whitecodetesttask.imageloading.ImageLoader;
import com.programmerr47.whitecodetesttask.representation.adapters.SectionAdapter;
import com.programmerr47.whitecodetesttask.representation.adapters.components.SectionAdapterElement;
import com.programmerr47.whitecodetesttask.representation.tasks.ConvertUsersToAdapterElementsTask;
import com.programmerr47.whitecodetesttask.representation.tasks.GetFriendsInfoTask;
import com.programmerr47.whitecodetesttask.representation.tasks.OnTaskFinishedListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment that represents friend list of logged user.
 *
 * @author Michael Spitsin
 * @since 2014-08-20
 */
public class FriendsPageFragment extends Fragment implements OnTaskFinishedListener {

    private Account mAccount;
    private OnRefreshingStateChangeListener mListener;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ListView mListView;

    private SectionAdapter mListAdapter;
    private ImageLoader mImageLoader;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friend_list_layout, container, false);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        mListView = (ListView) view.findViewById(R.id.friendsListView);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mImageLoader = new ImageLoader(getActivity().getApplicationContext());
        mListAdapter = new SectionAdapter(getActivity(), new ArrayList<SectionAdapterElement>(), mImageLoader);

        mSwipeRefreshLayout.setColorSchemeResources(R.color.blue_bright, R.color.pink_bright, R.color.green_lime, R.color.orange_bright);

        mListView.setAdapter(mListAdapter);
        mListView.setFastScrollEnabled(true);
        mListView.setFastScrollAlwaysVisible(true);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (mListener != null) {
                    mListener.onRefreshStarted();
                }

                refreshList();
            }
        });
    }

    public void setAccount(Account account) {
        mAccount = account;
        refreshList();

        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setRefreshing(true);
        }
    }

    public void logout() {
        mAccount = null;

        if (mListAdapter != null) {
            mListAdapter.setItems(new ArrayList<SectionAdapterElement>());
        }
    }

    public void refreshList() {
        mImageLoader.clearMemoryCache();

        List<FriendInfoOptionalField> fields = new ArrayList<FriendInfoOptionalField>();
        fields.add(FriendInfoOptionalField.nickname);
        fields.add(FriendInfoOptionalField.maiden_name);
        fields.add(FriendInfoOptionalField.online);
        fields.add(FriendInfoOptionalField.online_mobile);
        fields.add(FriendInfoOptionalField.photo_100);

        FriendsGetParams params = new FriendsGetParams.Builder()
                .setFields(fields)
                .build();

        GetFriendsInfoTask task = new GetFriendsInfoTask(mAccount);
        task.setOnTaskFinishedListener(this);
        task.execute(params);
    }

    public void setOnRefreshingStateChangeListener(OnRefreshingStateChangeListener listener) {
        mListener = listener;
    }

    @Override
    public void onTaskFinished(String taskName, Object extraObject) {
        if (GetFriendsInfoTask.class.getName().equals(taskName)) {
            if ((extraObject != null)) {
                List<User> allFriends = (List<User>) extraObject;

                ConvertUsersToAdapterElementsTask task = new ConvertUsersToAdapterElementsTask();
                task.setOnTaskFinishedListener(this);
                task.execute(allFriends);
            } else {
                if (mSwipeRefreshLayout != null) {
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }
        } else if (ConvertUsersToAdapterElementsTask.class.getName().equals(taskName)) {
            if (extraObject != null) {
                mListAdapter.setItems((List<SectionAdapterElement>) extraObject);

                if (mSwipeRefreshLayout != null) {
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }
        }
    }

    public interface OnRefreshingStateChangeListener {
        void onRefreshStarted();
    }
}
