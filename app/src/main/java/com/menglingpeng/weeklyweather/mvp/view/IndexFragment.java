package com.menglingpeng.weeklyweather.mvp.view;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.menglingpeng.weeklyweather.BaseFragment;
import com.menglingpeng.weeklyweather.R;

/**
 * Created by mengdroid on 2018/2/12.
 */

public class IndexFragment extends BaseFragment {

    private Context context;
    @Override
    protected void initLayoutId() {
        layoutId = R.layout.fragment_index;
    }

    @Override
    protected void initView() {
    context = getActivity().getApplicationContext();
    }

    @Override
    protected void initData() {

    }
}
