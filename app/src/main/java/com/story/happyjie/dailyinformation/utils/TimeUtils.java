package com.story.happyjie.dailyinformation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by llj on 2017/12/15.
 */

public class TimeUtils {
    private static final String FORMAT_DATE = "yyyy-MM-dd";
    private static final String FORMAT_DATE_TIME = "yyyy-MM-dd hh:mm";

    private static SimpleDateFormat sdf1 = new SimpleDateFormat(FORMAT_DATE);
    private static SimpleDateFormat sdf2 = new SimpleDateFormat(FORMAT_DATE_TIME);

    public static String format(long millions){
       return sdf1.format(new Date(millions));
    }
}
