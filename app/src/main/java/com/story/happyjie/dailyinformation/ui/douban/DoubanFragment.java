package com.story.happyjie.dailyinformation.ui.douban;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseFragment;
import com.story.happyjie.dailyinformation.databinding.FragmentDoubanBinding;

/**
 * Created by llj on 2017/12/12.
 */

public class DoubanFragment extends BaseFragment<FragmentDoubanBinding> {

    @Override
    protected int setContentView() {
        return R.layout.fragment_douban;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showContentView();
    }
}
