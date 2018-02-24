package com.menglingpeng.weeklyweather.mvp.view;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.menglingpeng.weeklyweather.BaseActivity;
import com.menglingpeng.weeklyweather.R;
import com.menglingpeng.weeklyweather.mvp.adapter.TabPagerFragmentAdapter;
import com.menglingpeng.weeklyweather.mvp.bean.WeatherCollection;
import com.menglingpeng.weeklyweather.utils.Constants;
import com.menglingpeng.weeklyweather.utils.IndexActivityUtils;

import java.util.ArrayList;

public class ExerciseIndexActivity extends BaseActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<String> titles;
    private ArrayList<IndexFragment> fragments;
    private TabPagerFragmentAdapter adapter;
    private Context context;
    private WeatherCollection weatherCollection;

    @Override
    protected void initLayoutId() {
        layoutId = R.layout.activity_exercise_index;
    }

    @Override
    protected void initViews() {
        super.initViews();
        context = getApplicationContext();
        weatherCollection = (WeatherCollection) getIntent().getSerializableExtra(Constants.WEATHER_COLLECTION);
        toolbar = (Toolbar)findViewById(R.id.cold_index_tb);
        tabLayout = (TabLayout)findViewById(R.id.cold_index_tl);
        viewPager = (ViewPager)findViewById(R.id.cold_index_vp);
        titles = new ArrayList<>();
        fragments = new ArrayList<>();
        toolbar.setTitle(R.string.cold_index);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        adapter = new TabPagerFragmentAdapter(getSupportFragmentManager());
        IndexActivityUtils.initTablayout(context, tabLayout, viewPager, titles, fragments, adapter);
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

}
