package com.programmerr47.whitecodetesttask.representation.adapters.components;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.programmerr47.whitecodetesttask.R;
import com.programmerr47.whitecodetesttask.api.responseObjects.User;

/**
 * @author Michael Spitsin
 * @since 2014-08-24
 */
public class StandardElement implements SectionAdapterElement {
    public static final int TYPE_ID = 0;

    private User mItemInfo;

    public StandardElement(User itemInfo) {
        mItemInfo = itemInfo;
    }

    @Override
    public int getTypeId() {
        return TYPE_ID;
    }

    @Override
    public int getLayoutId() {
        return R.layout.friend_list_item;
    }

    @Override
    public View newView(LayoutInflater inflater, ViewGroup parent, int position) {
        View view = inflater.inflate(getLayoutId(), parent, false);

        if (view != null) {
            ViewHolder holder = new ViewHolder();
            holder.icon = (ImageView) view.findViewById(R.id.userIcon);
            holder.mobileFlagIcon = (ImageView) view.findViewById(R.id.onlinePhoneIcon);
            holder.fullName = (TextView) view.findViewById(R.id.userFullNameView);
            holder.onlineFlag = (TextView) view.findViewById(R.id.onlineTextFlag);
            view.setTag(holder);
        } else {
            throw new IllegalStateException("View not created");
        }

        return view;
    }

    @Override
    public void bindView(View view, int position) {
        if (view.getTag() == null) {
            throw new IllegalArgumentException("view must contains this own holder");
        }

        ViewHolder holder = (ViewHolder) view.getTag();

        if (holder.icon != null) {
            //TODO
        }

        if (holder.mobileFlagIcon != null) {
            if (mItemInfo.isOnline() && mItemInfo.isOnlineMobile()) {
                holder.mobileFlagIcon.setVisibility(View.VISIBLE);
            } else {
                holder.mobileFlagIcon.setVisibility(View.GONE);
            }
        }

        if (holder.onlineFlag != null) {
            if (mItemInfo.isOnline()) {
                holder.onlineFlag.setVisibility(View.VISIBLE);
            } else {
                holder.onlineFlag.setVisibility(View.GONE);
            }
        }

        if (holder.fullName != null) {
            String info = mItemInfo.getFirstName() + " " + mItemInfo.getNickName() + " " + mItemInfo.getLastName();
            if ((mItemInfo.getMaidenName() != null) && !mItemInfo.getMaidenName().equals("")) {
                info += " (" + mItemInfo.getMaidenName() + ")";
            }

            holder.fullName.setText(info);
        }
    }

    private static class ViewHolder {
        public ImageView icon;
        public ImageView mobileFlagIcon;
        public TextView fullName;
        public TextView onlineFlag;
    }
}
