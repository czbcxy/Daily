package com.ledong.platform.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间日期差值计算
 * @title 
 * @author chengzhegnbo
 *
 */
public class DateFormatUtils {

    /*
    获取时间差
     */
    public static String getTimesToNow(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(new Date());
        String dateStr = format.format(date);
        String returnText = null;
        try {
            long from = format.parse(dateStr).getTime();
            long to = format.parse(now).getTime();
            int days = (int) ((to - from)/(1000 * 60 * 60 * 24));
            if(days == 0){//一天以内，以分钟或者小时显示
                int hours = (int) ((to - from)/(1000 * 60 * 60));
                if(hours == 0){
                    int minutes = (int) ((to - from)/(1000 * 60));
                    if(minutes == 0){
                        returnText = "刚刚";
                    }else{
                        returnText = minutes + "分钟前";
                    }
                }else{
                    returnText = hours + "小时前";
                }
            } else if(days >= 1 && days< 365){
            	returnText = days + "天前";
            }else{
                returnText = days/365 + "年前";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return returnText;
    }
}
