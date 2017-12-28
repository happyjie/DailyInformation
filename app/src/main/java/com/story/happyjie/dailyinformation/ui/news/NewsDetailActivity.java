package com.story.happyjie.dailyinformation.ui.news;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseActivity;
import com.story.happyjie.dailyinformation.databinding.ActivityNewsDetailBinding;

/**
 * Created by llj on 2017/12/28.
 */

public class NewsDetailActivity extends BaseActivity<ActivityNewsDetailBinding> {
    private static final String PARAM_URL = "param_url";

    private String mUrl;

    public static void startAction(Context context, String url){
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra(PARAM_URL, url);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news_detail);

        mUrl = getIntent().getStringExtra(PARAM_URL);

        mViewBinding.webView.setWebViewClient(new WebViewClient());
        mViewBinding.webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    mViewBinding.progressbar.setVisibility(View.INVISIBLE);
                } else {
                    if (View.INVISIBLE == mViewBinding.progressbar.getVisibility()) {
                        mViewBinding.progressbar.setVisibility(View.VISIBLE);
                    }
                    mViewBinding.progressbar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

        });


//        webViewSetting();
        mViewBinding.webView.getSettings().setJavaScriptEnabled(true);
        showContentView();

        mViewBinding.webView.loadUrl(mUrl);
    }

    /**
     * webView设置
     */
    private void webViewSetting() {
        WebSettings settings = mViewBinding.webView.getSettings();
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAllowFileAccess(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(true);
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setAppCacheMaxSize(Long.MAX_VALUE);
        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
    }
}
