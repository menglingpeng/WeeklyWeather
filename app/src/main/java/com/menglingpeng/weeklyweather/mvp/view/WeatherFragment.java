package com.menglingpeng.weeklyweather.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.ImageView;
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
    private TextView todayTv;
    private TextView todayTemperatureTv;
    private Button todayAirQualityBt;
    private TextView todayWeatherTv;
    private ImageView todayWeatherIv;
    private TextView tomTemperatureTv;
    private Button tomAirQualityBt;
    private TextView tomWeatherTv;
    private ImageView tomWeatherIv;

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
        todayTv = (TextView)rootView.findViewById(R.id.today_tv);
        //今天、明天天气
        todayAirQualityBt = (Button)rootView.findViewById(R.id.today_air_quality_bt);
        todayTemperatureTv = (TextView) rootView.findViewById(R.id.today_high_low_temperture_tv);
        todayWeatherTv = (TextView)rootView.findViewById(R.id.today_weather_tv);
        todayWeatherIv = (ImageView)rootView.findViewById(R.id.toady_weather_iv);
        tomAirQualityBt = (Button)rootView.findViewById(R.id.tom_air_quality_bt);
        tomTemperatureTv = (TextView) rootView.findViewById(R.id.tom_high_low_temperture_tv);
        tomWeatherTv = (TextView)rootView.findViewById(R.id.tom_weather_tv);
        tomWeatherIv = (ImageView)rootView.findViewById(R.id.tom_weather_iv);

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
