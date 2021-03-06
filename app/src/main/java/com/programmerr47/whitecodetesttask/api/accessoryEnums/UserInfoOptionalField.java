package com.programmerr47.whitecodetesttask.api.accessoryEnums;

/**
 * @author Michael Spitsin
 * @since 2014-08-23
 */
public enum UserInfoOptionalField {
    sex,
    bdate,
    city,
    country,
    photo_50,
    photo_100,
    photo_200_orig,
    photo_200,
    photo_400_orig,
    photo_max,
    photo_max_orig,
    online,
    online_mobile,
    domain,
    has_mobile,
    contacts,
    connections,
    site,
    education,
    universities,
    schools,
    can_post,
    can_see_all_posts,
    can_see_audio,
    can_write_private_message,
    status,
    last_seen,
    common_count,
    relation,
    relatives,
    counters,
    screen_name,
    maiden_name,
    nickname,
    timezone,
    occupation,
    activities,
    interests,
    music,
    movies,
    tv,
    books,
    games,
    about,
    quotes;

    public static UserInfoOptionalField optValue(String name) {
        try {
            return valueOf(name);
        } catch (NullPointerException e) {
            return null;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
