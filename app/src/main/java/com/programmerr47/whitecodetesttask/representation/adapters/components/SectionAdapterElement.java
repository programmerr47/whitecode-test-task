package com.programmerr47.whitecodetesttask.representation.adapters.components;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Main class for all {@link com.programmerr47.whitecodetesttask.representation.adapters.SectionAdapter}
 * elements. All new types of adapter elements must extends this class of it subclasses and
 * provides their own layout.
 *
 * @author Michael Spitsin
 * @since 2014-08-24
 */
public interface SectionAdapterElement {

    /**
     * Retrieves id of type of specific implementation.
     * ListView has different types of elements, with different layouts.
     * Therefor it is needed to specify type identifier to refresh we,
     * if new view differs from old view, when you scrolling.
     *
     * @return id of type
     */
    int getTypeId();

    /**
     * Retrieves id of layout linked with specific implementation.
     *
     * @return id of defined layout
     */
    int getLayoutId();

    /**
     * Calls when another taken element is not exists and it is needed to create it from layout.
     *
     * @param inflater
     * @param parent parent view group
     * @param position position of element that will be represented by this view
     * @return created View
     */
    View newView(LayoutInflater inflater, ViewGroup parent, int position);

    /**
     * Calls when another taken element is exists and it is needed to bind it (set up it).
     *
     * @param view given created of existing view
     * @param position position of this view
     */
    void bindView(View view, int position);
}
