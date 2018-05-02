package com.menglingpeng.weeklyweather.mvp.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.menglingpeng.weeklyweather.R;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Created by mengdroid on 2018/5/2.
 */

public class BannerHeaderAdapter  extends RecyclerAdapter{

    private static final int TYPE = 1;
    private ArrayList<String> list;

    public BannerHeaderAdapter(String index, String indexTitle, List datas) {
        super(index, indexTitle, datas);
    }

    @Override
    public int getItemViewType() {
        return TYPE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(CityPickerActivity.this).inflate(R.layout.item_city_header, parent,
                false);
        VH holder = new VH(view);
        return holder;
    }

    @Override
    public void onBindContentViewHolder(RecyclerView.ViewHolder holder, Object entity) {
        // 数据源为null时, 该方法不用实现
        final VH vh = (VH) holder;
        list=new ArrayList<>();
        for(int i = 0; i<city.length; i++){
            list.add(city[i]);
        }
        System.out.println("------------city"+list);
        cybChangeCityGridViewAdapter=new CYBChangeCityGridViewAdapter(CityPickerActivity.this, list);
        vh.head_home_change_city_gridview.setAdapter(cybChangeCityGridViewAdapter);
        vh.head_home_change_city_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("city", list.get(position));
                System.out.println("aaaaaayyyyyyyyy"+list.get(position));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        vh.item_header_city_dw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("city", vh.item_header_city_dw.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

    private class VH extends RecyclerView.ViewHolder {
        GridView head_home_change_city_gridview;
        TextView item_header_city_dw;
        public VH(View itemView) {
            super(itemView);
            head_home_change_city_gridview =(QGridView)itemView.findViewById(R.id.item_header_city_gridview);
            item_header_city_dw = itemView.findViewById(R.id.item_header_city_dw);
        }
    }
}

