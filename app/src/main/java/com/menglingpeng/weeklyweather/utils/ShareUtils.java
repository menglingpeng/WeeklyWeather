package com.menglingpeng.weeklyweather.utils;

import android.content.Context;
import android.content.Intent;

import com.menglingpeng.weeklyweather.R;

/**
 * Created by mengdroid on 2018/1/27.
 */

public class ShareUtils {

    public static void share(Context context, String shareText) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, shareText);
        context.startActivity(Intent.createChooser(intent, context.getResources().getString(R.string.
                share_create_chooser_title)));
    }
}
