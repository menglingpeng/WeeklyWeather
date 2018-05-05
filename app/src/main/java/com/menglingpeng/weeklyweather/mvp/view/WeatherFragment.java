package com.menglingpeng.weeklyweather.mvp.view;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.menglingpeng.weeklyweather.BaseFragment;
import com.menglingpeng.weeklyweather.MainActivity;
import com.menglingpeng.weeklyweather.R;
import com.menglingpeng.weeklyweather.mvp.bean.AirQualityCollection;
import com.menglingpeng.weeklyweather.mvp.bean.WeatherCollection;
import com.menglingpeng.weeklyweather.utils.Constants;
import com.menglingpeng.weeklyweather.utils.TimeUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mengdroid on 2018/1/15.
 */

public class WeatherFragment extends BaseFragment implements View.OnClickListener{

    private String type;
    private Context context;
    private WeatherCollection weatherCollection;
    private AirQualityCollection  airQualityCollection;
    private List<WeatherCollection.HeWeather6Bean.DailyForecastBean> dailyForecastList;
    private List<WeatherCollection.HeWeather6Bean.HourlyBean> hourlyList;
    private WeatherCollection.HeWeather6Bean.NowBean nowBean;
    private List<WeatherCollection.HeWeather6Bean.LifestyleBean> lifestyleList;
    private HashMap<String, String> map;
    private TextView nowTmpTv;
    private TextView nowWeatherTypeTv;
    private TextView tmpMaxMinTv;
    private TextView nowWindTv;
    private TextView nowHumidityTv;
    private RelativeLayout airQualityRl;
    private TextView airQualityTv;
    private TextView airQualityValueTv;
    private RelativeLayout todayWeatherRl;
    private TextView todayTv;
    private TextView todayTmpTv;
    private Button todayAirQualityBt;
    private TextView todayWeatherTv;
    private ImageView todayWeatherIv;
    private RelativeLayout tomWeatherRl;
    private TextView tomTmpTv;
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
        weatherCollection = (WeatherCollection) getArguments().getSerializable(Constants.TYPE_WEATHER);
        airQualityCollection = (AirQualityCollection)getArguments().getSerializable(Constants.TYPE_AIR_QUALITY);
        nowTmpTv = (TextView)rootView.findViewById(R.id.now_tmp_tv);
        nowWeatherTypeTv = (TextView)rootView.findViewById(R.id.now_weather_type_tv);
        tmpMaxMinTv = (TextView)rootView.findViewById(R.id.tmp_max_min_tv);
        nowWindTv = (TextView)rootView.findViewById(R.id.now_wind_tv);
        nowHumidityTv = (TextView)rootView.findViewById(R.id.now_humidity_tv);
        airQualityRl = (RelativeLayout)rootView.findViewById(R.id.air_quality_rl);
        airQualityTv = (TextView)rootView.findViewById(R.id.air_quality_tv);
        airQualityValueTv = (TextView)rootView.findViewById(R.id.air_quality_value_tv);
        todayTv = (TextView)rootView.findViewById(R.id.today_tv);
        //今天、明天天气
        todayWeatherRl = (RelativeLayout)rootView.findViewById(R.id.today_weather_rl);
        todayAirQualityBt = (Button)rootView.findViewById(R.id.today_air_quality_bt);
        todayTmpTv = (TextView) rootView.findViewById(R.id.today_tmp_max_min_tv);
        todayWeatherTv = (TextView)rootView.findViewById(R.id.today_weather_tv);
        todayWeatherIv = (ImageView)rootView.findViewById(R.id.toady_weather_iv);
        tomWeatherRl = (RelativeLayout)rootView.findViewById(R.id.tom_weather_rl);
        tomAirQualityBt = (Button)rootView.findViewById(R.id.tom_air_quality_bt);
        tomTmpTv = (TextView) rootView.findViewById(R.id.tom_tmp_max_min_tv);
        tomWeatherTv = (TextView)rootView.findViewById(R.id.tom_weather_tv);
        tomWeatherIv = (ImageView)rootView.findViewById(R.id.tom_weather_iv);

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
    }

    @Override
    protected void initData() {
        dailyForecastList = weatherCollection.getHeWeather6().get(0).getDaily_forecast();
        hourlyList = weatherCollection.getHeWeather6().get(0).getHourly();
        nowBean = weatherCollection.getHeWeather6().get(0).getNow();
        lifestyleList = weatherCollection.getHeWeather6().get(0).getLifestyle();
        //实时天气
        nowWeatherTypeTv.setText(nowBean.getCond_txt());
        nowWindTv.setText(nowBean.getWind_sc());
        nowTmpTv.setText(nowBean.getTmp());
        nowHumidityTv.setText(nowBean.getHum());
        String tmpMaxMinText = new StringBuffer().append(dailyForecastList.get(0).getTmp_max()).append("°C").append("/").
                append(dailyForecastList.get(0).getTmp_min()).append("°C").toString();
        tmpMaxMinTv.setText(tmpMaxMinText);
        airQualityTv.setText(airQualityCollection.getHeWeather6().get(0).getAirNowCityBeans().get(0).getQlty());
        airQualityValueTv.setText(airQualityCollection.getHeWeather6().get(0).getAirNowCityBeans().get(0).getAqi());
        //今天，明天天气综述
        //生活指数
        comfortIndexValueTv.setText(lifestyleList.get(0).getBrf());
        clothingIndexValueTv.setText(lifestyleList.get(1).getBrf());
        fluIndexValueTv.setText(lifestyleList.get(2).getBrf());
        sportIndexValueTv.setText(lifestyleList.get(3).getBrf());
        travelIndexValueTv.setText(lifestyleList.get(4).getBrf());
        uvIndexValueTv.setText(lifestyleList.get(5).getBrf());
        carWashIndexValueTv.setText(lifestyleList.get(6).getBrf());
        airPollutionDiffusionValueIndexTv.setText(lifestyleList.get(7).getBrf());

    }

    private void initParameters(){
        switch (type){
            case Constants.CURRENT_CITY_WEATHER:
                thirdTr.setVisibility(TableRow.VISIBLE);
                String text = null;
                WeatherCollection.HeWeather6Bean.DailyForecastBean todayForecastBean = weatherCollection.getHeWeather6()
                        .get(0).getDaily_forecast().get(0);
                WeatherCollection.HeWeather6Bean.DailyForecastBean tomForecastBean = weatherCollection.getHeWeather6()
                        .get(0).getDaily_forecast().get(1);
                if() {
                    text = new StringBuilder().append(todayForecastBean.getCond_txt_n()).append("，").
                            append(todayForecastBean.getTmp_min()).append("/").append(todayForecastBean.getTmp_max()).
                            toString();
                    sendNotification(context, getResources().getString(R.string.notification_today_weather_title),
                            text);
                }else {
                    text = new StringBuilder().append(tomForecastBean.getCond_txt_n()).append("，").
                            append(tomForecastBean.getTmp_min()).append("/").append(todayForecastBean.getTmp_max()).
                            toString();
                    sendNotification(context, getResources().getString(R.string.notification_tom_weather_title), text);
                }
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

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.today_weather_rl:
                startWeatherDetailActivity("0");
                break;
            case R.id.tom_weather_rl:
                startWeatherDetailActivity("1");
                break;
            case R.id.calendar_rl:
                intent = new Intent(getActivity(), CalendarActivity.class);
                startActivity(intent);
                break;
            case R.id.comfort_index_rl:
                intent = new Intent(getActivity(), ComfortIndexActivity.class);
                startActivity(intent);
                break;
            case R.id.clothing_index_rl:
                intent = new Intent(getActivity(), ClothingIndexActivity.class);
                startActivity(intent);
                break;
            case R.id.flu_index_rl:
                intent = new Intent(getActivity(), FluIndexActivity.class);
                startActivity(intent);
                break;
            case R.id.sport_index_rl:
                intent = new Intent(getActivity(), SportIndexActivity.class);
                startActivity(intent);
                break;
            case R.id.travel_index_rl:
                intent = new Intent(getActivity(), TravelIndexActivity.class);
                startActivity(intent);
                break;
            case R.id.uv_index_rl:
                intent = new Intent(getActivity(), UVIndexActivity.class);
                startActivity(intent);
                break;
            case R.id.car_wash_index_rl:
                intent = new Intent(getActivity(), CarWashIndexActivity.class);
                startActivity(intent);
                break;
            case R.id.air_pollution_diffusion_index_rl:
                intent = new Intent(getActivity(), AirPollutionDiffusionIndexActivity.class);
                startActivity(intent);
                break;
            case R.id.car_tail_number_limit_rl:
                intent = new Intent(getActivity(), CarTailNumberLimitActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void sendNotification(Context context, String notifyTitle, String notifyText){
        //实例化通知管理器
        NotificationManager notificationManager= (NotificationManager)context. getSystemService(
                Context.NOTIFICATION_SERVICE);
        //实例化通知
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context);
        builder.setContentTitle(getString(R.string.notification_title));//设置通知标题
        builder.setContentText("不要放孔明灯，容易起火");//设置通知内容
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);//设置通知的方式，震动、LED灯、音乐等
        builder.setAutoCancel(true);//点击通知后，状态栏自动删除通知
        builder.setSmallIcon(android.R.drawable.ic_media_play);//设置小图标
        builder.setContentIntent(PendingIntent.getActivity(this,0x102,new Intent(
                getActivity(),MainActivity.class),0));//设置点击通知后将要启动的程序组件对应的PendingIntent
        Notification notification=builder.build();

        //发送通知
        notificationManager.notify(0x101,notification);

    }
}
