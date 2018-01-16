package com.menglingpeng.weeklyweather.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.menglingpeng.weeklyweather.BaseFragment;
import com.menglingpeng.weeklyweather.R;
import com.menglingpeng.weeklyweather.utils.Constants;

/**
 * Created by mengdroid on 2018/1/15.
 */

public class WeatherFragment extends BaseFragment {

    private String type;
    private Context context;
    private TextView currentTemperatureTv;
    private TextView currentWeatherTypeTv;
    private TextView highWithLowTemperatureTv;
    private TextView currentWindTv;
    private TextView currentHumidityTv;
    private RelativeLayout airQualityRl;
    private TextView airQualityTv;
    private TextView airQualityValueTv;

    public static WeatherFragment newInstance(String type){
        Bundle bundle = new Bundle();
        bundle.putString(Constants.TYPE, type);
        WeatherFragment fragment = new WeatherFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initLayoutId() {
        layoutId = R.layout.fragment_weather;
        context = getActivity().getApplicationContext();
        type = getArguments().getString(Constants.TYPE).toString();
    }

    @Override
    protected void initView() {
        currentTemperatureTv = (TextView)rootView.findViewById(R.id.current_temperature_tv);
        currentWeatherTypeTv = (TextView)rootView.findViewById(R.id.current_weather_type_tv);
        highWithLowTemperatureTv = (TextView)rootView.findViewById(R.id.high_low_temperture_tv);
        currentWindTv = (TextView)rootView.findViewById(R.id.current_wind_tv);
        currentHumidityTv = (TextView)rootView.findViewById(R.id.current_humidity_tv);
        airQualityRl = (RelativeLayout)rootView.findViewById(R.id.air_quality_rl);
        airQualityTv = (TextView)rootView.findViewById(R.id.air_quality_tv);
        airQualityValueTv = (TextView)rootView.findViewById(R.id.air_quality_value_tv);

    }

    @Override
    protected void initData() {

    }

    private void initParameters(){
        switch (type){
            case Constants.CURRENT_CITY_WEATHER:
                break;
            default:
                break;
        }
    }
}
