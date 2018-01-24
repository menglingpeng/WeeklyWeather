package com.menglingpeng.weeklyweather;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.menglingpeng.weeklyweather.mvp.model.RetrofitFactory;
import com.menglingpeng.weeklyweather.mvp.view.WeatherFragment;
import com.menglingpeng.weeklyweather.utils.Constants;
import com.menglingpeng.weeklyweather.utils.LocationUtils;
import com.menglingpeng.weeklyweather.utils.RequestPermissionUtil;
import com.menglingpeng.weeklyweather.utils.SPUtils;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ImageView navHeaderBackgroudIv;
    private RelativeLayout navHeaderRl;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Context context;
    private ArrayList<String> cities;
    private ArrayList<WeatherFragment> fragments;

    @Override
    protected void initLayoutId() {
        context = getApplicationContext();
        RequestPermissionUtil.requestPermissions(context, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                Constants.REQUEST_LOCATION_PERMISSION_CODE);
        RequestPermissionUtil.requestPermissions(context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                Constants.REQUEST_LOCATION_PERMISSION_CODE);
        layoutId = R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        super.initViews();
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        toolbar = (Toolbar)findViewById(R.id.main_tb);
        navigationView = (NavigationView)findViewById(R.id.nav_view);
        tabLayout = (TabLayout)findViewById(R.id.main_tl);
        viewPager = (ViewPager)findViewById(R.id.main_vp);
        cities = new ArrayList<>();
        //toolbar.setTitle(LocationUtils.getBestLocation(context));
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        cities = SPUtils.getArray(context, cities);
        initNavigationView();
        if (SPUtils.getState(context, Constants.IS_FIRST_STRAT_APP) || cities.size() == 1){
            replaceFragment(WeatherFragment.newInstance(Constants.CURRENT_CITY_WEATHER));
        }else {
            initTabAndViewPager();
        }
    }

    private void initTabAndViewPager(){
        tabLayout.setVisibility(TabLayout.VISIBLE);
        viewPager.setVisibility(ViewPager.VISIBLE);
        fragments = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++){
            fragments.add(WeatherFragment.newInstance(cities.get(i)));
        }
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

    @SuppressLint("RestrictedApi")
    private void initNavigationView(){
        View headerView = navigationView.getHeaderView(0);
        navHeaderRl = (RelativeLayout)headerView.findViewById(R.id.bav_header_rl);
        navHeaderBackgroudIv = (ImageView)headerView.findViewById(R.id.nav_header_backgroud_iv);
        //设置关闭和打开特效
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_drawer_open ,R.string.nav_drawer_close);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);
        navigationView.inflateMenu(R.menu.nav_content_menu);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            navigationView.setCheckedItem(R.id.nav_home_menu);
        }else {
            navigationView.getMenu().findItem(0).setCheckable(true);
        }
        //修改NavigationView的menu选中的icon和text颜色，默认是跟随主题色
        ColorStateList csl = getResources().getColorStateList(R.color.navigationview_menu_item_color);
        navigationView.setItemIconTintList(csl);
        navigationView.setItemTextColor(csl);
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home_menu:
                break;
            case R.id.nav_share_menu:
                break;
            case R.id.nav_settings_menu:
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}
