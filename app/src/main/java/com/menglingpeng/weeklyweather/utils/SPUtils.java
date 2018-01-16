package com.menglingpeng.weeklyweather.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * Created by mengdroid on 2018/1/16.
 */

public class SPUtils {

    /**
     * 首次启动应用后，保存标志位。
     */
    public static boolean saveState(Context context, String key, Boolean is) {
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_DATA, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, is);
        return editor.commit();
    }

    /**
     * 判断应用是否第一次启动。
     */
    public static boolean getState(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_DATA, Context.MODE_PRIVATE);
        //不存在则是第一次启动，值为ture
        return sp.getBoolean(key, true);
    }

    public static void putData(Context context, String key, String value){
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_DATA, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getData(Context context, String key){
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_DATA, Context.MODE_PRIVATE);
        return sp.getString(key, null);
    }

    public static void removeData(Context context, String key){
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_DATA, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
    }

    public static boolean putArray(Context context, ArrayList<String> list){
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_DATA, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putInt(Constants.CITIES_SIZE, list.size());
        for (int i = 0; i < list.size(); i++){
            editor.putString(Constants.CITIES_ + i, list.get(i));
        }
        return editor.commit();
    }

    public static ArrayList<String> getArray(Context context, ArrayList<String> list){
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_DATA, Context.MODE_PRIVATE);
        list.clear();
        int size = sp.getInt(Constants.CITIES_SIZE, 0);
        for(int i = 0; i < size; i++){
            list.add(sp.getString(Constants.CITIES_ + i, null));
        }
        return list;
    }
}
