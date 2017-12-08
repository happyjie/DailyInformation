package com.story.happyjie.dailyinformation;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.story.happyjie.dailyinformation.base.BaseActivity;
import com.story.happyjie.dailyinformation.databinding.ActivityMainBinding;

/**
 * Created by llj on 2017/12/7.
 */

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showContentView();
        mViewBinding.tvTest.setText("隔壁老王");
    }
}
