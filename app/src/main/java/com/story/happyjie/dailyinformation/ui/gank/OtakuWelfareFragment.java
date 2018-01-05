package com.story.happyjie.dailyinformation.ui.gank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseAdapter.OnItemClickListener;
import com.story.happyjie.dailyinformation.base.BaseFragment;
import com.story.happyjie.dailyinformation.bean.GankIoDataResult;
import com.story.happyjie.dailyinformation.cache.UserCacheWrapper;
import com.story.happyjie.dailyinformation.databinding.FragmentOtakuWelfareBinding;
import com.story.happyjie.dailyinformation.http.RequestCallBack;
import com.story.happyjie.dailyinformation.model.GetGankIoRequestModel;
import com.story.happyjie.dailyinformation.tools.view_big_image.ShowBigImageBean;
import com.story.happyjie.dailyinformation.tools.view_big_image.ViewBigImageActivity;
import com.story.happyjie.dailyinformation.ui.gank.adapter.OtakuWelfareAdapter;
import com.story.happyjie.dailyinformation.utils.ToastUtils;

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
    private int mCurPage = 1;
    private ArrayList<ShowBigImageBean> imageList = new ArrayList<>();

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

        mAdapter.setOnItemClickListener(new OnItemClickListener<GankIoDataResult.ResultsBean>() {

            @Override
            public void onClick(GankIoDataResult.ResultsBean resultsBean, int position) {
                ViewBigImageActivity.startAction(getActivity(), imageList, position);
            }
        });

        List<GankIoDataResult.ResultsBean> list = UserCacheWrapper.getOtakuWelfareData(getContext());
        if(null != list){
            mAdapter.setDatas(list);
        } else {
            getData(mCurPage);
        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        refreshLayout.setEnableLoadmore(true);
        refreshLayout.setEnableRefresh(true);
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
        GetGankIoRequestModel model = new GetGankIoRequestModel("福利", page);
        model.getData(new RequestCallBack<GankIoDataResult>() {
            @Override
            public void onSuccess(GankIoDataResult bean) {
                refreshLayout.finishRefresh();
                refreshLayout.finishLoadmore();

                if(bean.isError()){
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
                    imageList.clear();
                }

                mAdapter.addAll(bean.getResults());
                for(int i = 0; i < bean.getResults().size(); i++){
                    ShowBigImageBean imageBean = new ShowBigImageBean(bean.getResults().get(i).getUrl(), 0);
                    imageList.add(imageBean);
                }

                //数据缓存
                if(1 == page) {
                    UserCacheWrapper.saveOtakuWelfareData(getContext(), bean);
                }
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
