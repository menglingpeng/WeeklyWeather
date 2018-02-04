package com.menglingpeng.weeklyweather.mvp.bean;

/**
 * Created by mengdroid on 2018/2/4.
 */

public class UpdateBean {

    private String loc;
    private String utc;

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }

    public String getLoc() {
        return loc;
    }

    public String getUtc() {
        return utc;
    }
}
