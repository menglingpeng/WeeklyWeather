package com.menglingpeng.weeklyweather.mvp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.menglingpeng.weeklyweather.R;
import com.menglingpeng.weeklyweather.mvp.bean.DayWeather;
import com.menglingpeng.weeklyweather.mvp.interf.OnRecyclerItemListener;
import com.menglingpeng.weeklyweather.utils.Constants;

import java.util.ArrayList;

/**
 * Created by mengdroid on 2018/1/21.
 */

public class RecyclerAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList list;
    private String type;
    private OnRecyclerItemListener listener;

    public RecyclerAdapter(Context context, ArrayList<String> list, String type, OnRecyclerItemListener listener){
        this.context = context;
        this.list = list;
        this.type = type;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        switch (type){
            case Constants.LIST_ADDED_CITIES:
                view = inflater.inflate(R.layout.cities_manage_recycler_view_item, null);
                viewHolder = new AddedCitiesViewHolder(view);
                break;
            case Constants.LIST_HOT_CITIES:
                view = inflater.inflate(R.layout.dialog_add_city_hot_cities_recyclerview_item, null);
                viewHolder = new HotCityViewHolder(view);
                break;
            default:
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof HotCityViewHolder){
            final HotCityViewHolder viewHolder = (HotCityViewHolder)holder;
            if(position == 0){
                viewHolder.hotCityBt.setCompoundDrawables(context.getDrawable(R.drawable.ic_location_on_black_18dp),
                        null, null, null);
                viewHolder.hotCityBt.setCompoundDrawablePadding(10);
            }
            viewHolder.hotCityBt.setText((String)list.get(position));
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onRecyclerListListener(viewHolder, list.get(position));
                    }
                }
            });
        }else if(holder instanceof AddedCitiesViewHolder){
            final  AddedCitiesViewHolder viewHolder = (AddedCitiesViewHolder)holder;
            final DayWeather dayWeather = (DayWeather)list.get(position);
            viewHolder.adressTv.setText(dayWeather.getData().getCity());
            String temperature = new StringBuilder().append(dayWeather.getData().getForecast().get(0).getHigh()).
                    append("/").append(dayWeather.getData().getForecast().get(0).getLow()).toString();
            viewHolder.temperatureTv.setText(temperature);
        }

    }

    private class HotCityViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout hotCityRl;
        private Button hotCityBt;

        public HotCityViewHolder(View view) {
            super(view);
            hotCityRl = (RelativeLayout)view.findViewById(R.id.hot_city_rl);
            hotCityBt = (Button) view.findViewById(R.id.hot_city_bt);
        }
    }

    private class AddedCitiesViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView adressTv;
        private TextView temperatureTv;

        public AddedCitiesViewHolder(View view) {
            super(view);
            imageView = (ImageView)view.findViewById(R.id.cm_recycler_view_item_iv);
            adressTv = (TextView)view.findViewById(R.id.cm_recycler_view_item_city_tv);
            temperatureTv = (TextView)view.findViewById(R.id.cm_recycler_view_item_temperature_iv);
        }
    }
}
