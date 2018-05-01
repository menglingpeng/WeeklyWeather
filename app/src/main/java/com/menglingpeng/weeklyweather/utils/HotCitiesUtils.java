package com.menglingpeng.weeklyweather.utils;

import java.util.ArrayList;

/**
 * Created by mengdroid on 2018/1/21.
 */

public class HotCitiesUtils {

    public static String[] hotCities = new String[]{"北京市", "上海市", "天津市", "重庆市", "沈阳市", "长春市", "哈尔滨市",
            "大连市", "石家庄市", "郑州市", "武汉市", "长沙市", "南京市", "杭州市", "苏州市", "青岛市", "广州市",
            "深圳市", "厦门市", "成都市"};

    public static ArrayList<String> getHotCities(){
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < hotCities.length; i++ ){
            list.add(hotCities[i]);
        }
        return list;
    }
}
