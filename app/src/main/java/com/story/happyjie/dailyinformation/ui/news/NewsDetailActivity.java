package com.story.happyjie.dailyinformation.ui.news;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
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

        setTitle(getString(R.string.app_name_chinese));

        mUrl = getIntent().getStringExtra(PARAM_URL);

        mViewBinding.webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(request.getUrl().toString());
                } else {
                    view.loadUrl(request.toString());
                }
                return true;
            }
        });
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


        webViewSetting();
//        mViewBinding.webView.getSettings().setJavaScriptEnabled(true);
        showContentView();

        mViewBinding.webView.loadUrl(mUrl/*"http://www.hao123.com"*/);
    }

    /**
     * webView设置
     */
    private void webViewSetting() {
        WebSettings settings = mViewBinding.webView.getSettings();
//        settings.setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        settings.setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
//        settings.setSupportZoom(true);//是否可以缩放，默认true
//        settings.setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
//        settings.setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
//        settings.setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        settings.setAppCacheEnabled(true);//是否使用缓存
        settings.setDomStorageEnabled(true);//DOM Storage
    }
}
