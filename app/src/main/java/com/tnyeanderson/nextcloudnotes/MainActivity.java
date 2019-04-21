package com.tnyeanderson.nextcloudnotes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

    private WebView mWebView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = findViewById(R.id.activity_main_webview);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient() {
            /*
            @Override
            public boolean onPageStarted(WebView view, String url) {
                Log.d("notes-log", "loaded");
                //hide loading image
                findViewById(R.id.splash_image).setVisibility(View.GONE);
                //show webview
                findViewById(R.id.activity_main_webview).setVisibility(View.VISIBLE);

                return true;
            }
            */

            @Override
            public void onPageFinished(WebView view, String url) {
                new android.os.Handler().postDelayed(new Runnable() {
                    public void run() {
                        Log.d("notes-log", "loaded");
                        //show webview
                        findViewById(R.id.activity_main_webview).setVisibility(View.VISIBLE);
                        //hide loading image
                        findViewById(R.id.splash_image).setVisibility(View.GONE);
                    }
                }, 1000);
            }


        });

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUserAgentString(
                webSettings.getUserAgentString() + " " + getString(R.string.user_agent_suffix)
        );

        // Inject CSS
        // String html = download("https://thomasanderson.cloud/apps/notes/");
        // html =html.replaceFirst("</head>", "<style>#header {display: none;}</style></head>");
        // mWebView.loadData(html, "text/html", null);

        // REMOTE RESOURCE
        mWebView.loadUrl(getString(R.string.base_url) + "apps/notes/");
        // mWebView.setWebViewClient(new MyWebViewClient());

        // LOCAL RESOURCE
        // mWebView.loadUrl("file:///android_asset/note.html");
    }

    // Prevent the back-button from closing the app
    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    // Reload webview onResume
    @Override
    public void onResume() {
        super.onResume();
        //hide loading image
        findViewById(R.id.splash_image).setVisibility(View.VISIBLE);
        //show webview
        findViewById(R.id.activity_main_webview).setVisibility(View.GONE);
        mWebView.reload();
    }

}
