package com.menglingpeng.weeklyweather.mvp.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.menglingpeng.weeklyweather.BaseFragment;
import com.menglingpeng.weeklyweather.R;
import com.menglingpeng.weeklyweather.utils.Constants;

/**
 * Created by mengdroid on 2018/1/30.
 */

public class WeatherDetailFragment extends BaseFragment {

    private ImageView weatherIv;
    private TextView weatherTv;
    private TextView temperatureValueTv;
    private TextView windValueTv;
    private TextView airQualityValueTv;


    public static WeatherDetailFragment newInstance(String type){
        Bundle bundle = new Bundle();
        bundle.putString(Constants.TYPE, type);
        WeatherDetailFragment fragment = new WeatherDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initLayoutId() {
        layoutId = R.layout.fragment_weather_detail;
    }

    @Override
    protected void initView() {
        weatherIv = (ImageView)rootView.findViewById(R.id.fragment_weather_detail_weather_iv);
        weatherTv = (TextView)rootView.findViewById(R.id.fragment_weather_detail_weather_tv);
        temperatureValueTv = (TextView)rootView.findViewById(R.id.fragment_weather_detail_temperature_value_tv);
        windValueTv = (TextView)rootView.findViewById(R.id.fragment_weather_detail_wind_value_tv);
        airQualityValueTv = (TextView)rootView.findViewById(R.id.fragment_weather_detail_air_quality_value_tv);
    }

    @Override
    protected void initData() {

    }
}
