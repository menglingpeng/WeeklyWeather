package com.menglingpeng.weeklyweather.mvp.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.menglingpeng.weeklyweather.MainActivity;
import com.menglingpeng.weeklyweather.R;
import com.menglingpeng.weeklyweather.mvp.adapter.RecyclerAdapter;
import com.menglingpeng.weeklyweather.mvp.bean.CityEntity;
import com.menglingpeng.weeklyweather.mvp.interf.OnRecyclerItemListener;
import com.menglingpeng.weeklyweather.utils.Constants;
import com.menglingpeng.weeklyweather.utils.HotCitiesUtils;
import com.menglingpeng.weeklyweather.utils.SPUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mengdroid on 2018/1/20.
 */

public class AddCityDialogFragment extends AppCompatDialogFragment implements OnRecyclerItemListener{

    private Dialog dialog;
    private Context context;
    private ImageView closeIv;
    private AutoCompleteTextView editText;
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
        editText = (AutoCompleteTextView) view.findViewById(R.id.add_city_dialog_et);
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
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line,
                HotCitiesUtils.cities);
        editText.setAdapter(arrayAdapter);
        //设置输入多少字符后提示，默认值为2，在此设为１
        editText.setThreshold(1);
        //设置
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        list = HotCitiesUtils.getHotCities();
        list.add(0, SPUtils.getData(context, Constants.LOCATION));
        adapter = new RecyclerAdapter(context, list, Constants.LIST_HOT_CITIES, this);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        return dialog;
    }

    private List<CityEntity> initDatas() {
        List<CityEntity> list = new ArrayList<>();
        List<String> cityStrings = Arrays.asList(getResources().getStringArray(R.array.city_array));
        for (String item : cityStrings) {
            CityEntity cityEntity = new CityEntity();
            cityEntity.setName(item);
            list.add(cityEntity);
        }
        return list;
    }

    private List<CityEntity> iniyGPSCityDatas() {
        List<CityEntity> list = new ArrayList<>();
        list.add(new CityEntity("定位中..."));
        return list;
    }


    @Override
    public <T> void onRecyclerListListener(RecyclerView.ViewHolder viewHolder, T t) {
        ArrayList<String> list = new ArrayList<>();
        String city = (String)t;
        list = SPUtils.getArray(context, list);
        list.add(city);
        Boolean isSaved = SPUtils.putArray(context, list);
        if(isSaved) {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            intent.putStringArrayListExtra(Constants.LIST_ADDED_CITIES, list);
            startActivity(intent);
        }
    }
}
