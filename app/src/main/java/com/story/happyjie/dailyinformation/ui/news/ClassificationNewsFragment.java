package com.story.happyjie.dailyinformation.ui.news;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.header.CircleHeader;
import com.scwang.smartrefresh.header.PhoenixHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseAdapter.OnItemClickListener;
import com.story.happyjie.dailyinformation.base.BaseFragment;
import com.story.happyjie.dailyinformation.bean.NewsDataResult;
import com.story.happyjie.dailyinformation.databinding.FragmentClassificationNewsBinding;
import com.story.happyjie.dailyinformation.http.RequestCallBack;
import com.story.happyjie.dailyinformation.model.NewsRequestModel;
import com.story.happyjie.dailyinformation.ui.news.adapter.NewsAdapter;
import com.story.happyjie.dailyinformation.utils.ToastUtils;

import rx.Subscription;

/**
 * Created by llj on 2017/12/15.
 *
 */
public class ClassificationNewsFragment extends BaseFragment<FragmentClassificationNewsBinding> {

    private final static String PARAM_CLASSIFICATION = "param_classification";
    private final static String PARAM_TITLE = "param_title";

    private SmartRefreshLayout refreshLayout;
    private NewsAdapter mAdapter;
    private int mCurPage = 1;
    private boolean isViewInited = false;
    private boolean isDateInited = false;
    private String mClasssfication = "";
    private String mTitle = "";

    public static ClassificationNewsFragment getInstance(String classification, String title){
        ClassificationNewsFragment fragment = new ClassificationNewsFragment();
        Bundle args = new Bundle();
        args.putString(PARAM_CLASSIFICATION, classification);
        args.putString(PARAM_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mClasssfication = getArguments().getString(PARAM_CLASSIFICATION);
        mTitle = getArguments().getString(PARAM_TITLE);
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_classification_news;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showContentView();
    }

    @Override
    protected void initView() {
        super.initView();

        refreshLayout = mViewBinding.smartRefreshLayout;
        refreshLayout.setRefreshHeader(new PhoenixHeader(getContext()));

        mAdapter = new NewsAdapter(getContext());
        mViewBinding.recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        mViewBinding.recycleView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener<NewsDataResult.DataBean>() {

            @Override
            public void onClick(NewsDataResult.DataBean resultsBean, int position) {
                NewsDetailActivity.startAction(getActivity(), resultsBean.getContentBean().getUrl());
            }
        });
        if(mIsVisible){
            getData(mCurPage);
            isDateInited = true;
        }
        isViewInited = true;
    }

    @Override
    protected void onVisible() {
        if(isViewInited && !isDateInited){
            Logger.i("visible time="+System.currentTimeMillis());
//            getData(mCurPage);
            refreshLayout.autoRefresh(0);
            isDateInited = true;
        }
    }

    @Override
    protected void initListener() {
        super.initListener();

        refreshLayout.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mCurPage++;
                getData(mCurPage);
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mCurPage = 1;
                getData(mCurPage);
            }
        });
    }

    private void getData(int page){
//        if(mAdapter.isEmpty()){
//            showLoading();
//        }

        Logger.i("getData time="+System.currentTimeMillis());

        NewsRequestModel model = new NewsRequestModel(mClasssfication);
        model.getData(new RequestCallBack<NewsDataResult>() {
            @Override
            public void onSuccess(NewsDataResult bean) {
                showContentView();
                refreshLayout.finishRefresh();
                refreshLayout.finishLoadmore();

                if(!bean.isSuccess()){
                    if(1 == page){
                        showError();
                    } else {
                        ToastUtils.showToast("数据异常");
                    }
                    return;
                }

                if(bean.getData() != null && bean.getData().size() > 0){
                    for(NewsDataResult.DataBean item : bean.getData()){
                        item.setContentBean(new Gson().fromJson(item.getContent(), NewsDataResult.ContentBean.class));
                    }
                }

                showContentView();
                if (1 == page){
                    mAdapter.clear();
                }
                mAdapter.addAll(bean.getData());
            }

            @Override
            public void onError(Throwable throwable) {
                refreshLayout.finishRefresh();
                refreshLayout.finishLoadmore();

                if(mCurPage > 1) mCurPage--;
            }

            @Override
            public void returnSubscription(Subscription subscription) {
                addSubscription(subscription);
            }
        });
    }
}
