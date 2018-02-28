package com.menglingpeng.weeklyweather.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.menglingpeng.weeklyweather.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by mengdroid on 2018/2/28.
 */

public class CustomCalendar extends View {

    /** 各部分背景*/
    private int mBgMonth;
    private int mBgWeek;
    private int mBgDay;
    private int mBgPre;
    private Date month;
    private Boolean isCurrentMonth;
    private int selectDay;
    /** 字体上下间距*/
    private float mTextSpac;
    private Paint mPaint;
    private Paint bgPaint;
    private float titleHeight;
    private float weekHeight;
    private float dayHeight;
    private float preHeight;
    private float oneHeight;
    private int  currentDay;
    private int todayWeekIndex;
    private int firstIndex;
    private int lineNum;
    private int firstLineNum;
    private int lastLineNum;
    private int dayOfMonth;

    public CustomCalendar(Context context, AttributeSet attrs, int i) {
        super(context);
    }

    public CustomCalendar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomCalendar(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        //获取自定义属性的值
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomCalendar, defStyleAttr,
                0);
        mBgMonth = array.getColor(R.styleable.CustomCalendar_mBgMonth, Color.TRANSPARENT);
        mBgWeek = array.getColor(R.styleable.CustomCalendar_mBgWeek, Color.TRANSPARENT);
        mBgDay = array.getColor(R.styleable.CustomCalendar_mBgDay, Color.TRANSPARENT);
        mBgPre = array.getColor(R.styleable.CustomCalendar_mBgPre, Color.TRANSPARENT);
    }

    //设置月份
    private void setMonth(String monthStr){
        int  currentDay;
        int todayWeekIndex;
        int firstIndex;
        int lineNum;
        int firstLineNum;
        int lastLineNum;
        int dayOfMonth;
        Date date = strToDate(getMonthStr(new Date()));
        month = strToDate(monthStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        //获取今天日期
        currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        todayWeekIndex = calendar.get(Calendar.DAY_OF_WEEK)-1;
        //判断是否为当月
        if(date.getTime() == month.getTime()){
            isCurrentMonth = true;
            selectDay = currentDay;//当月默认选中当前日
        }else{
            isCurrentMonth = false;
            selectDay = 0;
        }
        //第一行1号显示在什么位置（星期几）
        firstIndex = calendar.get(Calendar.DAY_OF_WEEK)-1;
        lineNum = 1;
        dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        //第一行能展示的天数
        firstLineNum = 7-firstIndex;
        lastLineNum = 0;
        int shengyu = dayOfMonth - firstLineNum;
        while (shengyu>7){
            lineNum ++;
            shengyu-=7;
        }
        if(shengyu>0){
            lineNum ++;
            lastLineNum = shengyu;
        }
    }

    //获取月份标题
    private String getMonthStr(Date month){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月");
        return dateFormat.format(month);
    }

    private Date strToDate(String str){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月");
        try {
            return dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


}
