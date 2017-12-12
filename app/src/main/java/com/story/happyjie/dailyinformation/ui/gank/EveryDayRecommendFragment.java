package com.story.happyjie.dailyinformation.ui.gank;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseFragment;
import com.story.happyjie.dailyinformation.databinding.FragmentEverydayRecommendBinding;

/**
 * Created by llj on 2017/12/12.
 * 每日推荐
 */

public class EveryDayRecommendFragment extends BaseFragment<FragmentEverydayRecommendBinding> {
    @Override
    protected int setContentView() {
        return R.layout.fragment_everyday_recommend;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showContentView();
    }
}
