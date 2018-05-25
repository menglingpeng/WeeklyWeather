package com.menglingpeng.weeklyweather.mvp.view;

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
import com.menglingpeng.weeklyweather.R;
import com.menglingpeng.weeklyweather.utils.CustomMarkerView;

public class AirQualityDetailActivity extends BaseActivity {

    private Toolbar toolbar;
    private TextView releaseTimeTv;
    private BarChart kindBc;
    private RecyclerView recyclerView;
    private LineChart valueLc;
    private BarChart valueBc;

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
    }
}
