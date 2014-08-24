package com.programmerr47.whitecodetesttask.api.responseObjects;

import com.programmerr47.whitecodetesttask.api.util.JSONUtil;
import com.programmerr47.whitecodetesttask.api.accessoryEnums.DeactivatedPageType;
import com.programmerr47.whitecodetesttask.api.accessoryEnums.RelationType;
import com.programmerr47.whitecodetesttask.api.accessoryEnums.SexType;
import com.programmerr47.whitecodetesttask.api.responseObjects.summary.Counters;
import com.programmerr47.whitecodetesttask.api.responseObjects.summary.LastSeen;
import com.programmerr47.whitecodetesttask.api.responseObjects.summary.Occupation;
import com.programmerr47.whitecodetesttask.api.responseObjects.summary.Personal;
import com.programmerr47.whitecodetesttask.api.responseObjects.summary.Relative;
import com.programmerr47.whitecodetesttask.api.responseObjects.summary.School;
import com.programmerr47.whitecodetesttask.api.responseObjects.summary.University;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Object for representing vk user from their database.
 *
 * @author Michael Spitsin
 * @since 2014-08-22
 */
public class User {
    //----------------------STANDARD FIELDS--------------------------
    private static final String ID_TAG = "id";
    private static final String FIRST_NAME_TAG = "first_name";
    private static final String LAST_NAME_TAG = "last_name";
    private static final String DEACTIVATED_TAG = "deactivated";
    private static final String HIDDEN_TAG = "hidden";
    //----------------------OPTIONAL FIELDS--------------------------
    private static final String VERIFIED_TAG = "verified";
    private static final String BLACKLISTED_TAG = "blacklisted";
    private static final String SEX_TAG = "sex";
    private static final String BDATE_TAG = "bdate";
    private static final String CITY_TAG = "city";
    private static final String COUNTRY_TAG = "country";
    private static final String HOME_TOWN_TAG = "home_town";
    private static final String PHOTO_50_TAG = "photo_50";
    private static final String PHOTO_100_TAG = "photo_100";
    private static final String PHOTO_200_ORIG_TAG = "photo_200_orig";
    private static final String PHOTO_200_TAG = "photo_200";
    private static final String PHOTO_400_ORIG_TAG = "photo_400_orig";
    private static final String PHOTO_MAX_TAG = "photo_max";
    private static final String PHOTO_MAX_ORIG_TAG = "photo_max_orig";
    private static final String ONLINE_TAG = "online";
    private static final String ONLINE_MOBILE_TAG = "online_mobile";
    private static final String LISTS_TAG = "lists";
    private static final String DOMAIN_TAG = "domain";
    private static final String HAS_MOBILE_TAG = "has_mobile";
    private static final String MOBILE_PHONE_TAG = "mobile_phone";
    private static final String HOME_PHONE_TAG = "home_phone";
    private static final String SITE_TAG = "site";
    private static final String UNIVERSITY_TAG = "university";
    private static final String UNIVERSITY_NAME_TAG = "university_name";
    private static final String FACULTY_TAG = "faculty";
    private static final String FACULTY_NAME_TAG = "faculty_name";
    private static final String GRADUATION_TAG = "graduation";
    private static final String UNIVERSITIES_TAG = "universities";
    private static final String SCHOOLS_TAG = "schools";
    private static final String STATUS_TAG = "status";
    private static final String STATUS_AUDIO_TAG = "status_audio";
    private static final String LAST_SEEN_TAG = "last_seen";
    private static final String FOLLOWERS_COUNT_TAG = "followers";
    private static final String COMMON_COUNT_TAG = "common_count";
    private static final String COUNTERS_TAG = "counters";
    private static final String OCCUPATION_TAG = "occupation";
    private static final String NICKNAME_TAG = "nickname";
    private static final String RELATIVES_TAG = "relatives";
    private static final String RELATION_TAG = "relation";
    private static final String PERSONAL_TAG = "personal";
    private static final String WALL_COMMENTS_TAG = "wall_comments";
    private static final String ACTIVITIES_TAG = "activities";
    private static final String INTERESTS_TAG = "interests";
    private static final String MUSIC_TAG = "music";
    private static final String MOVIES_TAG = "movies";
    private static final String TV_TAG = "tv";
    private static final String BOOKS_TAG = "book";
    private static final String GAMES_TAG = "games";
    private static final String ABOUT_TAG = "about";
    private static final String QUOTES_TAG = "quotes";
    private static final String CAN_POST_TAG = "can_post";
    private static final String CAN_SEE_ALL_POSTS_TAG = "can_see_all_posts";
    private static final String CAN_SEE_AUDIO_TAG = "can_see_audio";
    private static final String CAN_WRITE_PRIVATE_MESSAGE_TAG = "can_write_private_message";
    private static final String TIMEZONE_TAG = "timezone";
    private static final String SCREEN_NAME_TAG = "screen_name";
    private static final String MAIDEN_NAME_TAG = "maiden_name";

    private int userId;
    private String firstName;
    private String lastName;
    private DeactivatedPageType deactivatedFlag;
//    private HIDDEN TODO understand this stuff
    private boolean verified;
    private boolean blacklisted;
    private SexType sex;
    private String birthdayDate;
    private String city;
    private String country;
    private String homeTown;
    private String photo50;
    private String photo100;
    private String photo200orig;
    private String photo200;
    private String photo400orig;
    private String photoMax;
    private String photoMaxOrig;
    private boolean online;
    private boolean onlineMobile;
    private String friendListsNames;
    private String domain;
    private boolean hasMobile;
    private String mobilePhoneNumber;
    private String homePhoneNumber;
    private String site;
    private int universityId;
    private String universityName;
    private int facultyId;
    private String facultyName;
    private int graduationYear;
    private List<University> universities;
    private List<School> schools;
    private String status;
    private LastSeen lastSeen;
    private int followersCount;
    private int commonCount;
    private Counters counters;
    private Occupation occupation;
    private String nickName;
    private List<Relative> relatives;
    private RelationType relationType;
    private Personal personal;
    private boolean wallComments;
    private String activities;
    private String interests;
    private String favoriteMusic;
    private String favoriteMovies;
    private String favoriteTvShows;
    private String favoriteBooks;
    private String favoriteGames;
    private String about;
    private String quotes;
    private boolean canPost;
    private boolean canSeeAllPosts;
    private boolean canSeeAudio;
    private boolean canWritePrivateMessage;
    private int timezone;
    private String screenName;
    private String maidenName;

    public User(Builder builder) {
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.deactivatedFlag = builder.deactivatedFlag;
        this.verified = builder.verified;
        this.blacklisted = builder.blacklisted;
        this.sex = builder.sex;
        this.birthdayDate = builder.birthdayDate;
        this.city = builder.city;
        this.country = builder.country;
        this.homeTown = builder.homeTown;
        this.photo50 = builder.photo50;
        this.photo100 = builder.photo100;
        this.photo200orig = builder.photo200orig;
        this.photo200 = builder.photo200;
        this.photo400orig = builder.photo400orig;
        this.photoMax = builder.photoMax;
        this.photoMaxOrig = builder.photoMaxOrig;
        this.online = builder.online;
        this.onlineMobile = builder.onlineMobile;
        this.friendListsNames = builder.friendListsNames;
        this.domain = builder.domain;
        this.hasMobile = builder.hasMobile;
        this.mobilePhoneNumber = builder.mobilePhoneNumber;
        this.homePhoneNumber = builder.homePhoneNumber;
        this.site = builder.site;
        this.universityId = builder.universityId;
        this.universityName = builder.universityName;
        this.facultyId = builder.facultyId;
        this.facultyName = builder.facultyName;
        this.graduationYear = builder.graduationYear;
        this.universities = builder.universities;
        this.schools = builder.schools;
        this.status = builder.status;
        this.lastSeen = builder.lastSeen;
        this.followersCount = builder.followersCount;
        this.commonCount = builder.commonCount;
        this.counters = builder.counters;
        this.occupation = builder.occupation;
        this.nickName = builder.nickName;
        this.relatives = builder.relatives;
        this.relationType = builder.relationType;
        this.personal = builder.personal;
        this.wallComments = builder.wallComments;
        this.activities = builder.activities;
        this.interests = builder.interests;
        this.favoriteMusic = builder.favoriteMusic;
        this.favoriteMovies = builder.favoriteMovies;
        this.favoriteTvShows = builder.favoriteTvShows;
        this.favoriteBooks = builder.favoriteBooks;
        this.favoriteGames = builder.favoriteGames;
        this.about = builder.about;
        this.quotes = builder.quotes;
        this.canPost = builder.canPost;
        this.canSeeAllPosts = builder.canSeeAllPosts;
        this.canSeeAudio = builder.canSeeAudio;
        this.canWritePrivateMessage = builder.canWritePrivateMessage;
        this.timezone = builder.timezone;
        this.screenName = builder.screenName;
        this.maidenName = builder.maidenName;
    }

    @SuppressWarnings("unused")
    public int getUserId() {
        return userId;
    }

    @SuppressWarnings("unused")
    public String getFirstName() {
        return firstName;
    }

    @SuppressWarnings("unused")
    public String getLastName() {
        return lastName;
    }

    @SuppressWarnings("unused")
    public DeactivatedPageType getDeactivatedFlag() {
        return deactivatedFlag;
    }

    @SuppressWarnings("unused")
    public boolean isVerified() {
        return verified;
    }

    @SuppressWarnings("unused")
    public boolean isBlacklisted() {
        return blacklisted;
    }

    @SuppressWarnings("unused")
    public SexType getSex() {
        return sex;
    }

    @SuppressWarnings("unused")
    public String getBirthdayDate() {
        return birthdayDate;
    }

    @SuppressWarnings("unused")
    public String getCity() {
        return city;
    }

    @SuppressWarnings("unused")
    public String getCountry() {
        return country;
    }

    @SuppressWarnings("unused")
    public String getHomeTown() {
        return homeTown;
    }

    @SuppressWarnings("unused")
    public String getPhoto50() {
        return photo50;
    }

    @SuppressWarnings("unused")
    public String getPhoto100() {
        return photo100;
    }

    @SuppressWarnings("unused")
    public String getPhoto200orig() {
        return photo200orig;
    }

    @SuppressWarnings("unused")
    public String getPhoto200() {
        return photo200;
    }

    @SuppressWarnings("unused")
    public String getPhoto400orig() {
        return photo400orig;
    }

    @SuppressWarnings("unused")
    public String getPhotoMax() {
        return photoMax;
    }

    @SuppressWarnings("unused")
    public String getPhotoMaxOrig() {
        return photoMaxOrig;
    }

    @SuppressWarnings("unused")
    public boolean isOnline() {
        return online;
    }

    @SuppressWarnings("unused")
    public boolean isOnlineMobile() {
        return onlineMobile;
    }

    @SuppressWarnings("unused")
    public String getFriendListsNames() {
        return friendListsNames;
    }

    @SuppressWarnings("unused")
    public String getDomain() {
        return domain;
    }

    @SuppressWarnings("unused")
    public boolean isHasMobile() {
        return hasMobile;
    }

    @SuppressWarnings("unused")
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    @SuppressWarnings("unused")
    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    @SuppressWarnings("unused")
    public String getSite() {
        return site;
    }

    @SuppressWarnings("unused")
    public int getUniversityId() {
        return universityId;
    }

    @SuppressWarnings("unused")
    public String getUniversityName() {
        return universityName;
    }

    @SuppressWarnings("unused")
    public int getFacultyId() {
        return facultyId;
    }

    @SuppressWarnings("unused")
    public String getFacultyName() {
        return facultyName;
    }

    @SuppressWarnings("unused")
    public int getGraduationYear() {
        return graduationYear;
    }

    @SuppressWarnings("unused")
    public List<University> getUniversities() {
        return universities;
    }

    @SuppressWarnings("unused")
    public List<School> getSchools() {
        return schools;
    }

    @SuppressWarnings("unused")
    public String getStatus() {
        return status;
    }

    @SuppressWarnings("unused")
    public LastSeen getLastSeen() {
        return lastSeen;
    }

    @SuppressWarnings("unused")
    public int getFollowersCount() {
        return followersCount;
    }

    @SuppressWarnings("unused")
    public int getCommonCount() {
        return commonCount;
    }

    @SuppressWarnings("unused")
    public Counters getCounters() {
        return counters;
    }

    @SuppressWarnings("unused")
    public Occupation getOccupation() {
        return occupation;
    }

    @SuppressWarnings("unused")
    public String getNickName() {
        return nickName;
    }

    @SuppressWarnings("unused")
    public List<Relative> getRelatives() {
        return relatives;
    }

    @SuppressWarnings("unused")
    public RelationType getRelationType() {
        return relationType;
    }

    @SuppressWarnings("unused")
    public Personal getPersonal() {
        return personal;
    }

    @SuppressWarnings("unused")
    public boolean isWallComments() {
        return wallComments;
    }

    @SuppressWarnings("unused")
    public String getActivities() {
        return activities;
    }

    @SuppressWarnings("unused")
    public String getInterests() {
        return interests;
    }

    @SuppressWarnings("unused")
    public String getFavoriteMusic() {
        return favoriteMusic;
    }

    @SuppressWarnings("unused")
    public String getFavoriteMovies() {
        return favoriteMovies;
    }

    @SuppressWarnings("unused")
    public String getFavoriteTvShows() {
        return favoriteTvShows;
    }

    @SuppressWarnings("unused")
    public String getFavoriteBooks() {
        return favoriteBooks;
    }

    @SuppressWarnings("unused")
    public String getFavoriteGames() {
        return favoriteGames;
    }

    @SuppressWarnings("unused")
    public String getAbout() {
        return about;
    }

    @SuppressWarnings("unused")
    public String getQuotes() {
        return quotes;
    }

    @SuppressWarnings("unused")
    public boolean isCanPost() {
        return canPost;
    }

    @SuppressWarnings("unused")
    public boolean isCanSeeAllPosts() {
        return canSeeAllPosts;
    }

    @SuppressWarnings("unused")
    public boolean isCanSeeAudio() {
        return canSeeAudio;
    }

    @SuppressWarnings("unused")
    public boolean isCanWritePrivateMessage() {
        return canWritePrivateMessage;
    }

    @SuppressWarnings("unused")
    public int getTimezone() {
        return timezone;
    }

    @SuppressWarnings("unused")
    public String getScreenName() {
        return screenName;
    }

    @SuppressWarnings("unused")
    public String getMaidenName() {
        return maidenName;
    }

    private static class Builder {
        private int userId;
        private String firstName;
        private String lastName;
        private DeactivatedPageType deactivatedFlag;
        private boolean verified;
        private boolean blacklisted;
        private SexType sex;
        private String birthdayDate;
        private String city;
        private String country;
        private String homeTown;
        private String photo50;
        private String photo100;
        private String photo200orig;
        private String photo200;
        private String photo400orig;
        private String photoMax;
        private String photoMaxOrig;
        private boolean online;
        private boolean onlineMobile;
        private String friendListsNames;
        private String domain;
        private boolean hasMobile;
        private String mobilePhoneNumber;
        private String homePhoneNumber;
        private String site;
        private int universityId;
        private String universityName;
        private int facultyId;
        private String facultyName;
        private int graduationYear;
        private List<University> universities;
        private List<School> schools;
        private String status;
        private LastSeen lastSeen;
        private int followersCount;
        private int commonCount;
        private Counters counters;
        private Occupation occupation;
        private String nickName;
        private List<Relative> relatives;
        private RelationType relationType;
        private Personal personal;
        private boolean wallComments;
        private String activities;
        private String interests;
        private String favoriteMusic;
        private String favoriteMovies;
        private String favoriteTvShows;
        private String favoriteBooks;
        private String favoriteGames;
        private String about;
        private String quotes;
        private boolean canPost;
        private boolean canSeeAllPosts;
        private boolean canSeeAudio;
        private boolean canWritePrivateMessage;
        private int timezone;
        private String screenName;
        private String maidenName;

        public Builder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setDeactivatedFlag(DeactivatedPageType deactivatedFlag) {
            this.deactivatedFlag = deactivatedFlag;
            return this;
        }

        public Builder setVerified(boolean verified) {
            this.verified = verified;
            return this;
        }

        public Builder setBlacklisted(boolean blacklisted) {
            this.blacklisted = blacklisted;
            return this;
        }

        public Builder setSex(SexType sex) {
            this.sex = sex;
            return this;
        }

        public Builder setBirthdayDate(String birthdayDate) {
            this.birthdayDate = birthdayDate;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setHomeTown(String homeTown) {
            this.homeTown = homeTown;
            return this;
        }

        public Builder setPhoto50(String photo50) {
            this.photo50 = photo50;
            return this;
        }

        public Builder setPhoto100(String photo100) {
            this.photo100 = photo100;
            return this;
        }

        public Builder setPhoto200orig(String photo200orig) {
            this.photo200orig = photo200orig;
            return this;
        }

        public Builder setPhoto200(String photo200) {
            this.photo200 = photo200;
            return this;
        }

        public Builder setPhoto400orig(String photo400orig) {
            this.photo400orig = photo400orig;
            return this;
        }

        public Builder setPhotoMax(String photoMax) {
            this.photoMax = photoMax;
            return this;
        }

        public Builder setPhotoMaxOrig(String photoMaxOrig) {
            this.photoMaxOrig = photoMaxOrig;
            return this;
        }

        public Builder setOnline(boolean online) {
            this.online = online;
            return this;
        }

        public Builder setOnlineMobile(boolean onlineMobile) {
            this.onlineMobile = onlineMobile;
            return this;
        }

        public Builder setFriendListsNames(String friendListsNames) {
            this.friendListsNames = friendListsNames;
            return this;
        }

        public Builder setDomain(String domain) {
            this.domain = domain;
            return this;
        }

        public Builder setHasMobile(boolean hasMobile) {
            this.hasMobile = hasMobile;
            return this;
        }

        public Builder setMobilePhoneNumber(String mobilePhoneNumber) {
            this.mobilePhoneNumber = mobilePhoneNumber;
            return this;
        }

        public Builder setHomePhoneNumber(String homePhoneNumber) {
            this.homePhoneNumber = homePhoneNumber;
            return this;
        }

        public Builder setSite(String site) {
            this.site = site;
            return this;
        }

        public Builder setUniversityId(int universityId) {
            this.universityId = universityId;
            return this;
        }

        public Builder setUniversityName(String universityName) {
            this.universityName = universityName;
            return this;
        }

        public Builder setFacultyId(int facultyId) {
            this.facultyId = facultyId;
            return this;
        }

        public Builder setFacultyName(String facultyName) {
            this.facultyName = facultyName;
            return this;
        }

        public Builder setGraduationYear(int graduationYear) {
            this.graduationYear = graduationYear;
            return this;
        }

        public Builder setUniversities(List<University> universities) {
            this.universities = universities;
            return this;
        }

        public Builder setSchools(List<School> schools) {
            this.schools = schools;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setLastSeen(LastSeen lastSeen) {
            this.lastSeen = lastSeen;
            return this;
        }

        public Builder setFollowersCount(int followersCount) {
            this.followersCount = followersCount;
            return this;
        }

        public Builder setCommonCount(int commonCount) {
            this.commonCount = commonCount;
            return this;
        }

        public Builder setCounters(Counters counters) {
            this.counters = counters;
            return this;
        }

        public Builder setOccupation(Occupation occupation) {
            this.occupation = occupation;
            return this;
        }

        public Builder setNickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public Builder setRelatives(List<Relative> relatives) {
            this.relatives = relatives;
            return this;
        }

        public Builder setRelationType(RelationType relationType) {
            this.relationType = relationType;
            return this;
        }

        public Builder setPersonal(Personal personal) {
            this.personal = personal;
            return this;
        }

        public Builder setWallComments(boolean wallComments) {
            this.wallComments = wallComments;
            return this;
        }

        public Builder setActivities(String activities) {
            this.activities = activities;
            return this;
        }

        public Builder setInterests(String interests) {
            this.interests = interests;
            return this;
        }

        public Builder setFavoriteMusic(String favoriteMusic) {
            this.favoriteMusic = favoriteMusic;
            return this;
        }

        public Builder setFavoriteMovies(String favoriteMovies) {
            this.favoriteMovies = favoriteMovies;
            return this;
        }

        public Builder setFavoriteTvShows(String favoriteTvShows) {
            this.favoriteTvShows = favoriteTvShows;
            return this;
        }

        public Builder setFavoriteBooks(String favoriteBooks) {
            this.favoriteBooks = favoriteBooks;
            return this;
        }

        public Builder setFavoriteGames(String favoriteGames) {
            this.favoriteGames = favoriteGames;
            return this;
        }

        public Builder setAbout(String about) {
            this.about = about;
            return this;
        }

        public Builder setQuotes(String quotes) {
            this.quotes = quotes;
            return this;
        }

        public Builder setCanPost(boolean canPost) {
            this.canPost = canPost;
            return this;
        }

        public Builder setCanSeeAllPosts(boolean canSeeAllPosts) {
            this.canSeeAllPosts = canSeeAllPosts;
            return this;
        }

        public Builder setCanSeeAudio(boolean canSeeAudio) {
            this.canSeeAudio = canSeeAudio;
            return this;
        }

        public Builder setCanWritePrivateMessage(boolean canWritePrivateMessage) {
            this.canWritePrivateMessage = canWritePrivateMessage;
            return this;
        }

        public Builder setTimezone(int timezone) {
            this.timezone = timezone;
            return this;
        }

        public Builder setScreenName(String screenName) {
            this.screenName = screenName;
            return this;
        }

        public Builder setMaidenName(String maidenName) {
            this.maidenName = maidenName;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    /**
     * Creates {@link User} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of User or null, if json is null
     */
    @SuppressWarnings("unused")
    public static User getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setAbout(jsonObject.optString(ABOUT_TAG, null))
                    .setActivities(jsonObject.optString(ACTIVITIES_TAG, null))
                    .setBirthdayDate(jsonObject.optString(BDATE_TAG, null))
                    .setBlacklisted(JSONUtil.intToBoolean(jsonObject.optInt(BLACKLISTED_TAG, 0)))
                    .setCanPost(JSONUtil.intToBoolean(jsonObject.optInt(CAN_POST_TAG, 0)))
                    .setCanSeeAllPosts(JSONUtil.intToBoolean(jsonObject.optInt(CAN_SEE_ALL_POSTS_TAG, 0)))
                    .setCanSeeAudio(JSONUtil.intToBoolean(jsonObject.optInt(CAN_SEE_AUDIO_TAG, 0)))
                    .setCanWritePrivateMessage(JSONUtil.intToBoolean(jsonObject.optInt(CAN_WRITE_PRIVATE_MESSAGE_TAG, 0)))
                    .setCity(jsonObject.optString(CITY_TAG, null))
                    .setCommonCount(jsonObject.optInt(COMMON_COUNT_TAG, 0))
                    .setCounters(Counters.getFromJSONObject(jsonObject.optJSONObject(COUNTERS_TAG)))
                    .setCountry(jsonObject.optString(COUNTRY_TAG, null))
                    .setDeactivatedFlag(DeactivatedPageType.optValue(jsonObject.optString(DEACTIVATED_TAG, null)))
                    .setDomain(jsonObject.optString(DOMAIN_TAG, null))
                    .setFacultyId(jsonObject.optInt(FACULTY_TAG, 0))
                    .setFacultyName(jsonObject.optString(FACULTY_NAME_TAG, null))
                    .setFavoriteBooks(jsonObject.optString(BOOKS_TAG, null))
                    .setFavoriteGames(jsonObject.optString(GAMES_TAG, null))
                    .setFavoriteMovies(jsonObject.optString(MOVIES_TAG, null))
                    .setFavoriteMusic(jsonObject.optString(MUSIC_TAG, null))
                    .setFavoriteTvShows(jsonObject.optString(TV_TAG, null))
                    .setFirstName(jsonObject.optString(FIRST_NAME_TAG, null))
                    .setFollowersCount(jsonObject.optInt(FOLLOWERS_COUNT_TAG, 0))
                    .setFriendListsNames(jsonObject.optString(LISTS_TAG, null))
                    .setGraduationYear(jsonObject.optInt(GRADUATION_TAG, 0))
                    .setHasMobile(JSONUtil.intToBoolean(jsonObject.optInt(HAS_MOBILE_TAG, 0)))
                    .setHomePhoneNumber(jsonObject.optString(HOME_PHONE_TAG, null))
                    .setHomeTown(jsonObject.optString(HOME_TOWN_TAG, null))
                    .setInterests(jsonObject.optString(INTERESTS_TAG, null))
                    .setLastName(jsonObject.optString(LAST_NAME_TAG, null))
                    .setLastSeen(LastSeen.getFromJSONObject(jsonObject.optJSONObject(LAST_SEEN_TAG)))
                    .setMaidenName(jsonObject.optString(MAIDEN_NAME_TAG, null))
                    .setMobilePhoneNumber(jsonObject.optString(MOBILE_PHONE_TAG, null))
                    .setNickName(jsonObject.optString(NICKNAME_TAG, null))
                    .setOccupation(Occupation.getFromJSONObject(jsonObject.optJSONObject(OCCUPATION_TAG)))
                    .setOnline(JSONUtil.intToBoolean(jsonObject.optInt(ONLINE_TAG, 0)))
                    .setOnlineMobile(JSONUtil.intToBoolean(jsonObject.optInt(ONLINE_MOBILE_TAG, 0)))
                    .setPersonal(Personal.getFromJSONObject(jsonObject.optJSONObject(PERSONAL_TAG)))
                    .setPhoto100(jsonObject.optString(PHOTO_100_TAG, null))
                    .setPhoto200(jsonObject.optString(PHOTO_200_TAG, null))
                    .setPhoto200orig(jsonObject.optString(PHOTO_200_ORIG_TAG, null))
                    .setPhoto400orig(jsonObject.optString(PHOTO_400_ORIG_TAG, null))
                    .setPhoto50(jsonObject.optString(PHOTO_50_TAG, null))
                    .setPhotoMax(jsonObject.optString(PHOTO_MAX_TAG, null))
                    .setPhotoMaxOrig(jsonObject.optString(PHOTO_MAX_ORIG_TAG, null))
                    .setQuotes(jsonObject.optString(QUOTES_TAG, null))
                    .setRelationType(RelationType.getFromInt(jsonObject.optInt(RELATION_TAG, 0)))
                    .setRelatives(Relative.getFromJSONArray(jsonObject.optJSONArray(RELATIVES_TAG)))
                    .setSchools(School.getFromJSONArray(jsonObject.optJSONArray(SCHOOLS_TAG)))
                    .setScreenName(jsonObject.optString(SCREEN_NAME_TAG, null))
                    .setSex(SexType.getFromInt(jsonObject.optInt(SEX_TAG, 0)))
                    .setSite(jsonObject.optString(SITE_TAG, null))
                    .setStatus(jsonObject.optString(STATUS_TAG, null))
                    .setTimezone(jsonObject.optInt(TIMEZONE_TAG, 0))
                    .setUniversities(University.getFromJSONArray(jsonObject.optJSONArray(UNIVERSITIES_TAG)))
                    .setUniversityId(jsonObject.optInt(UNIVERSITY_TAG, 0))
                    .setUniversityName(jsonObject.optString(UNIVERSITY_NAME_TAG, null))
                    .setUserId(jsonObject.optInt(ID_TAG, 0))
                    .setVerified(JSONUtil.intToBoolean(jsonObject.optInt(VERIFIED_TAG, 0)))
                    .setWallComments(JSONUtil.intToBoolean(jsonObject.optInt(WALL_COMMENTS_TAG, 0)))
                    .build();
        }
    }

    /**
     * Creates list of {@link User} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of User or null, if json is null
     */
    @SuppressWarnings("unused")
    public static List<User> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<User> resultList = new ArrayList<User>();
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
