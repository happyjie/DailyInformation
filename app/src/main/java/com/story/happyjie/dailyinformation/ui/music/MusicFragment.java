package com.story.happyjie.dailyinformation.ui.music;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseFragment;
import com.story.happyjie.dailyinformation.databinding.FragmentGankBinding;
import com.story.happyjie.dailyinformation.databinding.FragmentMusicBinding;

/**
 * Created by llj on 2017/12/12.
 */

public class MusicFragment extends BaseFragment<FragmentMusicBinding> {

    @Override
    protected int setContentView() {
        return R.layout.fragment_music;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showContentView();
    }
}
