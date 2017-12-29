package com.story.happyjie.dailyinformation.cache;


import android.content.Context;

import com.story.happyjie.dailyinformation.bean.NewsDataResult;

import java.util.List;

public class UserCacheWrapper {

    public static final String CACHE_TYPE_NEWS = "News";

    private static String generateKey(String type, String... params){
        StringBuffer buf = new StringBuffer(type);
        for(String param : params){
            buf.append("_" + param);
        }
        return buf.toString();
    }

    public static void saveNewsCache(Context context, String[] classifications, NewsDataResult result){
        ACache.get(context).put(generateKey(CACHE_TYPE_NEWS, classifications) , result);
    }

    public static List<NewsDataResult.DataBean> getNewsCache(Context context, String[] classifications){
        NewsDataResult result = (NewsDataResult) ACache.get(context).getAsObject(generateKey(CACHE_TYPE_NEWS, classifications));
        return null == result ? null : result.getData();
    }
}
