package com.story.happyjie.dailyinformation.application;

import android.app.Application;

import com.orhanobut.logger.Logger;

/**
 * Created by llj on 2017/12/7.
 */

public class DailyInformationApplication extends Application {

    private static final String TAG = DailyInformationApplication.class.getSimpleName();
    private static DailyInformationApplication dailyInformationApplication;

    public static DailyInformationApplication getInstance() {
        return dailyInformationApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dailyInformationApplication = this;
        //设置日志打印的tag
        Logger.init(TAG);
    }
}
