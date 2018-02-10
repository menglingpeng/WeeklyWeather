package com.menglingpeng.weeklyweather.utils;

import android.widget.ImageView;

import com.menglingpeng.weeklyweather.R;

/**
 * Created by mengdroid on 2018/2/10.
 */

public class WeatherIconUtils {

    public static void setIcon(ImageView imageView, String code){
        switch (code){
            case Constants.COND_CODE_100:
                imageView.setImageResource(R.drawable.ic_cond_100);
            case Constants.COND_CODE_101:
                imageView.setImageResource(R.drawable.ic_cond_101);
            case Constants.COND_CODE_102:
                imageView.setImageResource(R.drawable.ic_cond_102);
            case Constants.COND_CODE_103:
                imageView.setImageResource(R.drawable.ic_cond_103);
            case Constants.COND_CODE_104:
                imageView.setImageResource(R.drawable.ic_cond_104);
            case Constants.COND_CODE_201:
                imageView.setImageResource(R.drawable.ic_cond_201);
            case Constants.COND_CODE_202:
                imageView.setImageResource(R.drawable.ic_cond_202);
            case Constants.COND_CODE_203:
                imageView.setImageResource(R.drawable.ic_cond_203);
            case Constants.COND_CODE_204:
                imageView.setImageResource(R.drawable.ic_cond_204);
            case Constants.COND_CODE_205:
                imageView.setImageResource(R.drawable.ic_cond_205);
            case Constants.COND_CODE_206:
                imageView.setImageResource(R.drawable.ic_cond_206);
            case Constants.COND_CODE_207:
                imageView.setImageResource(R.drawable.ic_cond_207);
            case Constants.COND_CODE_208:
                imageView.setImageResource(R.drawable.ic_cond_208);
            case Constants.COND_CODE_209:
                imageView.setImageResource(R.drawable.ic_cond_209);
            case Constants.COND_CODE_210:
                imageView.setImageResource(R.drawable.ic_cond_210);
            case Constants.COND_CODE_211:
                imageView.setImageResource(R.drawable.ic_cond_211);
            case Constants.COND_CODE_212:
                imageView.setImageResource(R.drawable.ic_cond_212);
            case Constants.COND_CODE_213:
                imageView.setImageResource(R.drawable.ic_cond_213);
            case Constants.COND_CODE_300:
                imageView.setImageResource(R.drawable.ic_cond_100);
            case Constants.COND_CODE_301:
                imageView.setImageResource(R.drawable.ic_cond_301);
            case Constants.COND_CODE_302:
                imageView.setImageResource(R.drawable.ic_cond_302);
            case Constants.COND_CODE_303:
                imageView.setImageResource(R.drawable.ic_cond_303);
            case Constants.COND_CODE_304:
                imageView.setImageResource(R.drawable.ic_cond_304);
            case Constants.COND_CODE_305:
                imageView.setImageResource(R.drawable.ic_cond_305);
            case Constants.COND_CODE_306:
                imageView.setImageResource(R.drawable.ic_cond_306);
            case Constants.COND_CODE_307:
                imageView.setImageResource(R.drawable.ic_cond_307);
            case Constants.COND_CODE_308:
                imageView.setImageResource(R.drawable.ic_cond_308);
            case Constants.COND_CODE_309:
                imageView.setImageResource(R.drawable.ic_cond_309);
            case Constants.COND_CODE_310:
                imageView.setImageResource(R.drawable.ic_cond_310);
            case Constants.COND_CODE_311:
                imageView.setImageResource(R.drawable.ic_cond_311);
            case Constants.COND_CODE_312:
                imageView.setImageResource(R.drawable.ic_cond_312);
            case Constants.COND_CODE_313:
                imageView.setImageResource(R.drawable.ic_cond_313);
            case Constants.COND_CODE_400:
                imageView.setImageResource(R.drawable.ic_cond_400);
            case Constants.COND_CODE_401:
                imageView.setImageResource(R.drawable.ic_cond_401);
            case Constants.COND_CODE_402:
                imageView.setImageResource(R.drawable.ic_cond_402);
            case Constants.COND_CODE_403:
                imageView.setImageResource(R.drawable.ic_cond_403);
            case Constants.COND_CODE_404:
                imageView.setImageResource(R.drawable.ic_cond_404);
            case Constants.COND_CODE_405:
                imageView.setImageResource(R.drawable.ic_cond_405);
            case Constants.COND_CODE_406:
                imageView.setImageResource(R.drawable.ic_cond_406);
            case Constants.COND_CODE_407:
                imageView.setImageResource(R.drawable.ic_cond_407);
            case Constants.COND_CODE_500:
                imageView.setImageResource(R.drawable.ic_cond_500);
            case Constants.COND_CODE_501:
                imageView.setImageResource(R.drawable.ic_cond_501);
            case Constants.COND_CODE_502:
                imageView.setImageResource(R.drawable.ic_cond_502);
            case Constants.COND_CODE_503:
                imageView.setImageResource(R.drawable.ic_cond_503);
            case Constants.COND_CODE_504:
                imageView.setImageResource(R.drawable.ic_cond_504);
            case Constants.COND_CODE_507:
                imageView.setImageResource(R.drawable.ic_cond_507);
            case Constants.COND_CODE_508:
                imageView.setImageResource(R.drawable.ic_cond_508);
            case Constants.COND_CODE_900:
                imageView.setImageResource(R.drawable.ic_cond_900);
            case Constants.COND_CODE_901:
                imageView.setImageResource(R.drawable.ic_cond_901);
            case Constants.COND_CODE_999:
                imageView.setImageResource(R.drawable.ic_cond_999);
                break;
            default:
                break;
        }
    }
}
