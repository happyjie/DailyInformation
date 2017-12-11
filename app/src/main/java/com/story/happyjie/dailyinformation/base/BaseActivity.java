package com.story.happyjie.dailyinformation.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.lib.llj.utils.SingleClickListener;
import com.lib.llj.utils.StatusBarUtil;
import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.databinding.ActivityBaseBinding;

/**
 * Created by llj on 2017/12/8.
 */

public class BaseActivity<VDB extends ViewDataBinding> extends AppCompatActivity {

    protected ActivityBaseBinding mBaseBinding;
    protected VDB mViewBinding;
    protected LinearLayout llLoading;
    protected LinearLayout llError;
    protected AnimationDrawable mAnimationDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
//        super.setContentView(layoutResID);
        mBaseBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_base, null, false);
        mViewBinding = DataBindingUtil.inflate(getLayoutInflater(), layoutResID, null, false);

//        RelativeLayout rlContainer = mBaseBinding.container
        mBaseBinding.container.addView(mViewBinding.getRoot());
        super.setContentView(mBaseBinding.getRoot());

        llLoading = mBaseBinding.llProgressBar;
        llError = mBaseBinding.llError;

        //设置透明状态栏
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorTheme), 0);

        setToolBar();

        // 点击加载失败布局
        llError.setOnClickListener(new SingleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                showLoading();
                onRefresh();
            }
        });

        //先隐藏content布局
        mViewBinding.getRoot().setVisibility(View.GONE);
    }

    protected void setToolBarVisible(boolean visible){
        mBaseBinding.toolBar.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    /**
     * 设置titlebar
     */
    protected void setToolBar() {
        setSupportActionBar(mBaseBinding.toolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.icon_back);
        }
        mBaseBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    /**
     * 数据刷新
     */
    protected void onRefresh() {

    }

    /**
     * 加载动画
     */
    protected void showLoading() {
        if(null == mAnimationDrawable) {
            mAnimationDrawable = (AnimationDrawable) mBaseBinding.imgProgress.getDrawable();
        }

        if (llLoading.getVisibility() != View.VISIBLE) {
            llLoading.setVisibility(View.VISIBLE);
        }
        // 开始动画
        if (!mAnimationDrawable.isRunning()) {
            mAnimationDrawable.start();
        }
        if (mViewBinding.getRoot().getVisibility() != View.GONE) {
            mViewBinding.getRoot().setVisibility(View.GONE);
        }
        if (llError.getVisibility() != View.GONE) {
            llError.setVisibility(View.GONE);
        }
    }

    protected void showContentView() {
        if (llLoading.getVisibility() != View.GONE) {
            llLoading.setVisibility(View.GONE);
        }
        // 停止动画
        if (null != mAnimationDrawable && mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }
        if (llError.getVisibility() != View.GONE) {
            llError.setVisibility(View.GONE);
        }
        if (mViewBinding.getRoot().getVisibility() != View.VISIBLE) {
            mViewBinding.getRoot().setVisibility(View.VISIBLE);
        }
    }

    protected void showError() {
        if (llLoading.getVisibility() != View.GONE) {
            llLoading.setVisibility(View.GONE);
        }
        // 停止动画
        if (null != mAnimationDrawable && mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }
        if (llError.getVisibility() != View.VISIBLE) {
            llError.setVisibility(View.VISIBLE);
        }
        if (mViewBinding.getRoot().getVisibility() != View.GONE) {
            mViewBinding.getRoot().setVisibility(View.GONE);
        }
    }



    protected <V extends View> V getView(@IdRes int id){
        return (V) findViewById(id);
    }
}
