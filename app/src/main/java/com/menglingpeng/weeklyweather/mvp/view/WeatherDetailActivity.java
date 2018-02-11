package com.menglingpeng.weeklyweather.mvp.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.menglingpeng.weeklyweather.BaseActivity;
import com.menglingpeng.weeklyweather.R;
import com.menglingpeng.weeklyweather.mvp.adapter.WeatherDetailTabPagerAdapter;
import com.menglingpeng.weeklyweather.utils.Constants;

import java.util.ArrayList;

public class WeatherDetailActivity extends BaseActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int currentItemId;
    private String currentCity;
    private WeatherDetailTabPagerAdapter adapter;
    private ArrayList<String> topTitles;
    private ArrayList<String> bottomTitles;
    private ArrayList<WeatherDetailFragment> fragments;

    @Override
    protected void initLayoutId() {
        layoutId = R.layout.activity_weather_detail;
    }

    @Override
    protected void initViews() {
        super.initViews();
        currentItemId = Integer.valueOf(getIntent().getStringExtra(Constants.CURRENT_DAY_POSITION));
        toolbar = (Toolbar)findViewById(R.id.detail_tb);
        topTitles = new ArrayList<>();
        bottomTitles = new ArrayList<>();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_weather_detail_toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    private void initTabAndViewPager(){
        tabLayout = (TabLayout)findViewById(R.id.detail_tl);
        viewPager = (ViewPager)findViewById(R.id.detail_vp);
        adapter = new WeatherDetailTabPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        setTabView();
        viewPager.setCurrentItem(currentItemId);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.getCurrentItem();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setTabView(){
        for (int i = 0; i < topTitles.size(); i++){
            tabLayout.getTabAt(i).setCustomView(getTabView(i));
        }
    }

    private View getTabView(int position){
        View tabView = LayoutInflater.from(this).inflate(R.layout.tablayout_weather_detail_tab_item, null);
        TextView topTitleTv = (TextView)tabView.findViewById(R.id.weather_detail_tl_tab_top_tv);
        TextView bottomTitleTv = (TextView)tabView.findViewById(R.id.weather_detail_tl_tab_bottom_tv);
        topTitleTv.setText(topTitles.get(position));
        bottomTitleTv.setText(bottomTitles.get(position));
        return tabView;
    }
}
