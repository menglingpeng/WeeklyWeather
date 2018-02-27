package com.menglingpeng.weeklyweather.mvp.view;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import com.menglingpeng.weeklyweather.BaseActivity;
import com.menglingpeng.weeklyweather.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class CalendarActivity extends BaseActivity {

    private Toolbar toolbar;
    private TextView holidayTv;
    private TextView titleTv;
    private CalendarView calendarView;
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
    @Override
    protected void initLayoutId() {
        layoutId = R.layout.activity_calendar;
    }

    @Override
    protected void initViews() {
        super.initViews();
        toolbar = (Toolbar)findViewById(R.id.car_wash_index_tb);
        holidayTv = (TextView)findViewById(R.id.activity_calendar_holiday_tv);
        titleTv = (TextView)findViewById(R.id.activity_calendar_title_tv);
        calendarView = (CalendarView)findViewById(R.id.activity_calendar_cv);
        toolbar.setTitle(R.string.calendar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int
                    dayOfMonth) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.acticity_index_toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
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
