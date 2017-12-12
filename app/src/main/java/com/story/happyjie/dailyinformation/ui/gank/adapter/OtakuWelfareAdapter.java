package com.story.happyjie.dailyinformation.ui.gank.adapter;

import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseAdapter.BaseRecycleViewAdapter;
import com.story.happyjie.dailyinformation.base.BaseAdapter.BaseRecycleViewHolder;
import com.story.happyjie.dailyinformation.bean.BeautifulGrilBean;
import com.story.happyjie.dailyinformation.databinding.ItemOtakuWelfareBinding;

/**
 * Created by llj on 2017/12/12.
 */

public class OtakuWelfareAdapter extends BaseRecycleViewAdapter<BeautifulGrilBean> {

    @Override
    public BaseRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent, R.layout.item_otaku_welfare);
    }

    private class ViewHolder extends BaseRecycleViewHolder<BeautifulGrilBean, ItemOtakuWelfareBinding>{

        public ViewHolder(ViewGroup parent, @LayoutRes int layoutId) {
            super(parent, layoutId);
        }

        @Override
        protected void onBindViewHolder(BeautifulGrilBean object, int position) {
            mViewBinding.setBean(object);
            mViewBinding.executePendingBindings();
        }
    }
}
