package com.programmerr47.whitecodetesttask.api;

import com.programmerr47.whitecodetesttask.api.requestParams.AuthorizationParams;
import com.programmerr47.whitecodetesttask.api.util.DisplayType;
import com.programmerr47.whitecodetesttask.api.util.Permissions;
import com.programmerr47.whitecodetesttask.util.Constants;
import com.programmerr47.whitecodetesttask.util.Utils;

import java.net.URLEncoder;
import java.util.Collection;
import java.util.List;

/**
 *
 *
 * @author Michael Spitsin
 * @since 2014-08-21
 */
public class AuthorizationUtils {
    public static final String API_VERSION = "5.24";
    public static final String VK_REDIRECT_URL = "https://oauth.vk.com/blank.html";
    public static final String VK_AUTH_URL = "https://oauth.vk.com/authorize";

    private static final String ACCESS_TOKEN_PARAM_NAME = "access_token";
    private static final String USER_ID_PARAM_NAME = "user_id";

    public static String getUrl(String api_id, List<Permissions> permissions){
        AuthorizationParams params = new AuthorizationParams.Builder()
                .setAppId(api_id)
                .setPermissions(permissions)
                .setRedirectUrl(VK_REDIRECT_URL)
                .setDisplayType(DisplayType.mobile)
                .setApiVersion(API_VERSION)
                .build();

        return VK_AUTH_URL + Constants.REQUEST_PARAMS_BEGIN_SYMBOL + params;
    }

    public static String[] parseRedirectUrl(String url) throws Exception {
        //url is something like http://api.vkontakte.ru/blank.html#access_token=66e8f7a266af0dd477fcd3916366b17436e66af77ac352aeb270be99df7deeb&expires_in=0&user_id=7657164
        String access_token = Utils.extractPattern(url, ACCESS_TOKEN_PARAM_NAME + "=(.*?)&");
        String user_id = Utils.extractPattern(url, USER_ID_PARAM_NAME + "=(\\d*)");

        if(user_id == null || user_id.length() == 0 || access_token == null || access_token.length() == 0) {
            throw new Exception("Failed to parse redirect url "+url);
        }

        return new String[]{access_token, user_id};
    }
}
