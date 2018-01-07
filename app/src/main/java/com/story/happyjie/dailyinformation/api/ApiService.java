package com.story.happyjie.dailyinformation.api;

import com.story.happyjie.dailyinformation.bean.GankIoDataResult;
import com.story.happyjie.dailyinformation.bean.JokeCommentResult;
import com.story.happyjie.dailyinformation.bean.JokeContentTypeResult;
import com.story.happyjie.dailyinformation.bean.JokeListResult;
import com.story.happyjie.dailyinformation.bean.NewsDataResult;
import com.story.happyjie.dailyinformation.http.HttpUtils;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by llj on 2017/12/13.
 */

public interface ApiService {

    ApiService gankApiService = HttpUtils.getInstance().getGankApiService();
//    ApiService musicApiService = HttpUtils.getInstance().getMusicApiService();
//    ApiService doubanApiService = HttpUtils.getInstance().getDoubanApiService();
    ApiService newsApiService = HttpUtils.getInstance().getNewsApi();
    ApiService jokeApiService = HttpUtils.getInstance().getJokeApi();

    /**
     * 分类数据: http://gank.io/api/data/数据类型/每页数据量/第几页
     * type 分类类型：福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * per_page 每页数据条数
     * page 第几页 从1开始
     * eg: http://gank.io/api/data/Android/10/1
     */
    @GET("data/{type}/{pre_page}/{page}")
    Observable<GankIoDataResult> getGankIoData(@Path("type") String type, @Path("pre_page") int pre_page, @Path("page") int page);


    /**
     * 获取今日头条的新闻数据
     * @return
     */
    @GET("feed/v54/")
    Observable<NewsDataResult> getNewsData(@Query("category") String category, @Query("refer") int refer, @Query("count") int count,
                                           @Query("min_behot_time") long min_behot_time,
                                           @Query("last_refresh_sub_entrance_interval") long last_refresh_sub_entrance_interval,
                                           @Query("loc_mode") int loc_mode, @Query("loc_time") long loc_time,
                                           @Query("latitude") double latitude, @Query("longitude") double longitude,
                                           @Query("city") String city);


    /**
     * 获取内涵段子分类数据
     * @param essence
     * @param ac
     * @param app_name
     * @param version_code
     * @param version_name
     * @param device_platform
     * @param device_type
     * @param device_brand
     * @param os_api
     * @param os_version
     * @return
     */
    @GET("neihan/service/tabs/")
    Observable<JokeContentTypeResult> getJokeContentType(@Query("essence") int essence, @Query("ac") String ac, @Query("channel") String channel,
                                                         @Query("app_name") String app_name, @Query("version_code") int version_code,
                                                         @Query("version_name") String version_name, @Query("device_platform") String device_platform,
                                                         @Query("device_type") String device_type, @Query("device_brand") String device_brand,
                                                         @Query("os_api") int os_api, @Query("os_version") String os_version);


    /**
     * 获取内涵段子列表
     * @param path
     * @param essence
     * @param ac
     * @param channel
     * @param app_name
     * @param version_code
     * @param version_name
     * @param device_platform
     * @param device_type
     * @param device_brand
     * @param os_api
     * @param os_version
     * @param webp
     * @param content_type
     * @param message_cursor
     * @param am_longitude
     * @param am_latitude
     * @param am_city
     * @param am_loc_time
     * @param count
     * @param min_time
     * @param double_col_mode
     * @return
     */
    @GET("{path}")
    Observable<JokeListResult> getJokeList(@Path("path") String path, @Query("essence") int essence, @Query("ac") String ac,
                                           @Query("channel") String channel, @Query("app_name") String app_name, @Query("version_code") int version_code,
                                           @Query("version_name") String version_name, @Query("device_platform") String device_platform,
                                           @Query("device_type") String device_type, @Query("device_brand") String device_brand,
                                           @Query("os_api") int os_api, @Query("os_version") String os_version,
                                           @Query("webp") int webp, @Query("content_type") int content_type, @Query("message_cursor") int message_cursor,
                                           @Query("am_longitude") String am_longitude, @Query("am_latitude") String am_latitude,
                                           @Query("am_city") String am_city, @Query("am_loc_time") long am_loc_time,
                                           @Query("count") int count, @Query("min_time") long min_time,
                                           @Query("double_col_mode") int double_col_mode);


    @GET("neihan/comments/")
    Observable<JokeCommentResult> getJokeComment(@Query("essence") int essence, @Query("ac") String ac, @Query("channel") String channel,
                                                 @Query("app_name") String app_name, @Query("version_code") int version_code,
                                                 @Query("version_name") String version_name, @Query("device_platform") String device_platform,
                                                 @Query("device_type") String device_type, @Query("device_brand") String device_brand,
                                                 @Query("os_api") int os_api, @Query("os_version") String os_version,
                                                 @Query("group_id") long group_id, @Query("item_id") long item_id, @Query("count") int count,
                                                 @Query("offset") int offset, @Query("enable_image_comment") int enable_image_comment);
}
