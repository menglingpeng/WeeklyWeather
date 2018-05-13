package com.menglingpeng.weeklyweather.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.menglingpeng.weeklyweather.R;
import com.menglingpeng.weeklyweather.mvp.bean.WeatherCollection;
import com.menglingpeng.weeklyweather.mvp.interf.OnRecyclerItemListener;
import com.menglingpeng.weeklyweather.utils.Constants;
import com.menglingpeng.weeklyweather.utils.SPUtils;

import java.util.ArrayList;

/**
 * Created by mengdroid on 2018/1/21.
 */

public class RecyclerAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList list;
    private String type;
    private OnRecyclerItemListener listener;
    private static final int VIEW_TYPE_LOCATION = 1;
    private int viewType = 0;

    public RecyclerAdapter(Context context, ArrayList list, String type, OnRecyclerItemListener listener){
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
        if(type.equals(Constants.LIST_ADDED_CITIES) && position == 0){
            viewType = VIEW_TYPE_LOCATION;
        }
        return viewType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == VIEW_TYPE_LOCATION){
            view = inflater.inflate(R.layout.cities_manage_recycler_view_location_item, null);
            viewHolder = new LocationCityViewHolder(view);
        }else {
            switch (type) {
                case Constants.LIST_ADDED_CITIES:
                    view = inflater.inflate(R.layout.cities_manage_recycler_view_item, null);
                    viewHolder = new AddedCitiesViewHolder(view);
                    break;
                case Constants.LIST_ADDED_CITIES_EDITOR:
                    view = inflater.inflate(R.layout.cities_manage_editor_recycler_view_item, null);
                    viewHolder = new AddedCitiesEditorViewHolder(view)
                    break;
                case Constants.LIST_HOT_CITIES:
                    view = inflater.inflate(R.layout.dialog_add_city_hot_cities_recyclerview_item, null);
                    viewHolder = new HotCityViewHolder(view);
                    break;
                default:
                    break;
            }
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
            final AddedCitiesViewHolder viewHolder = (AddedCitiesViewHolder)holder;
            final WeatherCollection.HeWeather6Bean.DailyForecastBean  dailyWeatherr = (WeatherCollection.
                    HeWeather6Bean.DailyForecastBean)list.get(position);
            if(position == Integer.valueOf(SPUtils.getData(context, Constants.CURRENT_CITY_POSITION))){
                viewHolder.itemRl.setBackgroundColor(context.getResources().getColor(
                        R.color.cm_recycler_view_item_rl_background));
            }
            String temperature = new StringBuilder().append(dailyWeatherr.getTmp_max()).append("/").append(
                    dailyWeatherr.getTmp_min()).toString();
            viewHolder.temperatureTv.setText(temperature);
            viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onRecyclerListListener(viewHolder, String.valueOf(position));
                    }
                }
            });
        }else if (holder instanceof LocationCityViewHolder){
            final LocationCityViewHolder viewHolder = (LocationCityViewHolder)holder;
            final WeatherCollection.HeWeather6Bean.DailyForecastBean  dailyWeatherr = (WeatherCollection.
                    HeWeather6Bean.DailyForecastBean)list.get(position);
            if(position == Integer.valueOf(SPUtils.getData(context, Constants.CURRENT_CITY_POSITION))){
                viewHolder.itemRl.setBackgroundColor(context.getResources().getColor(
                        R.color.cm_recycler_view_item_rl_background));
            }
            String temperature = new StringBuilder().append(dailyWeatherr.getTmp_max()).append("/").append(
                    dailyWeatherr.getTmp_min()).toString();
            viewHolder.temperatureTv.setText(temperature);
            viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onRecyclerListListener(viewHolder, String.valueOf(position));
                    }
                }
            });
        }else if (holder instanceof AddedCitiesEditorViewHolder){
           final AddedCitiesEditorViewHolder viewHolder = (AddedCitiesEditorViewHolder)holder;
            final WeatherCollection.HeWeather6Bean.DailyForecastBean  dailyWeatherr = (WeatherCollection.
                    HeWeather6Bean.DailyForecastBean)list.get(position);
           viewHolder.deleteIb.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Animation animation = AnimationUtils.loadAnimation(context,
                           R.anim.acitivity_cities_manage_editor_delete_button_rotate);
                   Animation resetAnimation = AnimationUtils.loadAnimation(context,
                           R.anim.acitivity_cities_manage_editor_delete_button_rotate_reset);
                   int count = 0;
                   if(count == 0){
                       count++;
                       viewHolder.deleteIb.setAnimation(animation);
                       viewHolder.deleteIb.setVisibility(ImageButton.GONE);
                       viewHolder.deleteBt.setVisibility(Button.VISIBLE);
                   }else if(count == 1){
                       count--;
                       viewHolder.deleteIb.setAnimation(resetAnimation);
                       viewHolder.deleteIb.setVisibility(ImageButton.VISIBLE);
                       viewHolder.deleteBt.setVisibility(Button.GONE);
                   }
               }
           });
           viewHolder.deleteBt.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   list.remove(position);
                   notifyDataSetChanged();
               }
           });
           viewHolder.settingBt.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

               }
           });
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

        private RelativeLayout itemRl;
        private ImageView imageView;
        private TextView cityTv;
        private TextView temperatureTv;

        public AddedCitiesViewHolder(View view) {
            super(view);
            itemRl = (RelativeLayout)view.findViewById(R.id.cm_recycler_view_item_rl);
            imageView = (ImageView)view.findViewById(R.id.cm_recycler_view_item_iv);
            cityTv = (TextView)view.findViewById(R.id.cm_recycler_view_item_city_tv);
            temperatureTv = (TextView)view.findViewById(R.id.cm_recycler_view_item_temperature_tv);
        }
    }

    private class AddedCitiesEditorViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout itemRl;
        private ImageButton deleteIb;
        private ImageView imageView;
        private TextView cityTv;
        private Button settingBt;
        private Button deleteBt;

        public AddedCitiesEditorViewHolder(View view) {
            super(view);
            itemRl = (RelativeLayout)view.findViewById(R.id.cm_editor_recycler_view_item_rl);
            deleteIb = (ImageButton)view.findViewById(R.id.cm_editor_recycler_view_item_delete_ib);
            cityTv = (TextView)view.findViewById(R.id.cm_editor_recycler_view_item_city_tv);
            settingBt = (Button)view.findViewById(R.id.cm_editor_recycler_view_item_setting_bt);
            deleteBt = (Button)view.findViewById(R.id.cm_editor_recycler_view_item_delete_bt);
        }
    }

    public class LocationCityViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout itemRl;
        private ImageView imageView;
        private TextView adressTv;
        private TextView cityTv;
        private TextView temperatureTv;

        public LocationCityViewHolder(View view) {
            super(view);
            itemRl = (RelativeLayout)view.findViewById(R.id.cm_recycler_view_location_item_rl);
            imageView = (ImageView)view.findViewById(R.id.cm_recycler_view_location_item_iv);
            adressTv = (TextView)view.findViewById(R.id.cm_recycler_view_location_item_adress_tv);
            cityTv = (TextView)view.findViewById(R.id.cm_recycler_view_location_item_city_tv);
            temperatureTv = (TextView)view.findViewById(R.id.cm_recycler_view_location_item_temperature_tv);
        }
    }
}
