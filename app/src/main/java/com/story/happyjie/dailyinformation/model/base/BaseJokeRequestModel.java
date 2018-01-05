package com.story.happyjie.dailyinformation.model.base;

import android.content.Context;

import com.lib.llj.utils.DeviceUtils;
import com.lib.llj.utils.NetworkUtils;

/**
 * Created by llj on 2018/1/3.
 */

public class BaseJokeRequestModel extends BaseRequestModel {
    protected int essence = 1;
    protected String ac;
    protected String app_name = "joke_essay";
    protected int version_code = 612;
    protected String version_name = "6.1.2";
    protected String device_platform = "android";
    protected String channel = "360";
    protected String device_type;
    protected String device_brand;
    protected int os_api;
    protected String os_version;

    public BaseJokeRequestModel(Context context) {
        ac = NetworkUtils.getNetWorkTypeName(context);
        device_type = DeviceUtils.getModel();
        device_brand = DeviceUtils.getManufacturer();
        os_api = DeviceUtils.getSDKVersion();
        os_version = DeviceUtils.getSystemVersionName();
    }
}
