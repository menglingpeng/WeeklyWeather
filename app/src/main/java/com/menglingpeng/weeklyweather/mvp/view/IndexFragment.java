package com.menglingpeng.weeklyweather.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.menglingpeng.weeklyweather.BaseFragment;
import com.menglingpeng.weeklyweather.R;
import com.menglingpeng.weeklyweather.mvp.bean.WeatherCollection;
import com.menglingpeng.weeklyweather.utils.Constants;

/**
 * Created by mengdroid on 2018/2/12.
 */

public class IndexFragment extends BaseFragment {

    private Context context;
    private String type;
    private WeatherCollection weather;
    private TextView indexTv;
    private TextView cityTv;
    private TextView firstParameterTv;
    private TextView firstParameterValueTv;
    private TextView secondParameterTv;
    private TextView secondParameterValueTv;
    private TextView thirdParameterTv;
    private TextView thirdParameterValueTv;
    private TextView indexDescTv;

    public static IndexFragment newInstants(String type, WeatherCollection weatherCollection){
        Bundle bundle = new Bundle();
        bundle.putString(Constants.TYPE, type);
        bundle.putSerializable(Constants.WEATHER_COLLECTION , weatherCollection);
        IndexFragment fragment = new IndexFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initLayoutId() {
        layoutId = R.layout.fragment_index;
    }

    @Override
    protected void initView() {
    context = getActivity().getApplicationContext();
    type = getArguments().get(Constants.TYPE).toString();
    weather = (WeatherCollection) getArguments().getSerializable(Constants.WEATHER_COLLECTION);
        indexTv = (TextView)rootView.findViewById(R.id.fragment_index_tv);
    cityTv = (TextView)rootView.findViewById(R.id.fragment_index_city_tv);
    firstParameterTv = (TextView)rootView.findViewById(R.id.fragment_index_first_parameter_tv);
    firstParameterValueTv = (TextView)rootView.findViewById(R.id.fragment_index_second_parameter_value_tv);
    secondParameterTv = (TextView)rootView.findViewById(R.id.fragment_index_second_parameter_tv);
    secondParameterValueTv = (TextView)rootView.findViewById(R.id.fragment_index_second_parameter_value_tv);
    thirdParameterTv = (TextView)rootView.findViewById(R.id.fragment_index_third_parameter_tv);
    thirdParameterValueTv = (TextView)rootView.findViewById(R.id.fragment_index_third_parameter_value_tv);
    indexDescTv = (TextView)rootView.findViewById(R.id.fragment_index_desc);
    }

    @Override
    protected void initData() {
        String firstParameterText = null;
        String firstParameterValueText = null;
        String secondParameterText = null;
        String secondParameterValueText = null;
        String thirdParameterText = null;
        String thirdParameterValueText = null;
        String indexDescText = null;
        switch (type){
            case Constants.INDEX_UV:
                firstParameterText= context.getString(R.string.temprature_range);
                secondParameterText = context.getString(R.string.weather);
                thirdParameterText = context.getString(R.string.sunrise_sunset);
                break;
            case Constants.INDEX_CODE:
                break;
            case Constants.INDEX_CLOTHING:
                break;
            case Constants.INDEX_FISHING:
                break;
            case Constants.INDEX_MORNING_EXERCISE:
                break;
            case Constants.INDEX_CAR_WASH:
                break;
            default:
                break;
        }
        firstParameterTv.setText(firstParameterText);
        secondParameterTv.setText(secondParameterText);
        thirdParameterTv.setText(thirdParameterText);
        indexDescTv.setText(indexDescText);

    }
}
