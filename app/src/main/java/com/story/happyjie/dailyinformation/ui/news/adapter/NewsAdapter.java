package com.story.happyjie.dailyinformation.ui.news.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;
import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseAdapter.BaseRecycleViewAdapter;
import com.story.happyjie.dailyinformation.base.BaseAdapter.BaseRecycleViewHolder;
import com.story.happyjie.dailyinformation.bean.NewsDataResult;
import com.story.happyjie.dailyinformation.databinding.ItemNewsImageBinding;
import com.story.happyjie.dailyinformation.databinding.ItemNewsOneImageBinding;
import com.story.happyjie.dailyinformation.databinding.ItemNewsThreeImageBinding;

/**
 * Created by llj on 2017/12/15.
 */

public class NewsAdapter extends BaseRecycleViewAdapter<NewsDataResult.DataBean> {

    private static final int TYPE_SINGLE_IMAGE = 1;
    private static final int TYPE_THREE_IMAGES = 2;

    private Context context;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public BaseRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (TYPE_THREE_IMAGES == viewType) {
            return new ThreeImagesViewHolder(parent, R.layout.item_news_three_image);
        } else {
            return new SingleImageViewHolder(parent, R.layout.item_news_one_image);
        }
    }


    @Override
    public int getItemViewType(int position) {
        NewsDataResult.DataBean bean = getDatas().get(position);

        if (bean.getContentBean() != null && bean.getContentBean().getImage_list() != null
                && bean.getContentBean().getImage_list().size() >= 3) {
            return TYPE_THREE_IMAGES;
        } else {
            return TYPE_SINGLE_IMAGE;
        }
    }

    private class SingleImageViewHolder extends BaseRecycleViewHolder<NewsDataResult.DataBean, ItemNewsOneImageBinding> {

        public SingleImageViewHolder(ViewGroup parent, @LayoutRes int layoutId) {
            super(parent, layoutId);
        }

        @Override
        protected void onBindViewHolder(NewsDataResult.DataBean object, int position) {
            mViewBinding.setBean(object);

            mViewBinding.include.tvAuthor.setText(object.getContentBean().getSource());
            mViewBinding.include.tvHotFlag.setVisibility(1 == object.getContentBean().getHot() ? View.VISIBLE : View.GONE);
            mViewBinding.include.tvCommentaries.setText(object.getContentBean().getComment_count() + "评论");
//            mViewBinding.include.tvTime.setText(object.getContentBean().getPublish_time());
            itemView.setOnClickListener((v) -> {
                if (clickListener != null) {
                    clickListener.onClick(object, position);
                }
            });
            mViewBinding.executePendingBindings();
        }
    }

    private class ThreeImagesViewHolder extends BaseRecycleViewHolder<NewsDataResult.DataBean, ItemNewsThreeImageBinding> {

        public ThreeImagesViewHolder(ViewGroup parent, @LayoutRes int layoutId) {
            super(parent, layoutId);
        }

        @Override
        protected void onBindViewHolder(NewsDataResult.DataBean object, int position) {
            mViewBinding.setBean(object);

            mViewBinding.include.tvAuthor.setText(object.getContentBean().getSource());
            mViewBinding.include.tvHotFlag.setVisibility(1 == object.getContentBean().getHot() ? View.VISIBLE : View.GONE);
            mViewBinding.include.tvCommentaries.setText(object.getContentBean().getComment_count() + "评论");
//            mViewBinding.include.tvTime.setText(object.getContentBean().getPublish_time());
            itemView.setOnClickListener((v) -> {
                if (clickListener != null) {
                    clickListener.onClick(object, position);
                }
            });

            mViewBinding.rcvThreePic.setLayoutManager(new GridLayoutManager(context, 3));
            mViewBinding.rcvThreePic.setAdapter(new ImageAdapter());

            mViewBinding.executePendingBindings();
        }
    }

    private static class ImageAdapter extends BaseRecycleViewAdapter<String>{

        @Override
        public BaseRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ImageViewHolder(parent, R.layout.item_news_image);
        }

        private class ImageViewHolder extends BaseRecycleViewHolder<String, ItemNewsImageBinding>{

            public ImageViewHolder(ViewGroup parent, @LayoutRes int layoutId) {
                super(parent, layoutId);
            }

            @Override
            protected void onBindViewHolder(String object, int position) {
                mViewBinding.setUrl(object);
                mViewBinding.executePendingBindings();
            }
        }

    }
}
