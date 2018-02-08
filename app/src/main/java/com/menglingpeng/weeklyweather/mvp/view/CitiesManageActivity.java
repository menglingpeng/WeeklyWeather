package com.menglingpeng.weeklyweather.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.menglingpeng.weeklyweather.BaseActivity;
import com.menglingpeng.weeklyweather.MainActivity;
import com.menglingpeng.weeklyweather.R;
import com.menglingpeng.weeklyweather.mvp.adapter.RecyclerAdapter;
import com.menglingpeng.weeklyweather.mvp.bean.DailyWeather;
import com.menglingpeng.weeklyweather.mvp.interf.OnRecyclerItemListener;
import com.menglingpeng.weeklyweather.utils.Constants;
import com.menglingpeng.weeklyweather.utils.SPUtils;

import java.util.ArrayList;

public class CitiesManageActivity extends BaseActivity implements OnRecyclerItemListener{

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Context context;
    private ArrayList<String> cities;
    private ArrayList<DailyWeather> dailyWeathers;

    @Override
    protected void initLayoutId() {
        layoutId = R.layout.activity_cities_manage;
    }

    @Override
    protected void initViews() {
        super.initViews();
        toolbar = (Toolbar)findViewById(R.id.cities_manage_tb);
        recyclerView = (RecyclerView)findViewById(R.id.cities_manage_rv);
        cities = new ArrayList<>();
        dailyWeathers = new ArrayList<>();
        toolbar.setTitle(R.string.cities_manage_tb_title);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        cities = SPUtils.getArray(context, cities);
        adapter = new RecyclerAdapter(context, dailyWeathers, Constants.LIST_ADDED_CITIES, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cities_manage_overflow_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.cities_manage_editor:
                break;
            case R.id.cities_manage_add:
                AddCityDialogFragment dialogFragment = new AddCityDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), Constants.ADD_CITY_DIALOG_FRAGMENT_TAG);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public <T> void onRecyclerListListener(RecyclerView.ViewHolder viewHolder, T t) {
        String position = (String)t;
        SPUtils.putData(context, Constants.CURRENT_CITY_POSITION, position);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Constants.CURRENT_CITY_POSITION, position);
        startActivity(intent);
    }
}
