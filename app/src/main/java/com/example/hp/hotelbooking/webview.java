package com.example.hp.hotelbooking;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by kunai on 17/8/17.
 */

public class webview extends Activity {
    ProgressBar progressBar;

    WebView w;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);

        w = (WebView) findViewById(R.id.webview);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        WebSettings webSettings = w.getSettings();
        webSettings.setJavaScriptEnabled(true);
        w.getSettings().setSupportZoom(true);
        w.getSettings().setBuiltInZoomControls(true);
        w.getSettings().setDisplayZoomControls(true);
        w.setWebViewClient(new MyWebClient(this));

        w.loadUrl(getIntent().getExtras().getString("url"));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.w.canGoBack()) {
            this.w.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

        class MyWebClient extends WebViewClient {
            Context context;


            public MyWebClient(Context context) {
                super();
                this.context = context;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                return  false;
                }


        }
    }

