package com.menglingpeng.weeklyweather.utils.weixin;

/**
 * Created by mengdroid on 2018/5/26.
 */

public interface OnWXResponseListener {
    //分享成功的回调
    void onSuccess();

    //分享取消的回调
    void onCancel();

    //分享失败的回调
    void onFail(String message);
}
