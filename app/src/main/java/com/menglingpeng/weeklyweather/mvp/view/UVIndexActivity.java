package com.menglingpeng.weeklyweather.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.menglingpeng.weeklyweather.BaseActivity;
import com.menglingpeng.weeklyweather.R;

public class UVIndexActivity extends BaseActivity {

    private Toolbar toolbar;

    @Override
    protected void initLayoutId() {
        layoutId = R.layout.activity_uv_index;
    }

    @Override
    protected void initViews() {
        super.initViews();
        toolbar = (Toolbar)findViewById(R.id.uv_index_tb);
        toolbar.setTitle(R.string.uv_index);
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
        getMenuInflater().inflate(R.menu.acticity_index_toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
