package com.menglingpeng.weeklyweather.mvp.interf;

/**
 * Created by mengdroid on 2017/10/19.
 */

public interface OnRecyclerItemListener {
    <T> void onRecyclerListListener(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, T t);
}
