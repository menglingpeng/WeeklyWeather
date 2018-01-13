package com.menglingpeng.weeklyweather.mvp.model;

import com.menglingpeng.weeklyweather.mvp.interf.OnLoadJsonListener;
import com.menglingpeng.weeklyweather.mvp.interf.WeatherModelIf;
import com.menglingpeng.weeklyweather.mvp.interf.WeatherPresenterIf;

import java.util.HashMap;

/**
 * Created by mengdroid on 2018/1/13.
 */

public class WeatherModel implements WeatherModelIf {

    @Override
    public void getJson(String type, HashMap<String, String> map, OnLoadJsonListener listener) {
        
    }
}
