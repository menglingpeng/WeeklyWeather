package com.menglingpeng.weeklyweather.mvp.bean;

import java.util.List;

/**
 * Created by mengdroid on 2018/2/11.
 */

public class SunRiseSet {

    private List<SunRiseSet.HeWeather6Bean> HeWeather6;

    public void setHeWeather6(List<SunRiseSet.HeWeather6Bean> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public List<SunRiseSet.HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    public static class HeWeather6Bean {

        private BasicBean basic;
        private String status;
        private UpdateBean update;
        private List<SunRiseSet.HeWeather6Bean.SunriseSunsetBean> sunriseSunset;

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public void setSunriseSunset(List<SunRiseSet.HeWeather6Bean.SunriseSunsetBean> sunriseSunset) {
            this.sunriseSunset = sunriseSunset;
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

        public List<SunRiseSet.HeWeather6Bean.SunriseSunsetBean> getSunriseSunset() {
            return sunriseSunset;
        }

    public static class SunriseSunsetBean{

            private String date;
            private String sr;
            private String ss;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getSr() {
            return sr;
        }

        public void setSr(String sr) {
            this.sr = sr;
        }

        public String getSs() {
            return ss;
        }

        public void setSs(String ss) {
            this.ss = ss;
        }
    }

    }
}
