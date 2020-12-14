package com.example.yunusemre;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class Original_Turkish extends AppCompatActivity {

    WebView webViewTurk;
    private final int SPLASH_DISPLAY_LENGTH = 4000;
    private ProgressDialog mProgress1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_original__turkish);
        mProgress1 = new ProgressDialog(Original_Turkish.this);
        webViewTurk = findViewById(R.id.imageViewTurkish);

        webViewTurk.setWebViewClient(new Browser_Home());
        webViewTurk.setWebChromeClient(new ChromeClient3());
        WebSettings webSettings = webViewTurk.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String URL = bundle.getString("selectedSeason");
            loadWebsite(URL);
        }else {
            Toast.makeText(this, "یہ سیزن ابھی نہیں آیا", Toast.LENGTH_SHORT).show();
        }
//                loadWebsite();

    }

    public void loadWebsite(String url){
        if(isNetworkConnected()) {
            mProgress1.setMessage("please wait... ");
            mProgress1.show();

//        webViewTurk.loadUrl("https://www.youtube.com/watch?v=6ufrJgsIS70&list=PL5RIBq4IKO4UUTstS05O5LN5PrEPAhzsO");
            webViewTurk.loadUrl("" + url);
        }
        else {

            mProgress1.setMessage("Sorry! Turn on your internet... ");
            mProgress1.show();
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {

                    /* Create an Intent that will start the Menu-Activity. */
                    Intent intent = new Intent(getApplicationContext(),Categories.class);
                    startActivity(intent);
                    Original_Turkish.this.finish();

                }
            }, SPLASH_DISPLAY_LENGTH);


        }
    }


    private class Browser_Home extends WebViewClient {
        Browser_Home() {
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }

    public class ChromeClient3 extends WebChromeClient {
        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        protected FrameLayout mFullscreenContainer;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility;

        ChromeClient3() {
        }

        public Bitmap getDefaultVideoPoster() {
            if (mCustomView == null) {
                return null;

            }
            return BitmapFactory.decodeResource(getApplicationContext().getResources(), 2130837573);
        }
        public void onHideCustomView() {

            ((FrameLayout) getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {
            if (this.mCustomView != null) {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            this.mOriginalOrientation = getRequestedOrientation();
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout) getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
            getWindow().getDecorView().setSystemUiVisibility(3846 | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}