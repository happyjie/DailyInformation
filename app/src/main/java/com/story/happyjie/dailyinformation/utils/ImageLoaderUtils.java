package com.story.happyjie.dailyinformation.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.story.happyjie.dailyinformation.R;

/**
 * Created by llj on 2017/12/11.
 */

public class ImageLoaderUtils {

    /**
     * 显示头像
     * @param imageView
     * @param imageUrl
     */
    public static void showAvatar(ImageView imageView, String imageUrl){
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .crossFade(500)
                .error(R.drawable.default_avatar)
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into(imageView);
    }

    public static void showImage(ImageView imageView, String url){
        showImage(imageView, url, R.drawable.img_default, R.drawable.img_default);
    }

    public static void showImage(ImageView imageView, String url, int defaultImageResId){
        showImage(imageView, url, defaultImageResId, defaultImageResId);
    }

    public static void showImage(ImageView imageView, String url, int defaultImageResId, int errImageResId){
        Glide.with(imageView.getContext())
                .load(url)
                .crossFade(500)
                .placeholder(defaultImageResId)
                .error(errImageResId)
                .into(imageView);
    }



    @BindingAdapter({"android:showAdapterImage", "android:defaultImageType"})
    public static void showAdapterImage(ImageView imageView, String url, int defaultImageType){
        showImage(imageView, url, getDefaultPic(defaultImageType));
    }


    private static int getDefaultPic(int type) {
        switch (type) {
            case 0:// 电影
                return R.drawable.img_default_movie;
            case 1:// 妹子
                return R.drawable.img_default_meizi;
            case 2:// 书籍
                return R.drawable.img_default_book;
        }
        return R.drawable.img_default;
    }

    public static class GlideCircleTransform extends BitmapTransformation {

        public GlideCircleTransform(Context context) {
            super(context);
        }

        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return circleCrop(pool, toTransform);
        }

        private static Bitmap circleCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;
            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;
            // TODO this could be acquired from the pool too
            Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);
            Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);
            return result;
        }

        @Override
        public String getId() {
            return getClass().getName();
        }
    }
}
