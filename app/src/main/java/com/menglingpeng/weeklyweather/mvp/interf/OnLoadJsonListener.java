package com.menglingpeng.weeklyweather.mvp.interf;

/**
 * Created by mengdroid on 2018/1/13.
 */

public interface OnLoadJsonListener {
    void OnSuccess(String json);
    void OnFailure(String msg);
}
