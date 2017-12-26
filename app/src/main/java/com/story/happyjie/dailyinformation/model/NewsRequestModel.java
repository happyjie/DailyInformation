package com.story.happyjie.dailyinformation.model;

import com.story.happyjie.dailyinformation.api.ApiService;
import com.story.happyjie.dailyinformation.bean.GankIoDataResult;
import com.story.happyjie.dailyinformation.bean.NewsDataResult;
import com.story.happyjie.dailyinformation.consts.PreferenceConsts;
import com.story.happyjie.dailyinformation.http.RequestCallBack;
import com.story.happyjie.dailyinformation.model.base.BaseRequestModel;
import com.story.happyjie.dailyinformation.utils.SharedPreferenceUtils;

/**
 * Created by llj on 2017/12/15.
 */

public class NewsRequestModel extends BaseRequestModel{

    private String category;
    private int refer = 1;
    private int count = 30;
    private long min_behot_time;    //上次请求时间的时间戳
    private long last_refresh_sub_entrance_interval; //本次请求时间的时间戳
    private int loc_mode = 7;
    private long loc_time;  //本地时间
    private double latitude = 23.20; //经度
    private double longitude = 113.30;//纬度
    private String city = "广州";     //当前城市


    public NewsRequestModel(String category) {
        this.category = category;
        this.min_behot_time = SharedPreferenceUtils.getLong(PreferenceConsts.NEWS_LAST_REQUEST_TIME + category, 0L);
        this.last_refresh_sub_entrance_interval = System.currentTimeMillis();
        this.loc_time = last_refresh_sub_entrance_interval;
        SharedPreferenceUtils.putLong(PreferenceConsts.NEWS_LAST_REQUEST_TIME + category, last_refresh_sub_entrance_interval);
    }

    public void getData(RequestCallBack<NewsDataResult> callBack){
        request(ApiService.newsApiService.getNewsData(category, refer, count, min_behot_time, last_refresh_sub_entrance_interval,
                loc_mode, loc_time, latitude, longitude, city), callBack);
    }
}
