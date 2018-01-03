package com.story.happyjie.dailyinformation.cache;


import android.content.Context;

import com.story.happyjie.dailyinformation.bean.JokeContentTypeResult;
import com.story.happyjie.dailyinformation.bean.NewsDataResult;

import java.util.List;

public class UserCacheWrapper {

    public static final String CACHE_TYPE_NEWS = "News";
    public static final String CACHE_JOKE_CONTENT_TYPE = "JOKE_CONTENT_TYPE";

    /**
     * 生产存储key
     * @param type
     * @param params
     * @return
     */
    private static String generateKey(String type, String... params){
        StringBuffer buf = new StringBuffer(type);
        for(String param : params){
            buf.append("_" + param);
        }
        return buf.toString();
    }

    /**
     * 保存新闻缓存
     * @param context
     * @param classifications
     * @param result
     */
    public static void saveNewsCache(Context context, String[] classifications, NewsDataResult result){
        ACache.get(context).put(generateKey(CACHE_TYPE_NEWS, classifications) , result);
    }

    /**
     * 读取新闻缓存
     * @param context
     * @param classifications
     * @return
     */
    public static List<NewsDataResult.DataBean> getNewsCache(Context context, String[] classifications){
        NewsDataResult result = (NewsDataResult) ACache.get(context).getAsObject(generateKey(CACHE_TYPE_NEWS, classifications));
        return null == result ? null : result.getData();
    }

    /**
     * 保存内涵段子分类contentType
     * @param context
     * @param result
     */
    public static void saveJokeContentType(Context context, JokeContentTypeResult result){
        ACache.get(context).put(CACHE_JOKE_CONTENT_TYPE, result);
    }

    /**
     * 读取内涵段子分类contentType
     * @param context
     * @return
     */
    public static JokeContentTypeResult getJokeContentType(Context context){
        JokeContentTypeResult result = (JokeContentTypeResult) ACache.get(context).getAsObject(CACHE_JOKE_CONTENT_TYPE);
        return result;
    }


}
