package com.programmerr47.whitecodetesttask.representation.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.programmerr47.whitecodetesttask.imageloading.ImageLoader;
import com.programmerr47.whitecodetesttask.representation.adapters.components.PinnedElement;
import com.programmerr47.whitecodetesttask.representation.adapters.components.SectionAdapterElement;
import com.programmerr47.whitecodetesttask.representation.view.PinnedSectionListView;

import java.util.List;

/**
 * @author Michael Spitsin
 * @since 2014-08-24
 */
public class SectionAdapter extends BindBaseAdapter implements PinnedSectionListView.PinnedSectionListAdapter{

    private static final int ITEM_TYPES_COUNT = 2;

    private Context mContext;
    private ImageLoader mImageLoader;
    private List<SectionAdapterElement> mItems;

    public SectionAdapter(Context context, List<SectionAdapterElement> items, ImageLoader imageLoader) {
        if (items == null) {
            throw new NullPointerException("items must be not null");
        }

        if (context == null) {
            throw new NullPointerException("context must be not null");
        }

        if (imageLoader == null) {
            throw new NullPointerException("imageLoader must be not null");
        }

        mItems = items;
        mContext = context;
        mImageLoader = imageLoader;
    }

    @Override
    public boolean isItemViewTypePinned(int viewType) {
        return viewType == PinnedElement.TYPE_ID;
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getTypeId();
    }

    @Override
    public int getViewTypeCount() {
        return ITEM_TYPES_COUNT;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    protected View newView(ViewGroup parent, int position) {
        SectionAdapterElement element = mItems.get(position);
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return element.newView(layoutInflater, parent, position);
    }

    @Override
    protected void bindView(View view, int position) {
        SectionAdapterElement element = mItems.get(position);
        element.bindView(view, mImageLoader, position);
    }

    public void setItems(List<SectionAdapterElement> items) {
        mItems = items;
        notifyDataSetChanged();
    }
}
