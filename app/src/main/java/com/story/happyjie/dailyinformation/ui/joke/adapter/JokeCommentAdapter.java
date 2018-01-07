package com.story.happyjie.dailyinformation.ui.joke.adapter;

import android.view.ViewGroup;

import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseAdapter.BaseRecycleViewAdapter;
import com.story.happyjie.dailyinformation.base.BaseAdapter.BaseRecycleViewHolder;
import com.story.happyjie.dailyinformation.bean.JokeCommentResult;
import com.story.happyjie.dailyinformation.databinding.ItemJokeCommentBinding;

/**
 * Created by asus on 2018-01-06 .
 */

public class JokeCommentAdapter extends BaseRecycleViewAdapter<JokeCommentResult.DataBean.RecentCommentsBean> {
    @Override
    public BaseRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new JokeCommentViewHolder(parent, R.layout.item_joke_comment);
    }

    private class JokeCommentViewHolder extends BaseRecycleViewHolder<JokeCommentResult.DataBean.RecentCommentsBean, ItemJokeCommentBinding>{

        public JokeCommentViewHolder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
        }

        @Override
        protected void onBindViewHolder(JokeCommentResult.DataBean.RecentCommentsBean object, int position) {
            mViewBinding.setItem(object);
            mViewBinding.executePendingBindings();
        }
    }
}
