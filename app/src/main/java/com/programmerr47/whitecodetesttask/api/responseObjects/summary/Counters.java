package com.programmerr47.whitecodetesttask.api.responseObjects.summary;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Object for representing counters of albums, audios and etc of user from their database.
 *
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public class Counters {
    private static final String ALBUMS_TAG = "albums";
    private static final String VIDEOS_TAG = "videos";
    private static final String AUDIOS_TAG = "audios";
    private static final String PHOTOS_TAG = "photos";
    private static final String NOTES_TAG = "notes";
    private static final String FRIENDS_TAG = "friends";
    private static final String GROUPS_TAG = "groups";
    private static final String ONLINE_FRIENDS_TAG = "online_friends";
    private static final String MUTUAL_FRIENDS_TAG = "mutual_friends";
    private static final String USER_VIDEOS_TAG = "user_videos";
    private static final String FOLLOWERS_TAG = "followers";

    private int albums;
    private int videos;
    private int audios;
    private int photos;
    private int notes;
    private int friends;
    private int groups;
    private int onlineFriends;
    private int mutualFriends;
    private int userVideos;
    private int followers;

    private Counters(Builder builder) {
        this.albums = builder.albums;
        this.videos = builder.videos;
        this.audios = builder.audios;
        this.photos = builder.photos;
        this.notes = builder.notes;
        this.friends = builder.friends;
        this.groups = builder.groups;
        this.onlineFriends = builder.onlineFriends;
        this.mutualFriends = builder.mutualFriends;
        this.userVideos = builder.userVideos;
        this.followers = builder.followers;
    }

    @SuppressWarnings("unused")
    public int getAlbums() {
        return albums;
    }

    @SuppressWarnings("unused")
    public int getVideos() {
        return videos;
    }

    @SuppressWarnings("unused")
    public int getAudios() {
        return audios;
    }

    @SuppressWarnings("unused")
    public int getPhotos() {
        return photos;
    }

    @SuppressWarnings("unused")
    public int getNotes() {
        return notes;
    }

    @SuppressWarnings("unused")
    public int getFriends() {
        return friends;
    }

    @SuppressWarnings("unused")
    public int getGroups() {
        return groups;
    }

    @SuppressWarnings("unused")
    public int getOnlineFriends() {
        return onlineFriends;
    }

    @SuppressWarnings("unused")
    public int getMutualFriends() {
        return mutualFriends;
    }

    @SuppressWarnings("unused")
    public int getUserVideos() {
        return userVideos;
    }

    @SuppressWarnings("unused")
    public int getFollowers() {
        return followers;
    }

    private static class Builder {
        private int albums;
        private int videos;
        private int audios;
        private int photos;
        private int notes;
        private int friends;
        private int groups;
        private int onlineFriends;
        private int mutualFriends;
        private int userVideos;
        private int followers;

        public Builder setAlbums(int albums) {
            this.albums = albums;
            return this;
        }

        public Builder setVideos(int videos) {
            this.videos = videos;
            return this;
        }

        public Builder setAudios(int audios) {
            this.audios = audios;
            return this;
        }

        public Builder setPhotos(int photos) {
            this.photos = photos;
            return this;
        }

        public Builder setNotes(int notes) {
            this.notes = notes;
            return this;
        }

        public Builder setFriends(int friends) {
            this.friends = friends;
            return this;
        }

        public Builder setGroups(int groups) {
            this.groups = groups;
            return this;
        }

        public Builder setOnlineFriends(int onlineFriends) {
            this.onlineFriends = onlineFriends;
            return this;
        }

        public Builder setMutualFriends(int mutualFriends) {
            this.mutualFriends = mutualFriends;
            return this;
        }

        public Builder setUserVideos(int userVideos) {
            this.userVideos = userVideos;
            return this;
        }

        public Builder setFollowers(int followers) {
            this.followers = followers;
            return this;
        }

        public Counters build() {
            return new Counters(this);
        }
    }

    /**
     * Creates {@link Counters} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of Counters or null, if json is null
     */
    @SuppressWarnings("unused")
    public static Counters getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setAlbums(jsonObject.optInt(ALBUMS_TAG, 0))
                    .setAudios(jsonObject.optInt(AUDIOS_TAG, 0))
                    .setFollowers(jsonObject.optInt(FOLLOWERS_TAG, 0))
                    .setFriends(jsonObject.optInt(FRIENDS_TAG, 0))
                    .setGroups(jsonObject.optInt(GROUPS_TAG, 0))
                    .setMutualFriends(jsonObject.optInt(MUTUAL_FRIENDS_TAG, 0))
                    .setNotes(jsonObject.optInt(NOTES_TAG, 0))
                    .setOnlineFriends(jsonObject.optInt(ONLINE_FRIENDS_TAG, 0))
                    .setPhotos(jsonObject.optInt(PHOTOS_TAG, 0))
                    .setUserVideos(jsonObject.optInt(USER_VIDEOS_TAG, 0))
                    .setVideos(jsonObject.optInt(VIDEOS_TAG, 0))
                    .build();
        }
    }

    /**
     * Creates list of {@link Counters} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of Counters or null, if json is null
     */
    @SuppressWarnings("unused")
    public static List<Counters> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<Counters> resultList = new ArrayList<Counters>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.optJSONObject(i);
                if (jsonObject != null) {
                    resultList.add(getFromJSONObject(jsonObject));
                }
            }
            return resultList;
        }
    }
}
