package com.menglingpeng.weeklyweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    protected int layoutId = R.layout.activity_base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initLayoutId();
        super.onCreate(savedInstanceState);
        initViews();
    }

    protected abstract void initLayoutId();

    protected void initViews() {
        setContentView(layoutId);
    }
}
