package com.story.happyjie.dailyinformation.ui.joke;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseActivity;
import com.story.happyjie.dailyinformation.bean.JokeListResult;
import com.story.happyjie.dailyinformation.databinding.ActivityJokeDetailBinding;

/**
 * Created by llj on 2018/1/5.
 */

public class JokeDetailActivity extends BaseActivity<ActivityJokeDetailBinding> {

    private static final String PARAM_JOKE_DATA = "param_joke_data";
    private JokeListResult.DataBeanX.Data.Group mJokeData;

    public static void startAction(Context context, JokeListResult.DataBeanX.Data.Group jokeData){
        Intent intent = new Intent(context, JokeDetailActivity.class);
        intent.putExtra(PARAM_JOKE_DATA, jokeData);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_detail);
    }

    @Override
    protected void initView() {
        mJokeData = (JokeListResult.DataBeanX.Data.Group) getIntent().getSerializableExtra(PARAM_JOKE_DATA);
        mViewBinding.setGroup(mJokeData);

        setTitle(mJokeData.getUser().getName());

    }

    private void getData(){

    }
}
