package com.menglingpeng.weeklyweather.mvp.presenter;

import com.menglingpeng.weeklyweather.mvp.interf.OnLoadJsonListener;
import com.menglingpeng.weeklyweather.mvp.interf.WeatherPresenterIf;

/**
 * Created by mengdroid on 2018/1/13.
 */

public class WeatherPresenter implements WeatherPresenterIf, OnLoadJsonListener {

    @Override
    public void loadJson() {

    }

    @Override
    public void OnSuccess(String json) {

    }

    @Override
    public void OnFailure(String msg) {

    }
}
