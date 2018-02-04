package com.menglingpeng.weeklyweather.mvp.bean;

/**
 * Created by mengdroid on 2018/2/4.
 */

public class BasicBean {

    private String cid;
    private String location;
    private String parent_city;
    private String admin_area;
    private String cnty;
    private String lat;
    private String lon;
    private String tz;

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setParent_city(String parent_city) {
        this.parent_city = parent_city;
    }

    public void setAdmin_area(String admin_area) {
        this.admin_area = admin_area;
    }

    public void setCnty(String cnty) {
        this.cnty = cnty;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getCid() {
        return cid;
    }

    public String getLocation() {
        return location;
    }

    public String getParent_city() {
        return parent_city;
    }

    public String getAdmin_area() {
        return admin_area;
    }

    public String getCnty() {
        return cnty;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getTz() {
        return tz;
    }
}
