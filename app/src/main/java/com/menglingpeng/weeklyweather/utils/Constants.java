package com.menglingpeng.weeklyweather.utils;

import android.text.SpannableStringBuilder;

/**
 * Created by mengdroid on 2018/1/12.
 */

public class Constants {

    public static final String IS_FIRST_STRAT_APP = "is_first_start_app";
    public static final String TYPE = "type";
    public static final String LOCATION_ACTION = "location_action";
    public static final String LOCATION = "location";
    public static final String CURRENT_CITY_POSITION = "current_city_position";

    public static final int REQUEST_LOCATION_PERMISSION_CODE = 1;
    //Http_Config
    public static final long HTTP_CONFIG_HTTP_CONNECT_TIME = 15;
    public static final long HTTP_CONFIG_HTTP_READ_TIME = 60;
    public static final long HTTP_CONFIG_HTTP_WRITE_TIME = 60;
    //中国气象局数据网
    public static final String WEATHER_API_URL = "http://api.data.cma.cn:8090/";
    public static final String API = "api";
    //分配的账号
    public static final String USERID = "userId";
    //分配的密码
    public static final String PWD = "pwd";
    //返回的数据格式，目前仅支持json格式
    public static final String DATAFORMAT = "dataFormat";
    //此数据的接口ID，值为getSurfEleByTimeRangeAndStaID
    public static final String INTERFACEID = "interfaceId";
    //此数据的编码，中国地面气象站逐小时观测资料的编码为SURF_CHN_MUL_HOR
    public static final String DATACODE = "dataCode";
    //时间范围，支持最近7天的数据访问，格式为“[YYYYMMDDHHMISS,YYYYMMDDHHMISS]”
    public static final String TIMERANGE = "timeRange";
    //站号，支持1-30个站点，多个站点之间以“,”分隔
    public static final String STAIDS = "staIDs";
    //回数据字段，多个字段之间使用“,”分隔，其中:Station_Id_C, Year,Mon,Day,Hour为默认字段，Station_Id_C为站号，
    // Year为资料时间的年，Mon为资料时间的月，Day为资料时间的日，Hour为资料时间的时
    public static final String ELEMENTS = "elements";


    public static final String SP_DATA = "data";
    public static final String CURRENT_CITY_NAME = "current_city_name";
    public static final String CITIES_SIZE = "cities_size";
    public static final String CITIES_ = "cities_";
    public static final String ADD_CITY_DIALOG_FRAGMENT_TAG = "add_city_dialog_fragment";

    public static final String CURRENT_CITY_WEATHER = "current_city_weather";
    public static final String LIST_ADDED_CITIES = "list_added_cities";
    public static final String LIST_HOT_CITIES = "list_hot_cities";

}
