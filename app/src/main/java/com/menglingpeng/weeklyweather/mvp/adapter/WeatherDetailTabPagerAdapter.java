package com.menglingpeng.weeklyweather.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.menglingpeng.weeklyweather.mvp.view.WeatherFragment;

import java.util.List;

/**
 * Created by mengdroid on 2018/1/29.
 */

public class WeatherDetailTabPagerAdapter extends FragmentStatePagerAdapter {

    private List<WeatherFragment> fragments;
    private List<String> titles1;
    private List<String> titles2;
    private static WeatherFragment fragment;

    public WeatherDetailTabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragments(List<WeatherFragment> fragments, List<String> titles1, List<String> titles2) {
        this.fragments = fragments;
        this.titles1 = titles1;
        this.titles2 = titles2;
    }

    public void clearFragments() {
        for (Fragment fragment : fragments) {
            if (fragment != null && fragment.isAdded()) {
                fragment.onDestroy();
            }
        }
        fragments.clear();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles1.get(position);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        fragment = (WeatherFragment) object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    public static WeatherFragment getCurrentPagerViewFragment() {
        return fragment;
    }
}
