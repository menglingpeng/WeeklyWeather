package com.menglingpeng.weeklyweather.mvp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.menglingpeng.weeklyweather.BaseActivity;
import com.menglingpeng.weeklyweather.utils.CustomMarkerView;
import com.menglingpeng.weeklyweather.utils.weixin.OnWXResponseListener;
import com.menglingpeng.weeklyweather.utils.weixin.WXShare;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class AirQualityDetailActivity extends BaseActivity implements IWXAPIEventHandler{

    private Toolbar toolbar;
    private TextView releaseTimeTv;
    private BarChart kindBc;
    private RecyclerView recyclerView;
    private LineChart valueLc;
    private BarChart valueBc;

    private IWXAPI iwxapi;
    private WXShare wxShare;
    private TextView shareText;
    private Ima

    @Override
    protected void initLayoutId() {
        layoutId = R.layout.activity_air_quality_detail;
    }

    @Override
    protected void initViews() {
        super.initViews();
        toolbar = (Toolbar)findViewById(R.id.air_quality_detail_tb);
        releaseTimeTv = (TextView)findViewById(R.id.air_quality_detail_release_time_tv);
        kindBc = (BarChart)findViewById(R.id.air_quality_detail_kind_bc);
        recyclerView = (RecyclerView)findViewById(R.id.air_quality_detail_forecast_vaule_rv);
        valueLc = (LineChart)findViewById(R.id.air_quality_detail_forecast_lc) ;
        valueBc = (BarChart)findViewById(R.id.air_quality_detail_forecast_bc) ;
        toolbar.setTitle(R.string.);
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
        getMenuInflater().inflate(R.menu.activity_short_rainfall_warning_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.short_rainfall_warning_share){
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
