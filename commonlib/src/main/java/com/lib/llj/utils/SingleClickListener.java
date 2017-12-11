package com.lib.llj.utils;

import android.view.View;
import android.view.View.OnClickListener;

import java.util.Calendar;

/**
 * 防抖动点击监听器
 * Created by llj on 2017/12/08.
 */
public abstract class SingleClickListener implements OnClickListener {
    public static final int MIN_CLICK_DELAY_TIME = 500;
    private long lastClickTime = 0;
    private int lastClickViewid = -1;

    @Override
    public void onClick(View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (lastClickViewid != v.getId()) {
            lastClickViewid = v.getId();
            lastClickTime = currentTime;
            onNoDoubleClick(v);
            return;
        }
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            onNoDoubleClick(v);
        }
    }

    protected abstract void onNoDoubleClick(View v);
}
