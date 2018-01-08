package com.story.happyjie.dailyinformation.ui.joke;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseActivity;
import com.story.happyjie.dailyinformation.bean.JokeCommentResult;
import com.story.happyjie.dailyinformation.bean.JokeListResult;
import com.story.happyjie.dailyinformation.databinding.ActivityJokeDetailBinding;
import com.story.happyjie.dailyinformation.http.RequestCallBack;
import com.story.happyjie.dailyinformation.model.JokeCommentRequestModel;
import com.story.happyjie.dailyinformation.ui.joke.adapter.JokeCommentAdapter;

import rx.Subscription;

/**
 * Created by llj on 2018/1/5.
 */

public class JokeDetailActivity extends BaseActivity<ActivityJokeDetailBinding> {

    private static final String PARAM_JOKE_DATA = "param_joke_data";
    private static final String STRING_HEAD = "#搞笑段子#";
    private JokeListResult.DataBeanX.Data.Group mJokeData;

    private JokeCommentAdapter mHotAdapter, mNewAdapter;
    private int mCurrentCommentNum = 0;

    public static void startAction(Context context, JokeListResult.DataBeanX.Data.Group jokeData) {
        Intent intent = new Intent(context, JokeDetailActivity.class);
        intent.putExtra(PARAM_JOKE_DATA, jokeData);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_detail);
    }

    @Override
    protected void initView() {
        showContentView();
        mJokeData = (JokeListResult.DataBeanX.Data.Group) getIntent().getSerializableExtra(PARAM_JOKE_DATA);
        mViewBinding.setGroup(mJokeData);

        setTitle(mJokeData.getUser().getName());

        SpannableString spannableString = new SpannableString(STRING_HEAD + mJokeData.getText());
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.text_joke_pink_color)),
                0, STRING_HEAD.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mViewBinding.tvContent.setText(spannableString);

//        mViewBinding.smartRefreshLayout.setEnableNestedScroll(false);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        layoutManager1.setSmoothScrollbarEnabled(true);
        layoutManager1.setAutoMeasureEnabled(true);
        mHotAdapter = new JokeCommentAdapter();
        mViewBinding.rcyHotComment.setLayoutManager(layoutManager1/*new FullyLinearLayoutManager(this)*/);
        mViewBinding.rcyHotComment.setHasFixedSize(true);
        mViewBinding.rcyHotComment.setNestedScrollingEnabled(false);
        mViewBinding.rcyHotComment.setAdapter(mHotAdapter);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setSmoothScrollbarEnabled(true);
        layoutManager2.setAutoMeasureEnabled(true);
        mNewAdapter = new JokeCommentAdapter();
        mViewBinding.rcyNewComment.setLayoutManager(layoutManager2/*new FullyLinearLayoutManager(this)*/);
        mViewBinding.rcyNewComment.setHasFixedSize(true);
        mViewBinding.rcyNewComment.setNestedScrollingEnabled(false);
        mViewBinding.rcyNewComment.setAdapter(mNewAdapter);

        showHotComment(false);
        showNewComment(false);
        getData(0);
    }

    @Override
    protected void initListener() {
        mViewBinding.smartRefreshLayout.setEnableRefresh(false);
        mViewBinding.smartRefreshLayout.setEnableLoadmore(false);
        mViewBinding.smartRefreshLayout.setEnableAutoLoadmore(true);
        mViewBinding.smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                getData(mCurrentCommentNum);
            }
        });
    }

    private void getData(int offset) {
        JokeCommentRequestModel model = new JokeCommentRequestModel(this, mJokeData.getGroupId(), mJokeData.getId(), offset);
        model.getData(new RequestCallBack<JokeCommentResult>() {
            @Override
            public void onSuccess(JokeCommentResult result) {

                mViewBinding.smartRefreshLayout.finishLoadmore();
                if (result != null && "success".equals(result.getMessage())
                        && result.getTotal_number() > 0 && result.getData() != null) {
                    if (result.getData().getTop_comments() != null
                            && result.getData().getTop_comments().size() > 0){
                        showHotComment(true);
                        mHotAdapter.setDatas(result.getData().getTop_comments());
                    }

                    if(result.getData().getRecent_comments() != null
                        && result.getData().getRecent_comments().size() > 0){
                        showNewComment(true);
                        mNewAdapter.addAll(result.getData().getRecent_comments());
                        mCurrentCommentNum += result.getData().getRecent_comments().size();
                    }

                    if(mCurrentCommentNum < result.getTotal_number()){
                        mViewBinding.smartRefreshLayout.setEnableLoadmore(true);
                    } else {
                        mViewBinding.smartRefreshLayout.setEnableLoadmore(false);
                    }
                }
            }

            @Override
            public void onError(Throwable throwable) {
                Logger.i("onError", throwable.toString());
                mViewBinding.smartRefreshLayout.finishLoadmore();
            }

            @Override
            public void returnSubscription(Subscription subscription) {
                addSubscription(subscription);
            }
        });
    }

    private void showHotComment(boolean bool) {
        mViewBinding.tvHotCommentTab.setVisibility(bool ? View.VISIBLE : View.GONE);
        mViewBinding.rcyHotComment.setVisibility(bool ? View.VISIBLE : View.GONE);
    }

    private void showNewComment(boolean bool) {
        mViewBinding.tvNewCommentTab.setVisibility(bool ? View.VISIBLE : View.GONE);
        mViewBinding.rcyNewComment.setVisibility(bool ? View.VISIBLE : View.GONE);
    }
}
