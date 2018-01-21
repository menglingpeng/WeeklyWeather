package com.menglingpeng.weeklyweather.mvp.view;

import android.app.Dialog;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.menglingpeng.weeklyweather.R;
import com.menglingpeng.weeklyweather.mvp.adapter.RecyclerAdapter;
import com.menglingpeng.weeklyweather.utils.Constants;
import com.menglingpeng.weeklyweather.utils.SPUtils;

import java.util.ArrayList;

/**
 * Created by mengdroid on 2018/1/20.
 */

public class AddCityDialogFragment extends AppCompatDialogFragment {

    private Dialog dialog;
    private Context context;
    private ImageView closeIv;
    private EditText editText;
    private ImageButton searchIBt;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<String> list;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        context = getContext();
        dialog = new Dialog(context, R.style.ThemeAddCityDialog );
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_add_city, null);
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.AnimationAddCityDialog);
        window.setGravity(Gravity.BOTTOM);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);
        dialog.setContentView(view);
        closeIv = (ImageView)view.findViewById(R.id.add_city_dialog_close_iv);
        editText = (EditText)view.findViewById(R.id.add_city_dialog_et);
        searchIBt = (ImageButton) view.findViewById(R.id.add_city_dialog_search_ib);
        recyclerView = (RecyclerView)view.findViewById(R.id.add_city_dialog_hot_cities_rv);
        dialog.show();
        closeIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        searchIBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
            }
        });
        //设置
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        list = SPUtils.getArray(context, list);
        adapter = new RecyclerAdapter(context, list, Constants.LIST_HOT_CITIES);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        return dialog;
    }
}
