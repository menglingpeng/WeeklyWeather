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
import com.menglingpeng.weeklyweather.mvp.bean.WeatherCollection;
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
    private ArrayList<WeatherCollection.HeWeather6Bean.DailyForecastBean> dailyWeathers;
    private String currentType;

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
        initToolbarNav();
        cities = SPUtils.getArray(context, cities);
        adapter = new RecyclerAdapter(context, dailyWeathers, Constants.LIST_ADDED_CITIES, this);
        recyclerView.setAdapter(adapter);
    }

    private void initToolbarNav(){
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
        getMenuInflater().inflate(R.menu.cities_manage_overflow_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.cities_manage_editor:
                currentType = Constants.TYPE_EDITOR;
                invalidateOptionsMenu();
                break;
            case R.id.cities_manage_add:
                currentType = Constants.TYPE_NORMAL;
                invalidateOptionsMenu();
                initToolbarNav();
                AddCityDialogFragment dialogFragment = new AddCityDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), Constants.ADD_CITY_DIALOG_FRAGMENT_TAG);
                break;
            case R.id.cities_manage_editor_check:
            break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 动态更新Toolbar，在需要更新的地方调用invalidateOptionsMenu()。
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(currentType.equals(Constants.TYPE_NORMAL)){
            menu.findItem(R.id.cities_manage_editor).setVisible(false);
            menu.findItem(R.id.cities_manage_add).setVisible(false);
            menu.findItem(R.id.cities_manage_editor_check).setVisible(true);
        }else {
            menu.findItem(R.id.cities_manage_editor).setVisible(true);
            menu.findItem(R.id.cities_manage_add).setVisible(true);
            menu.findItem(R.id.cities_manage_editor_check).setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
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
