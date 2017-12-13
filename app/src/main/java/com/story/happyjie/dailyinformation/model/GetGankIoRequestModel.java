package com.story.happyjie.dailyinformation.model;

import com.story.happyjie.dailyinformation.api.ApiService;
import com.story.happyjie.dailyinformation.bean.GankIoDataBean;
import com.story.happyjie.dailyinformation.http.RequestCallBack;
import com.story.happyjie.dailyinformation.model.base.BaseRequestModel;

/**
 * Created by llj on 2017/12/13.
 */

public class GetGankIoRequestModel extends BaseRequestModel{
    private String type;
    private int per_page = 30;
    private int page;

    public GetGankIoRequestModel(String type, int page) {
        this.type = type;
        this.page = page;
    }

    public void getData(RequestCallBack<GankIoDataBean> callBack){
        request(ApiService.gankApiService.getGankIoData(type, per_page, page), callBack);
    }

}
