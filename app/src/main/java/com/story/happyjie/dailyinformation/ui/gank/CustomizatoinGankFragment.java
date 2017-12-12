package com.story.happyjie.dailyinformation.ui.gank;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseFragment;
import com.story.happyjie.dailyinformation.databinding.FragmentCustomizationGankBinding;

/**
 * Created by llj on 2017/12/12.
 * 干货定制
 */

public class CustomizatoinGankFragment extends BaseFragment<FragmentCustomizationGankBinding> {
    @Override
    protected int setContentView() {
        return R.layout.fragment_customization_gank;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showContentView();
    }
}
