package com.menglingpeng.weeklyweather.utils;

import android.content.Context;

import com.menglingpeng.weeklyweather.R;

import java.util.Calendar;

/**
 * Created by mengdroid on 2018/1/31.
 */

public class TimeUtils {

    public static String getWeekDay(Context context){
        String week = null;
        Calendar calendar = Calendar.getInstance();
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        switch (weekDay){
            case 0:
                week = context.getString(R.string.sunday);
                break;
            case 1:
                week = context.getString(R.string.monday);
                break;
            case 2:
                week = context.getString(R.string.tuesday);
                break;
            case 3:
                week = context.getString(R.string.wednesday);
                break;
            case 4:
                week = context.getString(R.string.thursday);
                break;
            case 5:
                week = context.getString(R.string.friday);
                break;
            case 6:
                week = context.getString(R.string.saturday);
                break;
            default:
                break;
        }
        return week;
    }

    public static String getMonthDay(){
        String monthDay;
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        monthDay = new StringBuilder().append(String.valueOf(month)).append("/").append(String.valueOf(day)).toString();
        return monthDay;
    }

    public static String getCurrentTime(Context context){
        String currentTime = null;
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if(hour < 8){
            currentTime = context.getString(R.string.morning);
        }else if(hour > 8 && hour < 18){
            currentTime = context.getString(R.string.today);
        }else {
            currentTime = context.getString(R.string.night);
        }
        return currentTime;
    }
}
