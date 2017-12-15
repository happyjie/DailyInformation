package com.story.happyjie.dailyinformation.tools.view_big_image;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.IdRes;

/**
 * Created by llj on 2017/12/14.
 */

public class ShowBigImageBean implements Parcelable{
    private String url;
    private int resId;

    /**
     * 两个参数传一个就可以了,不要同时传两个
     * @param url
     * @param resId
     */
    public ShowBigImageBean(String url, @IdRes int resId) {
        this.url = url;
        this.resId = resId;
    }


    public String getUrl() {
        return url;
    }

    public int getResId() {
        return resId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeInt(this.resId);
    }

    public ShowBigImageBean() {
    }

    protected ShowBigImageBean(Parcel in) {
        this.url = in.readString();
        this.resId = in.readInt();
    }

    public static final Creator<ShowBigImageBean> CREATOR = new Creator<ShowBigImageBean>() {
        @Override
        public ShowBigImageBean createFromParcel(Parcel source) {
            return new ShowBigImageBean(source);
        }

        @Override
        public ShowBigImageBean[] newArray(int size) {
            return new ShowBigImageBean[size];
        }
    };
}
