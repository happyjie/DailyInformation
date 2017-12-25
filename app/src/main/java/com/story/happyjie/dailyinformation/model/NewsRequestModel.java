package com.story.happyjie.dailyinformation.model;

import com.story.happyjie.dailyinformation.api.ApiService;
import com.story.happyjie.dailyinformation.bean.GankIoDataResult;
import com.story.happyjie.dailyinformation.bean.NewsDataResult;
import com.story.happyjie.dailyinformation.http.RequestCallBack;
import com.story.happyjie.dailyinformation.model.base.BaseRequestModel;

/**
 * Created by llj on 2017/12/15.
 */

public class NewsRequestModel extends BaseRequestModel{

    private String category;
    private int refer = 1;
    private int count = 30;
//    private long min_behot_time;
//    private long last_refresh_sub_entrance_interval;

    public NewsRequestModel(String category) {
        this.category = category;
    }

    public void getData(RequestCallBack<NewsDataResult> callBack){
        request(ApiService.newsApiService.getNewsData(category, refer, count), callBack);
    }
}
