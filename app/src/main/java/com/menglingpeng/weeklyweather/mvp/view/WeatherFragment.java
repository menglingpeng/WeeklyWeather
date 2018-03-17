package com.menglingpeng.weeklyweather.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.menglingpeng.weeklyweather.BaseFragment;
import com.menglingpeng.weeklyweather.R;
import com.menglingpeng.weeklyweather.utils.Constants;
import com.menglingpeng.weeklyweather.utils.TimeUtils;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.CompletableOnSubscribe;

/**
 * Created by mengdroid on 2018/1/15.
 */

public class WeatherFragment extends BaseFragment {

    private String type;
    private Context context;
    private HashMap<String, String> map;
    private TextView currentTemperatureTv;
    private TextView currentWeatherTypeTv;
    private TextView highWithLowTemperatureTv;
    private TextView currentWindTv;
    private TextView currentHumidityTv;
    private RelativeLayout airQualityRl;
    private TextView airQualityTv;
    private TextView airQualityValueTv;
    private RelativeLayout todayWeatherRl;
    private TextView todayTv;
    private TextView todayTemperatureTv;
    private Button todayAirQualityBt;
    private TextView todayWeatherTv;
    private ImageView todayWeatherIv;
    private RelativeLayout tomWeatherRl;
    private TextView tomTemperatureTv;
    private Button tomAirQualityBt;
    private TextView tomWeatherTv;
    private ImageView tomWeatherIv;

    private TableRow thirdTr;
    private RelativeLayout carTailNumberLimitRl;
    private TextView carTailNumberLimitValueTv;
    private RelativeLayout calendarRl;
    private TextView calendarValueTv;
    private RelativeLayout uvIndexRl;
    private TextView uvIndexValueTv;
    private RelativeLayout sportIndexRl;
    private TextView sportIndexValueTv;
    private RelativeLayout fluIndexRl;
    private TextView fluIndexValueTv;
    private RelativeLayout carWashIndexRl;
    private TextView carWashIndexValueTv;
    private RelativeLayout clothingIndexRl;
    private TextView clothingIndexValueTv;
    private RelativeLayout comfortIndexRl;
    private TextView comfortIndexValueTv;
    private RelativeLayout travelIndexTl;
    private TextView travelIndexValueTv;
    private RelativeLayout airPollutionDiffusionIndexRl;
    private TextView airPollutionDiffusionValueIndexTv;



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
        map = new HashMap<>();
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
        todayWeatherRl = (RelativeLayout)rootView.findViewById(R.id.today_weather_rl);
        todayAirQualityBt = (Button)rootView.findViewById(R.id.today_air_quality_bt);
        todayTemperatureTv = (TextView) rootView.findViewById(R.id.today_high_low_temperture_tv);
        todayWeatherTv = (TextView)rootView.findViewById(R.id.today_weather_tv);
        todayWeatherIv = (ImageView)rootView.findViewById(R.id.toady_weather_iv);
        tomWeatherRl = (RelativeLayout)rootView.findViewById(R.id.tom_weather_rl);
        tomAirQualityBt = (Button)rootView.findViewById(R.id.tom_air_quality_bt);
        tomTemperatureTv = (TextView) rootView.findViewById(R.id.tom_high_low_temperture_tv);
        tomWeatherTv = (TextView)rootView.findViewById(R.id.tom_weather_tv);
        tomWeatherIv = (ImageView)rootView.findViewById(R.id.tom_weather_iv);

        todayWeatherRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWeatherDetailActivity("1");
            }
        });

        tomWeatherRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWeatherDetailActivity("2");
            }
        });

        //生活指数
        carTailNumberLimitRl = (RelativeLayout)rootView.findViewById(R.id.car_tail_number_limit_rl);
        carTailNumberLimitValueTv = (TextView)rootView.findViewById(R.id.car_tail_number_limit_value_tv);
        calendarRl = (RelativeLayout)rootView.findViewById(R.id.calendar_rl);
        calendarValueTv = (TextView)rootView.findViewById(R.id.calendar_value_tv);
        uvIndexRl = (RelativeLayout)rootView.findViewById(R.id.uv_index_rl);
        uvIndexValueTv = (TextView) rootView.findViewById(R.id.uv_index_value_tv);
        sportIndexRl = (RelativeLayout)rootView.findViewById(R.id.sport_index_rl);
        sportIndexValueTv = (TextView)rootView.findViewById(R.id.sport_index_value_tv);
        fluIndexRl = (RelativeLayout) rootView.findViewById(R.id.flu_index_rl);
        fluIndexValueTv = (TextView)rootView.findViewById(R.id.flu_index_value_tv);
        carWashIndexRl = (RelativeLayout)rootView.findViewById(R.id.car_wash_index_rl);
        carWashIndexValueTv = (TextView)rootView.findViewById(R.id.car_wash_index_value_tv);
        clothingIndexRl = (RelativeLayout)rootView.findViewById(R.id.clothing_index_rl);
        clothingIndexValueTv = (TextView)rootView.findViewById(R.id.clothing_index_value_tv);
        comfortIndexRl = (RelativeLayout)rootView.findViewById(R.id.comfort_index_rl);
        comfortIndexValueTv = (TextView)rootView.findViewById(R.id.comfort_index_value_tv);
        travelIndexTl = (RelativeLayout)rootView.findViewById(R.id.travel_index_rl);
        travelIndexValueTv = (TextView)rootView.findViewById(R.id.travel_index_value_tv);
        airPollutionDiffusionIndexRl = (RelativeLayout)rootView.findViewById(R.id.air_pollution_diffusion_index_rl);
        airPollutionDiffusionValueIndexTv = (TextView) rootView.findViewById(R.id.air_pollution_diffusion_index_value_tv);
        thirdTr = (TableRow)rootView.findViewById(R.id.life_index_third_tr);

        initParameters();

        uvIndexRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UVIndexActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {

    }

    private void initParameters(){
        switch (type){
            case Constants.CURRENT_CITY_WEATHER:
                thirdTr.setVisibility(TableRow.VISIBLE);
                break;
            default:
                break;
        }
        map.put(Constants.LOCATION, type);
        map.put(Constants.USERNAME, Constants.USERNAME_VALUE);
        map.put(Constants.T, TimeUtils.getCurrentTimeStamp());
        map.put(Constants.SIGN, Constants.SIGN_VALUE);
    }

    private void startWeatherDetailActivity(String itemId){
        Intent intent = new Intent(getActivity(), WeatherDetailActivity.class);
        intent.putExtra(Constants.CURRENT_DAY_POSITION, itemId);
        startActivity(intent);
    }
}
