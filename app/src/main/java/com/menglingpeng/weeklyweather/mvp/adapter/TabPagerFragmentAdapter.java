package com.menglingpeng.weeklyweather.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.menglingpeng.weeklyweather.mvp.view.IndexFragment;
import com.menglingpeng.weeklyweather.mvp.view.WeatherFragment;
import com.menglingpeng.weeklyweather.utils.Constants;

import java.util.List;

/**
 * Created by mengdroid on 2017/11/9.
 */

public class TabPagerFragmentAdapter extends FragmentStatePagerAdapter {

    private List<WeatherFragment> weatherFragments;
    private List<IndexFragment> indexFragments;
    private List<Fragment> fragments;
    private List<String> titles;
    private static WeatherFragment fragment;

    public TabPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragments(List fragments, List<String> titles, String type) {
        switch (type) {
            case Constants.TAB_VIEW_TYPE_WEATHER:
                this.fragments = fragments;
                break;
            case Constants.TAB_VIEW_TYPE_INDEX:
                this.fragments = fragments;
                break;
            default:
                break;
        }
        this.fragments = fragments;
        this.titles = titles;
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
