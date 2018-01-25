package com.menglingpeng.weeklyweather.utils;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import org.w3c.dom.Comment;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static com.menglingpeng.weeklyweather.utils.RequestPermissionUtil.requestPermissions;

/**
 * Created by mengdroid on 2018/1/25.
 */

public class LocationService extends Service implements LocationListener{

    private LocationManager lm;
    private String provider = null;
    private Context context;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        context = getApplicationContext();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager
                    .PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission
                    .ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION}, Constants.REQUEST_LOCATION_PERMISSION_CODE);
            }
        }
        List<String> providers = lm.getProviders(true);
        if (providers.contains(lm.GPS_PROVIDER) || providers.contains(lm.NETWORK_PROVIDER)) {
            if(providers.contains(lm.GPS_PROVIDER)) {
                provider = lm.GPS_PROVIDER;
            }else {
                provider = lm.NETWORK_PROVIDER;
            }
            lm.requestLocationUpdates(provider, 0, 0, this);
        }else {
            //没有可用的定位服务，跳转设置界面
            Intent intent1 = new Intent();
            intent.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent1);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean stopService(Intent name) {
        return super.stopService(name);
    }

    @Override
    public void onLocationChanged(Location location) {
        Address address;
        String adminArea = null;
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        List<Address> list = null;
        try {
            list = geocoder.getFromLocation(location.getAltitude(), location.getLongitude(), 1);
            address = list.get(0);
            adminArea = address.getAdminArea();
            /*for(int i = 0; address.getAddressLine(i) != null; i++) {
                //得到周边信息。i=0,街道名称
                adressLine = address.getAddressLine(i);
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        //通知UI
        Intent intent = new Intent();
        intent.setAction(Constants.LOCATION_ACTION);
        intent.putExtra(Constants.LOCATION, adminArea);
        sendBroadcast(intent);
        //只需要定位一次，在此处移除监听，停掉服务。实时定位可在退出应用或者其他时候停掉。
        lm.removeUpdates(this);
        stopSelf();

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
