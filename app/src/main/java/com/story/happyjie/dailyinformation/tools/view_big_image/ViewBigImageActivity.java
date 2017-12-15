package com.story.happyjie.dailyinformation.tools.view_big_image;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.story.happyjie.dailyinformation.R;
import com.story.happyjie.dailyinformation.consts.GlobalConsts;
import com.story.happyjie.dailyinformation.utils.ToastUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


/**
 * 用于查看大图
 *
 * @author jingbin
 */
public class ViewBigImageActivity extends FragmentActivity implements OnPageChangeListener, OnPhotoTapListener {
    private ViewPager viewPager;
    private TextView btnSave;
    private TextView tvCurrentPage;

    public static final String PARAM_DATA = "param_data";
    public static final String PARAM_CUR_POSITION = "param_current_position";

    /**
     * 图片保存的地址
     */
    private static final String iamgeSavePath = GlobalConsts.BIG_IMAGE_SAVE_PATH;
    private List<ShowBigImageBean> imageList;
    private int curImagePosition;

    private ViewPagerAdapter adapter;

    public static void startAction(Context context, ArrayList<ShowBigImageBean> list, int curImagePosition) {
        if (null == list || 0 == list.size()) {
            ToastUtils.showToast("传图片列表不能为空");
            return;
        }

        if (curImagePosition < 0) {
            ToastUtils.showToast("当前图片位置不能小于0");
            return;
        }

        if (curImagePosition >= list.size()) {
            ToastUtils.showToast("当前图片位置不能大于图片总数");
            return;
        }

        Intent intent = new Intent(context, ViewBigImageActivity.class);
        intent.putParcelableArrayListExtra(PARAM_DATA, list);
        intent.putExtra(PARAM_CUR_POSITION, curImagePosition);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_big_image);

        imageList = getIntent().getParcelableArrayListExtra(PARAM_DATA);
        curImagePosition = getIntent().getIntExtra(PARAM_CUR_POSITION, 0);

        tvCurrentPage = (TextView) findViewById(R.id.very_image_viewpager_text);
        btnSave = (TextView) findViewById(R.id.tv_save_big_image);
        viewPager = (ViewPager) findViewById(R.id.very_image_viewpager);

        init();
    }


    /**
     * 保存图片至相册
     */
    public static void saveImageToGallery(Context context, Bitmap bmp) {
        // 首先保存图片
        File appDir = new File(iamgeSavePath);
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 其次把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(),
                    file.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 最后通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + file.getAbsoluteFile())));
    }


    /**
     * Glide 获得图片缓存路径
     */
    private String getImagePath(String imgUrl) {
        String path = null;
        FutureTarget<File> future = Glide.with(ViewBigImageActivity.this)
                .load(imgUrl)
                .downloadOnly(500, 500);
        try {
            File cacheFile = future.get();
            path = cacheFile.getAbsolutePath();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return path;
    }


    /*
     * 接收控件
     */
    private void init() {

        adapter = new ViewPagerAdapter();
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(curImagePosition);
        viewPager.setOnPageChangeListener(this);
        viewPager.setEnabled(false);
        tvCurrentPage.setText((curImagePosition + 1) + " / " + imageList.size());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ToastUtils.showToast("开始下载图片");
                ShowBigImageBean bean = imageList.get(curImagePosition);
                if (bean.getResId() > 0 && TextUtils.isEmpty(bean.getUrl())) {// app资源文件
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), bean.getResId());
                    if (bitmap != null) {
                        saveImageToGallery(ViewBigImageActivity.this, bitmap);
                        ToastUtils.showToast("保存成功");
                    }
                } else if (!TextUtils.isEmpty(bean.getUrl()) && bean.getUrl().startsWith("http")) {// 网络图片
                    final BitmapFactory.Options bmOptions = new BitmapFactory.Options();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // 子线程获得图片路径
                            final String imagePath = getImagePath(bean.getUrl());
                            Bitmap bitmap = BitmapFactory.decodeFile(imagePath, bmOptions);
                            if (bitmap != null) {
                                saveImageToGallery(ViewBigImageActivity.this, bitmap);
                                // 主线程更新
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ToastUtils.showToast("已保存至" + iamgeSavePath);
                                    }
                                });
                            }
                        }
                    }).start();
                }
            }
        });
    }

    @Override
    public void onPhotoTap(ImageView view, float x, float y) {
        finish();
    }

    /**
     * ViewPager的适配器
     *
     * @author guolin
     */
    class ViewPagerAdapter extends PagerAdapter {

        LayoutInflater inflater;

        ViewPagerAdapter() {
            inflater = getLayoutInflater();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = inflater.inflate(R.layout.viewpager_very_image, container, false);
            final PhotoView zoom_image_view = (PhotoView) view.findViewById(R.id.zoom_image_view);
            final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.loading);
            // 保存网络图片的路径
            ShowBigImageBean bean = (ShowBigImageBean) getItem(position);

            if (bean.getResId() > 0) {
                zoom_image_view.setImageResource(bean.getResId());
                progressBar.setVisibility(View.GONE);
                btnSave.setVisibility(View.VISIBLE);
            } else {
                //本地图片则不显示保存按钮
                if (!TextUtils.isEmpty(bean.getUrl()) && (bean.getUrl().startsWith("file") || bean.getUrl().startsWith("content"))) {
                    btnSave.setVisibility(View.GONE);
                } else {
                    btnSave.setVisibility(View.VISIBLE);
                }

                progressBar.setVisibility(View.VISIBLE);
                progressBar.setClickable(false);
                Glide.with(ViewBigImageActivity.this).load(bean.getUrl())
                        .crossFade(700)
                        .listener(new RequestListener<String, GlideDrawable>() {
                            @Override
                            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                                Toast.makeText(getApplicationContext(), "资源加载异常", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                return false;
                            }

                            //这个用于监听图片是否加载完成
                            @Override
                            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                            Toast.makeText(getApplicationContext(), "图片加载完成", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);

                                /**这里应该是加载成功后图片的高*/
                                int height = zoom_image_view.getHeight();

                                int wHeight = getWindowManager().getDefaultDisplay().getHeight();
                                if (height > wHeight) {
                                    zoom_image_view.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                } else {
                                    zoom_image_view.setScaleType(ImageView.ScaleType.FIT_CENTER);
                                }
                                return false;
                            }
                        }).into(zoom_image_view);
            }

            zoom_image_view.setOnPhotoTapListener(ViewBigImageActivity.this);
            container.addView(view, 0);
            return view;
        }

        @Override
        public int getCount() {
            if (imageList == null || imageList.size() == 0) {
                return 0;
            }
            return imageList.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }

        Object getItem(int position) {
            return imageList.get(position);
        }
    }

    /**
     * 下面是对Viewpager的监听
     */
    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    /**
     * 本方法主要监听viewpager滑动的时候的操作
     */
    @Override
    public void onPageSelected(int arg0) {
        // 每当页数发生改变时重新设定一遍当前的页数和总页数
        tvCurrentPage.setText((arg0 + 1) + " / " + imageList.size());
        curImagePosition = arg0;
    }
}
