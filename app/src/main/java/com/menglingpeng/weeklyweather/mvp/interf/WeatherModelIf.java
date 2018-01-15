package com.menglingpeng.weeklyweather.mvp.interf;

import java.util.HashMap;

/**
 * Created by mengdroid on 2018/1/13.
 */

public interface WeatherModelIf {
    void getJson(String type, HashMap<String, String> map);
}
