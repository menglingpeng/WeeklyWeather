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
    public static final String CURRENT_DAY_POSITION = "current_day_position";
    public static final String TAB_VIEW_TYPE_WEATHER = "type_weather";
    public static final String TAB_VIEW_TYPE_INDEX = "type_index";

    public static final String TYPE_NORMAL = "normal";
    public static final String TYPE_EDITOR = "editor";


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

    //和风天气API
    //3天预报天气
    public static final String FORECAST_WEATHER_URL = "https://free-api.heweather.com/s6/weather/forecast";
    public static final String USERNAME = "username";
    public static final String USERNAME_VALUE = "";
    public static final String T = "t";
    public static final String SIGN = "sign";
    public static final String SIGN_VALUE = "";
    public static final String LANG = "lang";//默认简体中文
    public static final String UNIT = "unit";
    //实况天气
    public static final String NOW_WEATHER_URL = "https://free-api.heweather.com/s6/weather/now";
    //小时预报
    public static final String HOURLY_WEATHER_URL = "https://free-api.heweather.com/s6/weather/hourly";
    //生活指数
    public static final String LIFTSTYLE_WEATHER_URL = "https://free-api.heweather.com/s6/weather/lifestyle";
    //空气质量7天预报
    public static final String AIR_FORECAST_URL = "https://free-api.heweather.com/s6/air/forecast?parameters";
    //空气质量小时预报
    public static final String HOURLY_AIR_URL = "https://free-api.heweather.com/s6/air/hourly?parameters";
    //空气质量实时
    public static final String NOW_AIR_URL = "https://free-api.heweather.com/s6/air/now?parameters";

    //天气代码
    public static final String COND_CODE_100 = "100";
    public static final String COND_CODE_101 = "101";
    public static final String COND_CODE_102 = "102";
    public static final String COND_CODE_103 = "103";
    public static final String COND_CODE_104 = "104";
    public static final String COND_CODE_200 = "200";
    public static final String COND_CODE_201 = "201";
    public static final String COND_CODE_202 = "202";
    public static final String COND_CODE_203 = "203";
    public static final String COND_CODE_204 = "204";
    public static final String COND_CODE_205 = "205";
    public static final String COND_CODE_206 = "206";
    public static final String COND_CODE_207 = "207";
    public static final String COND_CODE_208 = "208";
    public static final String COND_CODE_209 = "209";
    public static final String COND_CODE_210 = "210";
    public static final String COND_CODE_211 = "211";
    public static final String COND_CODE_212 = "212";
    public static final String COND_CODE_213 = "213";
    public static final String COND_CODE_300 = "300";
    public static final String COND_CODE_301 = "301";
    public static final String COND_CODE_302 = "302";
    public static final String COND_CODE_303 = "303";
    public static final String COND_CODE_304 = "304";
    public static final String COND_CODE_305 = "305";
    public static final String COND_CODE_306 = "306";
    public static final String COND_CODE_307 = "307";
    public static final String COND_CODE_308 = "308";
    public static final String COND_CODE_309 = "309";
    public static final String COND_CODE_310 = "310";
    public static final String COND_CODE_311 = "311";
    public static final String COND_CODE_312 = "312";
    public static final String COND_CODE_313 = "313";
    public static final String COND_CODE_400 = "400";
    public static final String COND_CODE_401 = "401";
    public static final String COND_CODE_402 = "402";
    public static final String COND_CODE_403 = "403";
    public static final String COND_CODE_404 = "404";
    public static final String COND_CODE_405 = "405";
    public static final String COND_CODE_406 = "406";
    public static final String COND_CODE_407 = "407";
    public static final String COND_CODE_500 = "500";
    public static final String COND_CODE_501 = "501";
    public static final String COND_CODE_502 = "502";
    public static final String COND_CODE_503 = "503";
    public static final String COND_CODE_504 = "504";
    public static final String COND_CODE_507 = "507";
    public static final String COND_CODE_508 = "508";
    public static final String COND_CODE_900 = "900";
    public static final String COND_CODE_901 = "901";
    public static final String COND_CODE_999 = "999";

    public static final String INDEX_UV = "index_uv";
    public static final String INDEX_CODE = "index_code";
    public static final String INDEX_MORNING_EXERCISE = "index_morning_exercise";
    public static final String INDEX_CLOTHING = "index_clothing";
    public static final String INDEX_FISHING = "index_fishing";
    public static final String INDEX_CAR_WASH = "index_car_wash";
    public static final String WEATHER_COLLECTION = "weather_collection";

    public static final String TYPE_WEATHER = "type_weather";
    public static final String TYPE_AIR_QUALITY = "type_air_quality";

}
