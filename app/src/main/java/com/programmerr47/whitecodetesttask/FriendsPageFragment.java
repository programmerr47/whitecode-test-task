package com.programmerr47.whitecodetesttask;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;

/**
 * Fragment that represents friend list of logged user.
 *
 * @author Michael Spitsin
 * @since 2014-08-20
 */
public class FriendsPageFragment extends Fragment{

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ListView mListView;
    private CursorAdapter mListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friend_list_layout, container, false);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.white, R.color.gray_light_very, R.color.gray, R.color.gray_dark_very);

        mListView = (ListView) view.findViewById(R.id.friendsListView);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //mListAdapter = ...
        mListView.setAdapter(mListAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //TODO create Task for refresh
            }
        });
    }
}
