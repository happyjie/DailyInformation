package com.story.happyjie.dailyinformation.base.BaseAdapter;

/**
 * Created by llj on 2017/12/14.
 */

public interface OnItemLongClickListener<T> {
    boolean onClick(T t, int position);
}
