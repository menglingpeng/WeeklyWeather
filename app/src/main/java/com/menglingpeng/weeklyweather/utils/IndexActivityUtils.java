package com.menglingpeng.weeklyweather.utils;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.menglingpeng.weeklyweather.R;
import com.menglingpeng.weeklyweather.mvp.adapter.TabPagerFragmentAdapter;
import com.menglingpeng.weeklyweather.mvp.view.IndexFragment;

import java.util.ArrayList;

/**
 * Created by mengdroid on 2018/2/24.
 */

public class IndexActivityUtils {

    public static void initTablayout(Context context, TabLayout tabLayout, final ViewPager viewPager,
                                     ArrayList<String> titles, ArrayList<IndexFragment> fragments,
                                     TabPagerFragmentAdapter adapter){
        titles.add(context.getString(R.string.today));
        titles.add(context.getString(R.string.tomorrow));
        titles.add(context.getString(R.string.day_after_tomorrow));
        adapter.setFragments(fragments, titles, Constants.TAB_VIEW_TYPE_INDEX);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.getCurrentItem();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
