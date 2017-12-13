package com.story.happyjie.dailyinformation.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lib.llj.utils.SingleClickListener;
import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.databinding.FragmentBaseBinding;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by llj on 2017-12-11 .
 */

public abstract class BaseFragment<VDB extends ViewDataBinding> extends Fragment{
    protected VDB mViewBinding;
    protected FragmentBaseBinding mBaseBinding;
    protected LinearLayout llLoading;
    protected LinearLayout llError;
    protected AnimationDrawable mAnimationDrawable;
    private CompositeSubscription mCompositeSubscription;

    // fragment是否显示了
    protected boolean mIsVisible = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, null);
        mBaseBinding = DataBindingUtil.bind(view);

        mViewBinding = DataBindingUtil.inflate(getActivity().getLayoutInflater(), setContentView(), null, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        mViewBinding.getRoot().setLayoutParams(layoutParams);
        mBaseBinding.container.addView(mViewBinding.getRoot());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        llLoading = mBaseBinding.llProgressBar;
        llError = mBaseBinding.llError;
        // 点击加载失败布局
        llError.setOnClickListener(new SingleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                showLoading();
                onRefresh();
            }
        });
        mViewBinding.getRoot().setVisibility(View.GONE);

        initView();
        initListener();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        mIsVisible = isVisibleToUser;
        if(isVisibleToUser){
            onVisible();
        } else {
            onInvisible();
        }
    }

    /**
     *  设置布局
     * @return
     */
    protected abstract int setContentView();

    protected void initView(){

    }

    protected void initListener(){

    }


    /**
     * Fragment变为可见时调用此方法
     */
    protected void onVisible(){

    }

    /**
     * Fragment变为不可见时调用此方法
     */
    protected void onInvisible(){

    }

    /**
     * 加载失败后点击后的操作
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

    protected <T extends View> T getView(int id) {
        return (T) getView().findViewById(id);
    }

    public void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(s);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            this.mCompositeSubscription.unsubscribe();
        }
    }

    public void removeSubscription() {
        if (this.mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            this.mCompositeSubscription.unsubscribe();
        }
    }
}
