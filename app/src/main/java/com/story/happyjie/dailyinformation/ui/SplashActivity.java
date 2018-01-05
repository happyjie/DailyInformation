package com.story.happyjie.dailyinformation.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.bumptech.glide.Glide;
import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.consts.ConstantsImageUrl;
import com.story.happyjie.dailyinformation.databinding.ActivitySplashBinding;

import java.util.Random;

/**
 * Created by llj on 2017/12/7.
 */

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        init();
    }


    private void init(){
        // 先显示默认图
        mBinding.ivDefaultPic.setImageResource(R.drawable.img_splash_default);

        int i = new Random().nextInt(ConstantsImageUrl.TRANSITION_URLS.length);
        Glide.with(this)
                .load(ConstantsImageUrl.TRANSITION_URLS[i])
                .placeholder(R.drawable.img_splash_default)
                .error(R.drawable.img_splash_default)
                .into(mBinding.ivPic);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.transition_anim);
        animation.setAnimationListener(animationListener);
        mBinding.ivDefaultPic.startAnimation(animation);

        mBinding.ivDefaultPic.postDelayed(() ->gotoMainActivity(), 3500);

        mBinding.tvJump.setOnClickListener(v -> gotoMainActivity());
    }

    /**
     * 动画监听
     */
    private Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            mBinding.ivDefaultPic.setVisibility(View.GONE);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    };


    private boolean isGotoMainActivity = false;
    private void gotoMainActivity(){
        if (isGotoMainActivity) {
            return;
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out);
        finish();
        isGotoMainActivity = true;
    }
}
