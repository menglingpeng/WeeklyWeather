package com.menglingpeng.weeklyweather.utils;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Button;

import com.menglingpeng.weeklyweather.R;

/**
 * Created by mengdroid on 2018/1/28.
 */

public class AirQualityUtils {

    public static Button getAirQuality(Context context, Button button, int value){
        String text = null;
        int backgroundColor = -1;
        Resources resources = context.getResources();
        if(value <= 50){
            text = context.getString(R.string.optimal_air_text);
            backgroundColor = resources.getColor(R.color.optimal_air_color);
        }else if(value > 50 && value <= 100){
            text = context.getString(R.string.good_air_text);
            backgroundColor = resources.getColor(R.color.good_air_color);
        }else if(value > 100 && value <= 150){
            text = context.getString(R.string.lightly_polluted_air_text);
            backgroundColor = resources.getColor(R.color.lightly_polluted_air_color);
        }else if(value > 150 && value <= 200){
            text = context.getString(R.string.moderately_polluted_air_text);
            backgroundColor = resources.getColor(R.color.moderately_polluted_air_color);
        }else if(value > 200 && value <= 300){
            text = context.getString(R.string.severe_polluted_air_text);
            backgroundColor = resources.getColor(R.color.severe_polluted_air_color);
        }else {
            text = context.getString(R.string.serious_polluted_air_text);
            backgroundColor = resources.getColor(R.color.serious_polluted_air_color);
        }
        button.setText(text);
        button.setBackgroundColor(backgroundColor);
        return  button;
    }
}
