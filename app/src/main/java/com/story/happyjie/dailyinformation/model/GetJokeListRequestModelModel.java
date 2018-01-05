package com.story.happyjie.dailyinformation.model;

import android.content.Context;

import com.story.happyjie.dailyinformation.api.ApiService;
import com.story.happyjie.dailyinformation.bean.JokeListResult;
import com.story.happyjie.dailyinformation.http.HttpUtils;
import com.story.happyjie.dailyinformation.http.RequestCallBack;
import com.story.happyjie.dailyinformation.model.base.BaseJokeRequestModel;

/**
 * Created by llj on 2018/1/3.
 */

public class GetJokeListRequestModelModel extends BaseJokeRequestModel {
    private int webp = 1;
    private int contentType;
    private int message_cursor = -1;
    private String am_latitude = "";
    private String am_longitude = "";
    private String am_city = "广州市";
    private long am_loc_time;
    private int count = 20;
    private long min_time; // 上次更新时间的 Unix 时间戳，秒为单位
//    private int screen_width
    private int double_col_mode = 0;
    private int aid = 7;
    private String ssmix = "a";

    private String url;     //自己另外添加，用于动态配置请求路径

    public GetJokeListRequestModelModel(Context context, int contentType, String url, long min_time) {
        super(context);
        this.contentType = contentType;
        this.am_loc_time = System.currentTimeMillis();
        this.min_time = min_time;
        if(url.startsWith(HttpUtils.API_JOKE)){
            if(url.contains("?")){
                url = url.substring(HttpUtils.API_JOKE.length(), url.indexOf("?"));
            } else {
                url = url.substring(HttpUtils.API_JOKE.length());
            }
        }
        this.url = url;
    }

    public void getData(RequestCallBack<JokeListResult> callBack){

        request(ApiService.jokeApiService.getJokeList(url, essence, ac, channel, app_name, version_code,
                version_name, device_platform, device_type, device_brand, os_api, os_version, webp, contentType,
                message_cursor, am_longitude, am_latitude, am_city, am_loc_time, count, min_time, double_col_mode), callBack);
    }

    //- `webp`：固定值 `1`
//- `essence`：固定值 `1`
//- `content_type`：从[获取 content_type](#get) 中获取得到的 `list_id` 字段值。目前[推荐](#recommend)的是`-101`，[视频](#video)的是`-104`，[段友秀](#video_show)的是`-301`，[图片](#picture)的是`-103`，[段子](#joke)的是`-102`
//- `message_cursor`：固定值`-1`
//- `am_longitude`：经度。可为空
//- `am_latitude`：纬度。可为空
//- `am_city`：城市名，例如：`北京市`。可为空
//- `am_loc_time`：当前时间 Unix 时间戳，毫秒为单位
//- `count`：返回数量
//- `min_time`：上次更新时间的 Unix 时间戳，秒为单位
//- `screen_width`：屏幕宽度，px为单位
//- `double_col_mode`：固定值`0`
//- `iid`：???，一个长度为10的纯数字字符串，用于标识用户唯一性
//- `device_id`：设备 id，一个长度为11的纯数字字符串
//- `ac`：网络环境，可取值 `wifi`
//- `channel`：下载渠道，可`360`、`tencent`等
//- `aid`：固定值`7`
//- `app_name`：固定值`joke_essay`
//- `version_code`：版本号去除小数点，例如`612`
//- `version_name`：版本号，例如`6.1.2`
//- `device_platform`：设备平台，`android` 或 `ios`
//- `ssmix`：固定值 `a`
//- `device_type`：设备型号，例如 `hongmi`
//- `device_brand`：设备品牌，例如 `xiaomi`
//- `os_api`：操作系统版本，例如`20`
// - `os_version`：操作系统版本号，例如`7.1.0`
//- `uuid`：用户 id，一个长度为15的纯数字字符串
//- `openudid`：一个长度为16的数字和小写字母混合字符串
//- `manifest_version_code`：版本号去除小数点，例如`612`
//- `resolution`：屏幕宽高，例如 `1920*1080`
//- `dpi`：手机 dpi
//- `update_version_code`：版本号去除小数点后乘10，例如`6120`
}
