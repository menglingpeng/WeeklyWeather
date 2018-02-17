package com.menglingpeng.weeklyweather.mvp.view;

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
import com.menglingpeng.weeklyweather.utils.Constants;

import java.util.ArrayList;

public class ExerciseIndexActivity extends BaseActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<String> titles;
    private ArrayList<IndexFragment> fragments;
    private TabPagerFragmentAdapter adapter;

    @Override
    protected void initLayoutId() {
        layoutId = R.layout.activity_exercise_index;
    }

    @Override
    protected void initViews() {
        super.initViews();
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
        initTabView();
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

    private void initTabView(){
        titles = new ArrayList<>();
        fragments = new ArrayList<>();
        titles.add(getString(R.string.today));
        titles.add(getString(R.string.tomorrow));
        titles.add(getString(R.string.day_after_tomorrow));
        adapter = new TabPagerFragmentAdapter(getSupportFragmentManager());
        adapter.setFragments(fragments, titles, Constants.TAB_VIEW_TYPE_INDEX);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
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
}
