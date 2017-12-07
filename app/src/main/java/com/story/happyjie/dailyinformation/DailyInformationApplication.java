package com.story.happyjie.dailyinformation;

import android.app.Application;

/**
 * Created by llj on 2017/12/7.
 */

public class DailyInformationApplication extends Application {

    private DailyInformationApplication dailyInformationApplication;

    public DailyInformationApplication getInstance() {
        return dailyInformationApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dailyInformationApplication = this;
    }
}
