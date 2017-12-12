package com.story.happyjie.dailyinformation.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by llj on 2017/12/12.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentlist;
    private List<String> mTitleList;

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragmentlist, List<String> titleList) {
        super(fm);
        if(null == fragmentlist){
            fragmentlist = new ArrayList<>();
        }

        if(null == titleList){
            fragmentlist = new ArrayList<>();
        }

        mFragmentlist = fragmentlist;
        mTitleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return null == mFragmentlist ? 0 : mFragmentlist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if(null == mTitleList || mTitleList.size() < position){
            return "";
        } else {
            return mTitleList.get(position);
        }
    }
}
