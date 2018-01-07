package com.story.happyjie.dailyinformation.ui.joke;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.header.PhoenixHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseAdapter.OnItemClickListener;
import com.story.happyjie.dailyinformation.base.BaseFragment;
import com.story.happyjie.dailyinformation.bean.JokeContentTypeResult;
import com.story.happyjie.dailyinformation.bean.JokeListResult;
import com.story.happyjie.dailyinformation.cache.UserCacheWrapper;
import com.story.happyjie.dailyinformation.consts.PreferenceConsts;
import com.story.happyjie.dailyinformation.databinding.FragmentJokeListBinding;
import com.story.happyjie.dailyinformation.http.RequestCallBack;
import com.story.happyjie.dailyinformation.model.GetJokeListRequestModel;
import com.story.happyjie.dailyinformation.model.JokeContentTypeRequestModel;
import com.story.happyjie.dailyinformation.ui.joke.adapter.JokeAdapter;
import com.story.happyjie.dailyinformation.utils.SharedPreferenceUtils;

import java.util.List;

import rx.Subscription;

/**
 * Created by llj on 2018/1/3.
 */

public class JokeListFragment extends BaseFragment<FragmentJokeListBinding>{

    private static final int ADD_DATE_TO_HEAD = 1;
    private static final int ADD_DATE_TO_END = 2;

    private boolean isViewInited = false;
    private boolean isDateInited = false;

    private SmartRefreshLayout refreshLayout;

    private JokeContentTypeResult.DataBean contentTypeBean;

    private JokeAdapter mAdapter;
//    private int mCurPage = 1;

    private boolean isGetDataAfterGetContentType = false;

    @Override
    protected int setContentView() {
        return R.layout.fragment_joke_list;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showContentView();

        isViewInited = true;
    }

    @Override
    protected void initView() {
        refreshLayout = mViewBinding.smartRefreshLayout;
        refreshLayout.setRefreshHeader(new PhoenixHeader(getContext()));

        mAdapter = new JokeAdapter(getContext());
        mViewBinding.recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        mViewBinding.recycleView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener<JokeListResult.DataBeanX.Data>() {
            @Override
            public void onClick(JokeListResult.DataBeanX.Data o, int position) {
                JokeDetailActivity.startAction(getContext(), o.getGroup());
            }
        });

        List<JokeListResult.DataBeanX.Data> cache = UserCacheWrapper.getJokeListData(getContext());

        if(null != cache){
            mAdapter.setDatas(cache);
        }

        //获取contentType
        contentTypeBean = getJokeContentTypeFromCache();

        if(mIsVisible){
            initData();
        }
        isViewInited = true;

    }

    @Override
    protected void initListener() {
        refreshLayout.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                getData(ADD_DATE_TO_END);
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                getData(ADD_DATE_TO_HEAD);
            }
        });
    }


    @Override
    protected void onVisible() {
        if(isViewInited && !isDateInited){
            initData();
        }
    }

    private JokeContentTypeResult.DataBean getJokeContentTypeFromCache(){
        JokeContentTypeResult result = UserCacheWrapper.getJokeContentType(getContext());

        if(null != result){
            if(System.currentTimeMillis() - result.getTime() > 24*60*60*1000){
                requestJokeContentType();
            }

            List<JokeContentTypeResult.DataBean> list = result.getData();
            for(JokeContentTypeResult.DataBean bean : list){
                if("段子".equals(bean.getName())){
                    return bean;
                }
            }
        } else {
            requestJokeContentType();
        }
        return null;
    }

    private void getData(int addDataPosition){
        if(null == contentTypeBean){
            isGetDataAfterGetContentType = true;
            requestJokeContentType();
            return;
        }

        GetJokeListRequestModel model = new GetJokeListRequestModel(getContext(), contentTypeBean.getList_id(),
                contentTypeBean.getUrl(), SharedPreferenceUtils.getLong(PreferenceConsts.JOKE_LAST_REQUEST_TIME, 0));

        model.getData(new RequestCallBack<JokeListResult>() {
            @Override
            public void onSuccess(JokeListResult obj) {
                refreshLayout.finishRefresh();
                refreshLayout.finishLoadmore();
                if("success".equals(obj.getMessage())){
                    if(ADD_DATE_TO_HEAD == addDataPosition){
                        mAdapter.addAllToFront(obj.getDataBeanX().getData());
                    } else {
                        mAdapter.addAll(obj.getDataBeanX().getData());
                    }
                    SharedPreferenceUtils.putLong(PreferenceConsts.JOKE_LAST_REQUEST_TIME, obj.getDataBeanX().getMin_time());
                    UserCacheWrapper.saveJokeListData(getContext(), obj);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                refreshLayout.finishRefresh();
                refreshLayout.finishLoadmore();
            }

            @Override
            public void returnSubscription(Subscription subscription) {
                addSubscription(subscription);
            }
        });
    }

    private void requestJokeContentType(){
        JokeContentTypeRequestModel model = new JokeContentTypeRequestModel(getContext());
        model.getData(new RequestCallBack<JokeContentTypeResult>() {
            @Override
            public void onSuccess(JokeContentTypeResult obj) {
                if(null != obj){
                    obj.setTime(System.currentTimeMillis()); //记录数据时间
                    UserCacheWrapper.saveJokeContentType(getContext(), obj);
                    contentTypeBean = getJokeContentTypeFromCache();
                    if(isGetDataAfterGetContentType) {
                        getData(ADD_DATE_TO_HEAD);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                Logger.e(e.toString(), "onError()");
            }

            @Override
            public void returnSubscription(Subscription subscription) {
                addSubscription(subscription);
            }
        });
    }

    private void initData(){
        if(null == contentTypeBean){
            isGetDataAfterGetContentType = true;
            return;
        }

        refreshLayout.autoRefresh(0);
        isDateInited = true;
    }
}
