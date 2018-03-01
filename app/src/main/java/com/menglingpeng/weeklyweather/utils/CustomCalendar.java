package com.menglingpeng.weeklyweather.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import java.util.HashMap;

/**
 * Created by mengdroid on 2018/2/28.
 */

public class CustomCalendar extends View {

    /** 各部分背景*/
    private int mBgMonth;
    private int mBgWeek;
    private int mBgDay;
    private int mBgPre;

    /** 标题的颜色、大小*/
    private int textColorMonth;
    private float textSizeMonth;
    private int monthRowL;
    private int mMonthRowR;
    private float monthRowSpac;
    private float monthSpac;

    private Date month;
    private Boolean isCurrentMonth;
    private int selectDay;

    /** 字体上下间距*/
    private float mTextSpac;
    private Paint paint;
    private Paint bgPaint;
    private float titleHeight;
    private float weekHeight;
    private float dayHeight;
    private float preHeight;
    private float oneHeight;
    private float mMonthSpac;

    /** 行间距*/
    private float lineSpac;
    /** 字体上下间距*/
    private float textSpac;

    /** 标题的颜色、大小*/
    private int textColorMonth;
    private float textSizeMonth;
    private int monthRowL, monthRowR;
    private float monthRowSpac;
    private float monthSpac;

    /** 星期的颜色、大小*/
    private int textColorWeek;
    private int selectWeekTextColor;
    private float textSizeWeek;
    /** 日期文本的颜色、大小*/
    private int textColorDay;
    private float textSizeDay;

    private int  currentDay;
    private int todayWeekIndex;
    private int firstIndex;
    private int lineNum;
    private int firstLineNum;
    private int lastLineNum;
    private int dayOfMonth;

    private HashMap map;

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
        initData();
    }

    /**计算相关常量，构造方法中调用*/
    private void initData(){
        paint = new Paint();
        bgPaint = new Paint();
        paint.setAntiAlias(true); //抗锯齿
        bgPaint.setAntiAlias(true); //抗锯齿

        map = new HashMap<>();

        //标题高度
        paint.setTextSize(textSizeMonth);
        titleHeight = FontUtils.getFontHeight(paint) + 2 * mMonthSpac;
        //星期高度
        paint.setTextSize(textSizeWeek);
        weekHeight = FontUtils.getFontHeight(paint);
        //日期高度
        paint.setTextSize(textSizeDay);
        dayHeight = FontUtils.getFontHeight(paint);
        //每行高度 = 行间距 + 日期字体高度 + 字间距 + 次数字体高度
        oneHeight = lineSpac + dayHeight + mTextSpac + preHeight;

        //默认当前月份
        String cDateStr = getMonthStr(new Date());
        setMonth(cDateStr);
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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


}
