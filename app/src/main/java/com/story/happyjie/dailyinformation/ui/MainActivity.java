package com.story.happyjie.dailyinformation.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.lib.llj.utils.SingleClickListener;
import com.lib.llj.utils.StatusBarUtil;
import com.lib.llj.widget.MenuItemView;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.base.BaseActivity;
import com.story.happyjie.dailyinformation.databinding.ActivityMainBinding;
import com.story.happyjie.dailyinformation.databinding.LayoutSlideMenuBinding;
import com.story.happyjie.dailyinformation.ui.adapter.MyFragmentPagerAdapter;
import com.story.happyjie.dailyinformation.ui.douban.DoubanFragment;
import com.story.happyjie.dailyinformation.ui.gank.GankFragment;
import com.story.happyjie.dailyinformation.ui.music.MusicFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by llj on 2017/12/7.
 */

public class MainActivity extends BaseActivity<ActivityMainBinding> implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ImageView btnMenu, btnGank, btnMusic, btnDouban;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        super.initView();
        setToolbarVisible(false);
        showContentView();
        initViewId();
        initDrawerLayout();
        initContentView();

        StatusBarUtil.setColorNoTranslucentForDrawerLayout(MainActivity.this, drawerLayout,
                getResources().getColor(R.color.colorTheme));
    }

    @Override
    protected void initListener() {
        super.initListener();
        btnMenu.setOnClickListener(this);
        btnGank.setOnClickListener(this);
        btnMusic.setOnClickListener(this);
        btnDouban.setOnClickListener(this);
    }

    private void initViewId() {
        drawerLayout = mViewBinding.drawerLayout;
        navigationView = mViewBinding.navView;
        btnMenu = mViewBinding.toolBar.ivTitleMenu;
        btnGank = mViewBinding.toolBar.ivTitleGank;
        btnMusic = mViewBinding.toolBar.ivTitleMusic;
        btnDouban = mViewBinding.toolBar.ivTitleDouban;
    }

    private void initContentView() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new GankFragment());
        fragmentList.add(new MusicFragment());
        fragmentList.add(new DoubanFragment());
        List<String> titleList = new ArrayList<>();
        titleList.add("干货");
        titleList.add("音乐");
        titleList.add("豆瓣");

        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList, titleList);
        mViewBinding.vpContent.setAdapter(pagerAdapter);
        mViewBinding.vpContent.setOffscreenPageLimit(2);    //设置ViewPager预加载的页面个数
        mViewBinding.toolBar.ivTitleGank.setSelected(true);
        mViewBinding.vpContent.setCurrentItem(0);
        mViewBinding.vpContent.addOnPageChangeListener(this);
    }

    private LayoutSlideMenuBinding slideMenuBinding;

    /**
     * inflateHeaderView 进来的布局要宽一些
     */
    private void initDrawerLayout() {
        navigationView.inflateHeaderView(R.layout.layout_slide_menu);
        View headerView = navigationView.getHeaderView(0);
        slideMenuBinding = DataBindingUtil.bind(headerView);

//        GlideUtils.showAvatar(slideMenuBinding.ivAvatar, "");
//        slideMenuBinding.ivAvatar.setOnClickListener(listener);
        slideMenuBinding.menuGoHome.setOnClickListener(listener);
        slideMenuBinding.menuAppRecommend.setOnClickListener(listener);
        slideMenuBinding.menuFeedback.setOnClickListener(listener);
        slideMenuBinding.menuAboutUs.setOnClickListener(listener);
        slideMenuBinding.menuExit.setOnClickListener(listener);
    }

    private SingleClickListener listener = new SingleClickListener() {
        @Override
        protected void onNoDoubleClick(View v) {
            drawerLayout.closeDrawer(GravityCompat.START);
            drawerLayout.postDelayed(() -> {
                switch (v.getId()) {
                    case R.id.menu_go_home:
                        break;
                    case R.id.menu_app_recommend:
                        break;
                    case R.id.menu_feedback:
                        break;
                    case R.id.menu_about_us:
                        break;
                    case R.id.menu_exit:
                        break;
                }

                if (v instanceof MenuItemView) {
                    Toast.makeText(MainActivity.this, ((MenuItemView) v).getMenuTitle(), Toast.LENGTH_SHORT).show();
                }
            }, 200);
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_title_menu:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.iv_title_gank:
                mViewBinding.vpContent.setCurrentItem(0);
                break;
            case R.id.iv_title_music:
                mViewBinding.vpContent.setCurrentItem(1);
                break;
            case R.id.iv_title_douban:
                mViewBinding.vpContent.setCurrentItem(2);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                // 不退出程序，进入后台
                moveTaskToBack(true);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        ImageView[] ivs = new ImageView[]{btnGank, btnMusic, btnDouban};

        if(position >= ivs.length){
            Logger.e("viewPager 越界, position = " + position);
            return;
        }

        for(ImageView iv : ivs){
            iv.setSelected(false);
        }

        ivs[position].setSelected(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
