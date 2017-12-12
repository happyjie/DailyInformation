package com.story.happyjie.dailyinformation.base.BaseAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by llj on 2017/12/12.
 */

public abstract class BaseRecycleViewAdapter<T> extends RecyclerView.Adapter<BaseRecycleViewHolder> {

    private List<T> datas = new ArrayList<T>();

    @Override
    public void onBindViewHolder(BaseRecycleViewHolder holder, int position) {
        holder.bindData(datas.get(position), position);
    }

    @Override
    public int getItemCount() {
        return null == datas ? 0 : datas.size();
    }


    public void setDatas(List<T> list){
        datas.clear();
        addAll(list);
    }

    public void addAll(List<T> list){
        datas.addAll(list);
        notifyDataSetChanged();
    }

    public void add(T t){
        datas.add(t);
        notifyDataSetChanged();
    }

    public void remove(int position){
        datas.remove(position);
        notifyDataSetChanged();
    }

    public void remove(T t){
        datas.remove(t);
        notifyDataSetChanged();
    }

    /**
     * 添加数据到指定的位置
     * @param t
     * @param position
     */
    public void add(T t, int position){
        if(position >= getItemCount()){
            datas.add(getItemCount(), t);
        } else {
            datas.add(position, t);
        }
    }
}
