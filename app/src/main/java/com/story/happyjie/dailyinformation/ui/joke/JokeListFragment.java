package com.story.happyjie.dailyinformation.ui.joke;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseFragment;
import com.story.happyjie.dailyinformation.bean.JokeContentTypeResult;
import com.story.happyjie.dailyinformation.cache.UserCacheWrapper;
import com.story.happyjie.dailyinformation.databinding.FragmentJokeListBinding;
import com.story.happyjie.dailyinformation.http.RequestCallBack;
import com.story.happyjie.dailyinformation.model.JokeContentTypeRequestModel;

import java.util.List;

import rx.Subscription;

/**
 * Created by llj on 2018/1/3.
 */

public class JokeListFragment extends BaseFragment<FragmentJokeListBinding>{

    private boolean isViewInited = false;
    private boolean isDateInited = false;

    private JokeContentTypeResult.DataBean contentTypeBean;

    @Override
    protected int setContentView() {
        return R.layout.fragment_joke_list;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showContentView();

        //获取contentType
        contentTypeBean = getJokeContentTypeFromCache();

        isViewInited = true;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    private JokeContentTypeResult.DataBean getJokeContentTypeFromCache(){
        JokeContentTypeResult result = UserCacheWrapper.getJokeContentType(getContext());

        if(null != result){
            if(System.currentTimeMillis() > 24*60*60*1000){
                requestJokeContentType();
            }

            List<JokeContentTypeResult.DataBean> list = result.getData();
            for(JokeContentTypeResult.DataBean bean : list){
                if("段子".equals(bean.getName())){
                    return bean;
                }
            }
        }
        return null;
    }

    private void requestJokeContentType(){
        JokeContentTypeRequestModel model = new JokeContentTypeRequestModel(getContext());
        model.getData(new RequestCallBack<JokeContentTypeResult>() {
            @Override
            public void onSuccess(JokeContentTypeResult obj) {
                if(null != obj){
                    obj.setTime(System.currentTimeMillis()); //记录数据时间
                    UserCacheWrapper.saveJokeContentType(getContext(), obj);
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void returnSubscription(Subscription subscription) {
                addSubscription(subscription);
            }
        });
    }
}
