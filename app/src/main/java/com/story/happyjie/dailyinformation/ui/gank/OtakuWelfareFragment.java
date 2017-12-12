package com.story.happyjie.dailyinformation.ui.gank;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseFragment;
import com.story.happyjie.dailyinformation.bean.BeautifulGrilBean;
import com.story.happyjie.dailyinformation.databinding.FragmentOtakuWelfareBinding;
import com.story.happyjie.dailyinformation.ui.gank.adapter.OtakuWelfareAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by llj on 2017/12/12.
 * 宅男福利
 */

public class OtakuWelfareFragment extends BaseFragment<FragmentOtakuWelfareBinding> {
    @Override
    protected int setContentView() {
        return R.layout.fragment_otaku_welfare;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showContentView();
    }

    @Override
    protected void initView() {
        super.initView();

        OtakuWelfareAdapter adapter = new OtakuWelfareAdapter();
        mViewBinding.recycleView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mViewBinding.recycleView.setAdapter(adapter);

        List<BeautifulGrilBean> list = new ArrayList<>();

        String[] urls = new String[]{
                "https://ws1.sinaimg.cn/large/610dc034ly1fhj53yz5aoj21hc0xcn41.jpg",
                "https://ws1.sinaimg.cn/large/610dc034ly1fhhz28n9vyj20u00u00w9.jpg",
                "https://ws1.sinaimg.cn/large/610dc034ly1fhgsi7mqa9j20ku0kuh1r.jpg",
                "https://ws1.sinaimg.cn/large/610dc034ly1fhfmsbxvllj20u00u0q80.jpg",
                "https://ws1.sinaimg.cn/large/610dc034ly1fhegpeu0h5j20u011iae5.jpg",
        };

        for (int i = 0; i < 100; i++) {
            list.add(new BeautifulGrilBean(urls[i % urls.length]));
        }
        adapter.setDatas(list);
    }
}
