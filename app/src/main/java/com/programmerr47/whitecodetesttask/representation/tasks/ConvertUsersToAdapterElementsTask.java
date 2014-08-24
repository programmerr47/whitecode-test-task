package com.programmerr47.whitecodetesttask.representation.tasks;

import com.programmerr47.whitecodetesttask.api.responseObjects.User;
import com.programmerr47.whitecodetesttask.representation.adapters.components.PinnedElement;
import com.programmerr47.whitecodetesttask.representation.adapters.components.SectionAdapterElement;
import com.programmerr47.whitecodetesttask.representation.adapters.components.StandardElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Spitsin
 * @since 2014-08-24
 */
public class ConvertUsersToAdapterElementsTask extends AsyncTaskWithListener<List<User>, Void, List<SectionAdapterElement>> {
    @Override
    protected List<SectionAdapterElement> doInBackground(List<User>... lists) {
        if (lists.length > 0) {
            List<User> users = lists[0];
            List<SectionAdapterElement> adapterElements = new ArrayList<SectionAdapterElement>();
            String previousFirstLetter = "";

            for (User user : users) {
                String currentFirstLetter = user.getFirstName().substring(0, 1);

                if (!previousFirstLetter.equals(currentFirstLetter)) {
                    adapterElements.add(new PinnedElement(currentFirstLetter));
                    previousFirstLetter = currentFirstLetter;
                }

                adapterElements.add(new StandardElement(user));
            }

            return adapterElements;
        }

        return new ArrayList<SectionAdapterElement>();
    }
}
