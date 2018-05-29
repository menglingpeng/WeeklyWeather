package com.menglingpeng.weeklyweather.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
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
import com.menglingpeng.weeklyweather.utils.weixin.OnWXResponseListener;
import com.menglingpeng.weeklyweather.utils.weixin.WXShare;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

import java.util.ArrayList;

public class FluIndexActivity extends BaseActivity implements IWXAPIEventHandler {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<String> titles;
    private ArrayList<IndexFragment> fragments;
    private TabPagerFragmentAdapter adapter;
    private Context context;
    private WeatherCollection weatherCollection;
    private IWXAPI iwxapi;
    private WXShare wxShare;


    @Override
    protected void initLayoutId() {
        layoutId = R.layout.activity_flu_index;
    }

    @Override
    protected void initViews() {
        super.initViews();
        context = getApplicationContext();
        weatherCollection = (WeatherCollection) getIntent().getSerializableExtra(Constants.WEATHER_COLLECTION);
        toolbar = (Toolbar)findViewById(R.id.flu_index_tb);
        tabLayout = (TabLayout)findViewById(R.id.flu_index_tl);
        viewPager = (ViewPager)findViewById(R.id.flu_index_vp);
        titles = new ArrayList<>();
        fragments = new ArrayList<>();
        toolbar.setTitle(R.string.flu_index);
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
        getMenuInflater().inflate(R.menu.activity_index_toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.index_share);{
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

    @Override
    protected void onStart() {
        super.onStart();
        wxShare.register();
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
}
