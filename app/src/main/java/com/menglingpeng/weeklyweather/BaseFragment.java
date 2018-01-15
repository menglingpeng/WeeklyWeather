package com.menglingpeng.weeklyweather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mengdroid on 2018/1/15.
 */

public abstract class BaseFragment extends Fragment {

    protected View rootView;
    protected int layoutId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {

        if (rootView == null) {
            initLayoutId();
            rootView = inflater.inflate(layoutId, container, false);
            initData();
            initView();
        }
        return rootView;
    }

    @Nullable


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    protected abstract void initLayoutId();

    protected abstract void initView();

    protected abstract void initData();
}
