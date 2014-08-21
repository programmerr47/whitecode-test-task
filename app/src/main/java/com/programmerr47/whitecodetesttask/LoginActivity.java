package com.programmerr47.whitecodetesttask;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.programmerr47.whitecodetesttask.util.Constants;
import com.programmerr47.whitecodetesttask.util.Utils;


public class LoginActivity extends Activity {
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
    }

    private void parseUrl(String url) {
        try {
            if(url == null) {
                return;
            }

            if(url.startsWith(Constants.VK_REDIRECT_URL))
            {
                if(!url.contains("error=")){
                    String[] auth = parseRedirectUrl(url);
                    Intent intent = new Intent();
                    intent.putExtra("token", auth[0]);
                    intent.putExtra("user_id", Long.parseLong(auth[1]));
                    setResult(Activity.RESULT_OK, intent);
                }
                finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String[] parseRedirectUrl(String url) throws Exception {
        //url is something like http://api.vkontakte.ru/blank.html#access_token=66e8f7a266af0dd477fcd3916366b17436e66af77ac352aeb270be99df7deeb&expires_in=0&user_id=7657164
        String access_token = Utils.extractPattern(url, "access_token=(.*?)&");
        String user_id = Utils.extractPattern(url, "user_id=(\\d*)");

        if(user_id == null || user_id.length() == 0 || access_token == null || access_token.length() == 0) {
            throw new Exception("Failed to parse redirect url "+url);
        }

        return new String[]{access_token, user_id};
    }
}
