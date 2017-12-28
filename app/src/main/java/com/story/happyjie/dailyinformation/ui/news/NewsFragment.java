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
 * | 标签        | category 值           |
 | ------------- |:-------------:|
 |  热点    | news_hot |
 |  视频    |   video    |
 | 社会 |   news_society    |
 | 娱乐 |   news_entertainment    |
 | 问答 |    question_and_answer   |
 | 图片 |    组图   |
 | 科技 |   news_tech    |
 | 汽车 |   news_car    |
 | 体育 |  news_sport     |
 | 财经 |   news_finance    |
 | 军事 |    news_military   |
 | 国际 |   news_world    |
 | 段子 |   essay_joke    |
 | 趣图 |   image_funny    |
 */

public class NewsFragment extends BaseFragment<FragmentNewsBinding> {

    private boolean isInited = false;
    private boolean isAddFragment = false;

    @Override
    protected int setContentView() {
        return R.layout.fragment_news;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showContentView();
        if(mIsVisible) {
            initChildFragment();
        }
        isInited = true;
    }

    @Override
    protected void onVisible() {
        if(isInited && !isAddFragment){
            initChildFragment();
        }
    }

    private void initChildFragment(){
        List<Fragment> fragmentList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();

        String titles[] = new String[]{"热门","社会","娱乐","段子","科技","体育","汽车","财经","军事","国际"};
        String types[] = new String[]{"news_hot","news_society","news_entertainment","essay_joke",
                "news_tech","news_sport","news_car","news_finance","news_military","news_world"};

        for(int i = 0; i < titles.length; i++){
            titleList.add(titles[i]);
            fragmentList.add(ClassificationNewsFragment.getInstance(types[i], titles[i]));
        }

        MyFragmentPagerAdapter fragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), fragmentList, titleList);
        mViewBinding.vpNews.setAdapter(fragmentPagerAdapter);
        mViewBinding.vpNews.setCurrentItem(0);
        mViewBinding.vpNews.setOffscreenPageLimit(10);
        mViewBinding.tableLayout.setupWithViewPager(mViewBinding.vpNews);
        mViewBinding.tableLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        isAddFragment = true;
    }
}
