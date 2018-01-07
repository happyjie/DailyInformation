package com.story.happyjie.dailyinformation.base.BaseAdapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by llj on 2017/12/12.
 */

public abstract class BaseRecycleViewHolder<T, V extends ViewDataBinding> extends RecyclerView.ViewHolder{

    public V mViewBinding;
    protected OnItemClickListener<T> clickListener;
    protected OnItemLongClickListener<T> longClickListener;

    public BaseRecycleViewHolder(ViewGroup parent, @LayoutRes int layoutId) {
        // 此处inflate布局时需要依附 parent，否则显示item不全!!
        super(DataBindingUtil.inflate( LayoutInflater.from(parent.getContext()), layoutId, parent, false).getRoot());

        mViewBinding = DataBindingUtil.getBinding(super.itemView);
    }

    protected abstract void onBindViewHolder(T object, final int position);

    /**
     * 数据与View绑定
     * 当数据改变时，binding会在下一帧去改变数据，如果我们需要立即改变，就去调用executePendingBindings方法。
     * @param obj
     * @param position
     */
    public void bindData(T obj, final int position){
        if(clickListener != null) {
            itemView.setOnClickListener((v) -> clickListener.onClick(obj, position));
        }
        if(longClickListener != null){
            itemView.setOnLongClickListener(v -> longClickListener.onClick(obj, position));
        }
        onBindViewHolder(obj, position);
        mViewBinding.executePendingBindings();
    }


    public void setOnItemClickListener(OnItemClickListener<T> listener){
        this.clickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener<T> longClickListener) {
        this.longClickListener = longClickListener;
    }
}
