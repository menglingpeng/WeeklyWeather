package com.menglingpeng.weeklyweather.mvp.bean;

import java.util.List;

/**
 * Created by mengdroid on 2018/2/5.
 */

public class HourlyWeather {

    private List<HeWeather6Bean> HeWeather6;

    public void setHeWeather6(List<HeWeather6Bean> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public List<HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    public static class HeWeather6Bean {

        private BasicBean basic;
        private String status;
        private UpdateBean update;
        private List<HourlyBean> hourly;

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public void setHourly(List<HourlyBean> hourly) {
            this.hourly = hourly;
        }

        public BasicBean getBasic() {
            return basic;
        }

        public String getStatus() {
            return status;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public List<HourlyBean> getHourly() {
            return hourly;
        }

        public static class HourlyBean {
            
            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String hum;
            private String pop;
            private String pres;
            private String time;
            private String tmp;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
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

            public String getCloud() {
                return cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public String getHum() {
                return hum;
            }

            public String getPop() {
                return pop;
            }

            public String getPres() {
                return pres;
            }

            public String getTime() {
                return time;
            }

            public String getTmp() {
                return tmp;
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
    }
}
