package com.menglingpeng.weeklyweather.utils;

import android.widget.ImageView;

import com.menglingpeng.weeklyweather.R;

/**
 * Created by mengdroid on 2018/2/10.
 */

public class WeatherIconUtils {

    public static void setIcon(ImageView imageView, String code){
        switch (code){
            case Constants.COND_CODE_100:
                imageView.setImageResource(R.drawable.ic_cond_100);
                break;
            default:

        }
    }
}
