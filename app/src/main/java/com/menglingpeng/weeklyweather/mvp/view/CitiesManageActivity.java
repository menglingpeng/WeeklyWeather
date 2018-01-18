package com.menglingpeng.weeklyweather.mvp.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.menglingpeng.weeklyweather.BaseActivity;
import com.menglingpeng.weeklyweather.R;

public class CitiesManageActivity extends BaseActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    @Override
    protected void initLayoutId() {
        layoutId = R.layout.activity_cities_manage;
    }

    @Override
    protected void initViews() {
        super.initViews();
        toolbar = (Toolbar)findViewById(R.id.cities_manage_tb);
        recyclerView = (RecyclerView)findViewById(R.id.cities_manage_rv);
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
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
