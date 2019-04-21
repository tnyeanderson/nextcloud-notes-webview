package com.tnyeanderson.nextcloudnotes;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class MyWebViewClient extends WebViewClient {

    /*
    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Uri uri = Uri.parse(url);
        if (uri.getHost() != null && uri.getHost().contains("example.com")) {
            return false;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        //hide loading image
        view.findViewById(R.id.splash_image).setVisibility(View.GONE);
        //show webview
        view.findViewById(R.id.activity_main_webview).setVisibility(View.VISIBLE);
    }
    */
}
