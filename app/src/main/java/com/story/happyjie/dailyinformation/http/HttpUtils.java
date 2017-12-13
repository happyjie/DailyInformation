package com.story.happyjie.dailyinformation.http;

import com.lib.llj.http.HttpClient;
import com.story.happyjie.dailyinformation.api.ApiService;

/**
 * Created by llj on 2017/12/13.
 */

public class HttpUtils {

    // gankio、豆瓣、（轮播图）
    private final static String API_GANKIO = "https://gank.io/api/";
    private final static String API_MUSIC = "https://tingapi.ting.baidu.com/v1/restserver/";
    private final static String API_DOUBAN = "Https://api.douban.com/";

    private ApiService gankApiService;
    private ApiService musicApiService;
    private ApiService doubanApiService;

    private static HttpUtils instance;

    public static HttpUtils getInstance(){
        if(null == instance){
            synchronized (HttpUtils.class){
                if(null == instance){
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }

    public ApiService getGankApiService(){
        if(null == gankApiService) {
            synchronized (HttpUtils.class){
                if(null == gankApiService) {
                    gankApiService = HttpClient.getInstance().getRetrofit(API_GANKIO).create(ApiService.class);
                }
            }
        }
        return gankApiService;
    }

    public ApiService getMusicApiService(){
        if(null == musicApiService){
            synchronized (HttpUtils.class){
                if(null == musicApiService){
                    musicApiService = HttpClient.getInstance().getRetrofit(API_MUSIC).create(ApiService.class);
                }
            }
        }

        return musicApiService;
    }

    public ApiService getDoubanApiService(){
        if(null == doubanApiService){
            synchronized (HttpUtils.class){
                if(null == doubanApiService){
                    doubanApiService = HttpClient.getInstance().getRetrofit(API_DOUBAN).create(ApiService.class);
                }
            }
        }
        return doubanApiService;
    }
}
