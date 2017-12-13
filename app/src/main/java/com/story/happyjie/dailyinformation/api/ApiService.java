package com.story.happyjie.dailyinformation.api;

import com.story.happyjie.dailyinformation.bean.GankIoDataBean;
import com.story.happyjie.dailyinformation.http.HttpUtils;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by llj on 2017/12/13.
 */

public interface ApiService {

    ApiService gankApiService = HttpUtils.getInstance().getGankApiService();
    ApiService musicApiService = HttpUtils.getInstance().getMusicApiService();
    ApiService doubanApiService = HttpUtils.getInstance().getDoubanApiService();

    /**
     * 分类数据: http://gank.io/api/data/数据类型/每页数据量/第几页
     * type 分类类型：福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * per_page 每页数据条数
     * page 第几页 从1开始
     * eg: http://gank.io/api/data/Android/10/1
     */
    @GET("data/{type}/{pre_page}/{page}")
    Observable<GankIoDataBean> getGankIoData(@Path("type") String type, @Path("pre_page") int pre_page, @Path("page") int page);
}
