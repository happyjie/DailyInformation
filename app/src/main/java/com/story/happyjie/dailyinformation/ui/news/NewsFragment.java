package com.story.happyjie.dailyinformation.ui.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseFragment;
import com.story.happyjie.dailyinformation.databinding.FragmentNewsBinding;
import com.story.happyjie.dailyinformation.ui.adapter.MyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by llj on 2017/12/12.
 */

public class NewsFragment extends BaseFragment<FragmentNewsBinding> {

    @Override
    protected int setContentView() {
        return R.layout.fragment_news;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showContentView();
        initChildFragment();
    }

    private void initChildFragment(){
        List<Fragment> fragmenList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();

        fragmenList.add(new RecommendNewsFragment());
        fragmenList.add(new RecommendNewsFragment());
//        fragmenList.add(new CustomizatoinGankFragment());

        titleList.add("推荐");
        titleList.add("热门");
//        titleList.add("干货定制");


        MyFragmentPagerAdapter fragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), fragmenList, titleList);
        mViewBinding.vpNews.setAdapter(fragmentPagerAdapter);
        mViewBinding.vpNews.setCurrentItem(0);
        mViewBinding.tableLayout.setupWithViewPager(mViewBinding.vpNews);
        mViewBinding.tableLayout.setTabMode(TabLayout.MODE_FIXED);
    }
}
