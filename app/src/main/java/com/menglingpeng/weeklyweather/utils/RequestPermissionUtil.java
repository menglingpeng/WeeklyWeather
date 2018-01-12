package com.menglingpeng.weeklyweather.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;

/**
 * Created by mengdroid on 2018/1/12.
 */

public class RequestPermissionUtil {

    public static void requestPermissions(Context context, String[] permissons, int requestCode){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, permissons[0]) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(context, permissons, requestCode);
            }
        }
    }
}
