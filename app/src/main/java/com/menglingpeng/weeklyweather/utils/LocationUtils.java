package com.menglingpeng.weeklyweather.utils;

import android.Manifest;
import android.app.Activity;
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
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by mengdroid on 2018/1/12.
 */

public class LocationUtils implements LocationListener {

    public static String getBestLocation(Context context) {
        String provider = null;
        Location location = null;
        String locations = null;
        Address address;
        String countryName = null;
        String locality = null;
        String adressLine = null;
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager
                .PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission
                .ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION }, Constants.REQUEST_LOCATION_PERMISSION_CODE);
        }
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        List<String> providers = lm.getProviders(true);
        if (providers.contains(lm.GPS_PROVIDER) || providers.contains(lm.NETWORK_PROVIDER)) {
            if(providers.contains(lm.GPS_PROVIDER)) {
                provider = lm.GPS_PROVIDER;
            }else {
                provider = lm.NETWORK_PROVIDER;
            }
        }else {
            //没有可用的定位服务，跳转设置界面
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            context.startActivity(intent);
        }
        location = lm.getLastKnownLocation(provider);
        if(location != null){

        }
        lm.requestLocationUpdates(provider, 5000, 10, this);
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        List<Address> list = null;
        try {
            list = geocoder.getFromLocation(location.getAltitude(), location.getLongitude(), 1);
            address = list.get(0);
            countryName = address.getCountryName();
            locality = address.getLocality();
            for(int i = 0; address.getAddressLine(i) != null; i++) {
                //得到周边信息。i=0,街道名称
                adressLine = address.getAddressLine(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        locations = adressLine;
        return locations;
    }

    @Override
    public void onLocationChanged(Location location) {
        //得到维度
        double latitude = location.getLatitude();
        //得到经度
        double longitude = location.getLongitude();
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
