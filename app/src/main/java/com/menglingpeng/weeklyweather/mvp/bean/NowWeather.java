package com.menglingpeng.weeklyweather.mvp.bean;

import java.util.List;

/**
 * Created by mengdroid on 2018/2/4.
 */

public class NowWeather {

    private List<HeWeather6Bean> HeWeather6;

    public void setHeWeather6(List<HeWeather6Bean> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public List<HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    public static class HeWeather6Bean {

        private BasicBean basic;
        private NowBean now;
        private String status;
        private UpdateBean update;

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public BasicBean getBasic() {
            return basic;
        }

        public NowBean getNow() {
            return now;
        }

        public String getStatus() {
            return status;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public static class BasicBean {

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

        public static class NowBean {

            private String cond_code;
            private String cond_txt;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }

            public String getCond_code() {
                return cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public String getFl() {
                return fl;
            }

            public String getHum() {
                return hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public String getPres() {
                return pres;
            }

            public String getTmp() {
                return tmp;
            }

            public String getVis() {
                return vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }
        }

        public static class UpdateBean {

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
    }
}
