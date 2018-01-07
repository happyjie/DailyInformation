package com.story.happyjie.dailyinformation.model;

import android.content.Context;

import com.story.happyjie.dailyinformation.api.ApiService;
import com.story.happyjie.dailyinformation.bean.JokeContentTypeResult;
import com.story.happyjie.dailyinformation.http.RequestCallBack;
import com.story.happyjie.dailyinformation.model.base.BaseJokeRequestModel;

/**
 * Created by llj on 2018/1/3.
 */

public class JokeContentTypeRequestModel extends BaseJokeRequestModel {

    public JokeContentTypeRequestModel(Context context) {
        super(context);
    }

    public void getData(RequestCallBack<JokeContentTypeResult> callBack){
        request(ApiService.jokeApiService.getJokeContentType(essence, ac, channel, app_name, version_code,
                version_name, device_platform, device_type, device_brand, os_api, os_version), callBack);
    }
}
