package com.menglingpeng.weeklyweather.mvp.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import com.menglingpeng.weeklyweather.BaseActivity;
import com.menglingpeng.weeklyweather.R;
import com.menglingpeng.weeklyweather.utils.weixin.OnWXResponseListener;
import com.menglingpeng.weeklyweather.utils.weixin.WXShare;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class CalendarActivity extends BaseActivity implements IWXAPIEventHandler {

    private Toolbar toolbar;
    private TextView holidayTv;
    private TextView titleTv;
    private CalendarView calendarView;
    private IWXAPI iwxapi;
    private WXShare wxShare;

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
