package com.story.happyjie.dailyinformation.ui.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
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

        mAdapter = new NewsAdapter();
        mViewBinding.recycleView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mViewBinding.recycleView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener<GankIoDataResult.ResultsBean>() {

            @Override
            public void onClick(GankIoDataResult.ResultsBean resultsBean, int position) {
            }
        });

        getData(mCurPage);
    }

    private void getData(int page){
        NewsRequestModel model = new NewsRequestModel("news_hot");
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
