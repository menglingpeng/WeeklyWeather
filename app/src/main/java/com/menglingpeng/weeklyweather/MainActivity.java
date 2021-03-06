package com.menglingpeng.weeklyweather;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.ImageWriter;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.menglingpeng.weeklyweather.mvp.adapter.TabPagerFragmentAdapter;
import com.menglingpeng.weeklyweather.mvp.view.WeatherFragment;
import com.menglingpeng.weeklyweather.utils.Constants;
import com.menglingpeng.weeklyweather.utils.LocationService;
import com.menglingpeng.weeklyweather.utils.SPUtils;
import com.menglingpeng.weeklyweather.utils.ShareUtils;
import com.menglingpeng.weeklyweather.utils.weixin.OnWXResponseListener;
import com.menglingpeng.weeklyweather.utils.weixin.WXShare;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener,
        IWXAPIEventHandler{

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private RelativeLayout updateRl;
    private ProgressBar updatePb;
    private TextView updateTv;
    private NavigationView navigationView;
    private ImageView navHeaderBackgroudIv;
    private RelativeLayout navHeaderRl;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Context context;
    private ArrayList<String> cities;
    private ArrayList<WeatherFragment> fragments;
    private TabPagerFragmentAdapter adapter;
    private AlertDialog dialog;
    private String location = null;

    private IWXAPI iwxapi;
    private WXShare wxShare;


    @Override
    protected void initLayoutId() {
        layoutId = R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        super.initViews();
        context = getApplicationContext();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions( new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.
                        ACCESS_COARSE_LOCATION}, Constants.REQUEST_LOCATION_PERMISSION_CODE);
            }
        }
        if(SPUtils.getState(context, Constants.IS_FIRST_STRAT_APP)){
            showGetLocationDialog();
            //注册广播
            IntentFilter filter = new IntentFilter();
            filter.addAction(Constants.LOCATION_ACTION);
            this.registerReceiver(new LocationBroadcastReceiver(), filter);
            //启动服务
            Intent intent = new Intent(this, LocationService.class);
            startService(intent);
            SPUtils.saveState(context, Constants.IS_FIRST_STRAT_APP, true);
        }else {
            initView();
        }
    }

    private void initView(){
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        toolbar = (Toolbar)findViewById(R.id.main_tb);
        updateRl = (RelativeLayout)findViewById(R.id.main_update_rl);
        updatePb = (ProgressBar)findViewById(R.id.main_update_pb);
        updatetv = (TextView)findViewById(R.id.main_update_tv);
        navigationView = (NavigationView)findViewById(R.id.nav_view);
        tabLayout = (TabLayout)findViewById(R.id.main_tl);
        viewPager = (ViewPager)findViewById(R.id.main_vp);

        cities = new ArrayList<>();
        toolbar.setTitle(location);
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

    @Override
    protected void onStart() {
        super.onStart();
        update();
        wxShare.register();
    }

    private void update(){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_acitivity_toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.main_share){
            String text = null;
            wxShare = new WXShare(this);
            wxShare.setListener(new OnWXResponseListener() {
                @Override
                public void onSuccess() {

                }
                @Override
                public void onCancel() {

                }
                @Override
                public void onFail(String message) {

                }
            });
            iwxapi = wxShare.getApi();
            // 第三方开发者如果使用透明界面来实现WXEntryActivity，
            // 需要判断handleIntent的返回值，如果返回值为false，
            // 则说明入参不合法未被SDK处理，应finish当前透明界面，避
            // 免外部通过传递非法参数的Intent导致停留在透明界面，
            // 引起用户的疑惑
            try {
                if (!iwxapi.handleIntent(getIntent(), this)) {
                    finish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return super.onOptionsItemSelected(item);
    }

    private void showGetLocationDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_get_location, null);
        builder.setView(view);
        dialog = builder.create();
        dialog.show();
    }

    private void initTabAndViewPager(){
        tabLayout.setVisibility(TabLayout.VISIBLE);
        viewPager.setVisibility(ViewPager.VISIBLE);
        fragments = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++){
            fragments.add(WeatherFragment.newInstance(cities.get(i)));
        }
        adapter = new TabPagerFragmentAdapter(getSupportFragmentManager());
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



    @Override
    protected void onDestroy() {
        wxShare.unregister();
        super.onDestroy();
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        Intent intent = new Intent(WXShare.ACTION_SHARE_RESPONSE);
        intent.putExtra(WXShare.EXTRA_RESULT, new WXShare.Response(baseResp));
        sendBroadcast(intent); finish();
    }

    private class LocationBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Constants.LOCATION_ACTION)){
                dialog.dismiss();
                location = intent.getStringExtra(Constants.LOCATION);
                initView();
            }
        }
    }

}
