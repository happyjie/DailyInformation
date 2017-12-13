package com.story.happyjie.dailyinformation.ui.gank;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseFragment;
import com.story.happyjie.dailyinformation.bean.BeautifulGrilBean;
import com.story.happyjie.dailyinformation.bean.GankIoDataBean;
import com.story.happyjie.dailyinformation.databinding.FragmentOtakuWelfareBinding;
import com.story.happyjie.dailyinformation.http.RequestCallBack;
import com.story.happyjie.dailyinformation.model.GetGankIoRequestModel;
import com.story.happyjie.dailyinformation.ui.gank.adapter.OtakuWelfareAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * Created by llj on 2017/12/12.
 * 宅男福利
 */

public class OtakuWelfareFragment extends BaseFragment<FragmentOtakuWelfareBinding> {

    private SmartRefreshLayout refreshLayout;
    private OtakuWelfareAdapter mAdapter;

    @Override
    protected int setContentView() {
        return R.layout.fragment_otaku_welfare;
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

        mAdapter = new OtakuWelfareAdapter();
        mViewBinding.recycleView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mViewBinding.recycleView.setAdapter(mAdapter);

        mAdapter.setDatas(generateTestData());

        getData(1);
    }

    @Override
    protected void initListener() {
        super.initListener();
        refreshLayout.setEnableLoadmore(true);
        refreshLayout.setEnableRefresh(true);
        refreshLayout.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mViewBinding.recycleView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.addAll(generateTestData());
                        refreshlayout.finishLoadmore();
                    }
                }, 1000);
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mViewBinding.recycleView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.setDatas(generateTestData());
                        refreshlayout.finishRefresh();
                    }
                }, 2000);
            }
        });
    }

    private void getData(int page){
        GetGankIoRequestModel model = new GetGankIoRequestModel("福利", page);
        model.getData(new RequestCallBack<GankIoDataBean>() {
            @Override
            public void onSuccess(GankIoDataBean obj) {
                Logger.i("onSuccess");
            }

            @Override
            public void onError(Throwable throwable) {
                Logger.i("onError-->" + throwable.getMessage());
            }

            @Override
            public void returnSubscription(Subscription subscription) {
                Logger.i("addSubscription-->" + subscription.toString());
                addSubscription(subscription);
            }
        });
    }

    private List<BeautifulGrilBean> generateTestData(){
        List<BeautifulGrilBean> list = new ArrayList<>();

        String[] urls = new String[]{
                "https://ws1.sinaimg.cn/large/610dc034ly1fhj53yz5aoj21hc0xcn41.jpg",
                "https://ws1.sinaimg.cn/large/610dc034ly1fhhz28n9vyj20u00u00w9.jpg",
                "https://ws1.sinaimg.cn/large/610dc034ly1fhgsi7mqa9j20ku0kuh1r.jpg",
                "https://ws1.sinaimg.cn/large/610dc034ly1fhfmsbxvllj20u00u0q80.jpg",
                "https://ws1.sinaimg.cn/large/610dc034ly1fhegpeu0h5j20u011iae5.jpg",
        };

        for (int i = 0; i < 20; i++) {
            list.add(new BeautifulGrilBean(urls[i % urls.length]));
        }
        return list;
    }
}
