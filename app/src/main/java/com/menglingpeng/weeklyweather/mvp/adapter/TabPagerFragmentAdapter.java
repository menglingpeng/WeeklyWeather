package com.menglingpeng.weeklyweather.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import com.menglingpeng.weeklyweather.mvp.view.WeatherFragment;

import java.util.List;

/**
 * Created by mengdroid on 2017/11/9.
 */

public class TabPagerFragmentAdapter extends FragmentStatePagerAdapter {

    private List<WeatherFragment> fragments;
    private List<String> titles;
    private static WeatherFragment fragment;

    public TabPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragments(List<WeatherFragment> fragments, List<String> titles) {
        this.fragments = fragments;
        this.titles = titles;
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
        return titles.get(position);
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
