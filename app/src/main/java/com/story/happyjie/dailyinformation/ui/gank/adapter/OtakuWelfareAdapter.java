package com.story.happyjie.dailyinformation.ui.gank.adapter;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseAdapter.BaseRecycleViewAdapter;
import com.story.happyjie.dailyinformation.base.BaseAdapter.BaseRecycleViewHolder;
import com.story.happyjie.dailyinformation.bean.GankIoDataBean;
import com.story.happyjie.dailyinformation.databinding.ItemOtakuWelfareBinding;

/**
 * Created by llj on 2017/12/12.
 */

public class OtakuWelfareAdapter extends BaseRecycleViewAdapter<GankIoDataBean.ResultsBean> {

    @Override
    public BaseRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent, R.layout.item_otaku_welfare);
    }

    private class ViewHolder extends BaseRecycleViewHolder<GankIoDataBean.ResultsBean, ItemOtakuWelfareBinding>{

        public ViewHolder(ViewGroup parent, @LayoutRes int layoutId) {
            super(parent, layoutId);
        }

        @Override
        protected void onBindViewHolder(GankIoDataBean.ResultsBean object, int position) {
            mViewBinding.setBean(object);
            mViewBinding.executePendingBindings();
            itemView.setOnClickListener((v) -> {
                if(clickListener != null){
                    clickListener.onClick(object, position);
                }
            });
        }
    }
}
