package com.programmerr47.whitecodetesttask.representation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.programmerr47.whitecodetesttask.R;
import com.programmerr47.whitecodetesttask.api.util.AuthorizationUtils;
import com.programmerr47.whitecodetesttask.api.accessoryEnums.Permissions;
import com.programmerr47.whitecodetesttask.api.util.Constants;
import com.programmerr47.whitecodetesttask.representation.util.ApiConstants;

import java.util.ArrayList;
import java.util.List;


public class LoginActivity extends Activity {
    public static final String INTENT_RESULT_ACCESS_TOKEN = "INTENT_RESULT_ACCESS_TOKEN";
    public static final String INTENT_RESULT_USER_ID = "INTENT_RESULT_USER_ID";

    WebView mLoginWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginWebView = (WebView) findViewById(R.id.vkLoginWebView);
        mLoginWebView.getSettings().setJavaScriptEnabled(true);
        mLoginWebView.clearCache(true);

        mLoginWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView webView, String url, Bitmap favicon) {
                super.onPageStarted(webView, url, favicon);
                parseUrl(url);
            }
        });

        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();

        List<Permissions> permissions = new ArrayList<Permissions>();
        permissions.add(Permissions.friends);

        mLoginWebView.loadUrl(AuthorizationUtils.getUrl(ApiConstants.API_KEY, permissions));
    }

    private void parseUrl(String url) {
        try {
            if(url == null) {
                return;
            }

            if(url.startsWith(Constants.VK_REDIRECT_URL))
            {
                if(!url.contains("error=")){
                    String[] auth = AuthorizationUtils.parseRedirectUrl(url);
                    Intent intent = new Intent();
                    intent.putExtra(INTENT_RESULT_ACCESS_TOKEN, auth[0]);
                    intent.putExtra(INTENT_RESULT_USER_ID, auth[1]);
                    setResult(Activity.RESULT_OK, intent);
                }
                finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
