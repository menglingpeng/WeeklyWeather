package com.menglingpeng.weeklyweather.mvp.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.menglingpeng.weeklyweather.BaseActivity;
import com.menglingpeng.weeklyweather.R;
import com.menglingpeng.weeklyweather.utils.Constants;

public class WeatherDetailActivity extends BaseActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int currentItemId;
    private String currentCity;
    @Override
    protected void initLayoutId() {
        layoutId = R.layout.activity_weather_detail;
    }

    @Override
    protected void initViews() {
        super.initViews();
        currentItemId = Integer.valueOf(getIntent().getStringExtra(Constants.CURRENT_DAY_POSITION));
        toolbar = (Toolbar)findViewById(R.id.detail_tb);
        toolbar.setTitle(currentCity);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
