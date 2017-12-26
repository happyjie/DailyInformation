package com.story.happyjie.dailyinformation.ui.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseAdapter.OnItemClickListener;
import com.story.happyjie.dailyinformation.base.BaseFragment;
import com.story.happyjie.dailyinformation.bean.GankIoDataResult;
import com.story.happyjie.dailyinformation.bean.NewsDataResult;
import com.story.happyjie.dailyinformation.databinding.FragmentOtakuWelfareBinding;
import com.story.happyjie.dailyinformation.databinding.FragmentRecommendNewsBinding;
import com.story.happyjie.dailyinformation.http.RequestCallBack;
import com.story.happyjie.dailyinformation.model.NewsRequestModel;
import com.story.happyjie.dailyinformation.ui.news.adapter.NewsAdapter;
import com.story.happyjie.dailyinformation.utils.ToastUtils;

import rx.Subscription;

/**
 * Created by llj on 2017/12/15.
 */

public class RecommendNewsFragment extends BaseFragment<FragmentRecommendNewsBinding> {

    private SmartRefreshLayout refreshLayout;
    private NewsAdapter mAdapter;
    private int mCurPage = 1;
    private boolean isViewInited = false;
    private boolean isDateInited = false;

    @Override
    protected int setContentView() {
        return R.layout.fragment_recommend_news;
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

        mAdapter = new NewsAdapter(getContext());
        mViewBinding.recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        mViewBinding.recycleView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener<NewsDataResult.DataBean>() {

            @Override
            public void onClick(NewsDataResult.DataBean resultsBean, int position) {
            }
        });
        isViewInited = true;
    }

    @Override
    protected void onVisible() {
        if(isViewInited && !isDateInited){
            getData(mCurPage);
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
        NewsRequestModel model = new NewsRequestModel("news_society");
        model.getData(new RequestCallBack<NewsDataResult>() {
            @Override
            public void onSuccess(NewsDataResult bean) {
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

                isDateInited = true;
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
