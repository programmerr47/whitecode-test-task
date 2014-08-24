package com.programmerr47.whitecodetesttask.representation.adapters.components;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.programmerr47.whitecodetesttask.R;

/**
 * @author Michael Spitsin
 * @since 2014-08-24
 */
public class PinnedElement implements SectionAdapterElement{
    public static final int TYPE_ID = 1;

    private String mSectionName;

    public PinnedElement(String sectionName) {
        this.mSectionName = sectionName;
    }

    @Override
    public int getTypeId() {
        return TYPE_ID;
    }

    @Override
    public int getLayoutId() {
        return R.layout.friend_list_section;
    }

    @Override
    public View newView(LayoutInflater inflater, ViewGroup parent, int position) {
        View view = inflater.inflate(getLayoutId(), parent, false);

        if (view != null) {
            ViewHolder holder = new ViewHolder();
            holder.sectionName = (TextView) view.findViewById(R.id.sectionName);
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

        if (holder.sectionName != null) {
            holder.sectionName.setText(mSectionName);
        }
    }

    private static class ViewHolder {
        public TextView sectionName;
    }
}
