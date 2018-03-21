package com.menglingpeng.weeklyweather.mvp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mengdroid on 2018/3/19.
 */

public class AirQualityCollection implements Serializable {

    private List<AirQualityCollection.HeWeather6Bean> HeWeather6;

    public void setHeWeather6(List<AirQualityCollection.HeWeather6Bean> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public List<AirQualityCollection.HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    public static class HeWeather6Bean {

        private BasicBean basic;
        private String status;
        private UpdateBean update;
        private List<AirQualityCollection.HeWeather6Bean.AirHourlyBean> airHourlyBeans;
        private List<AirQualityCollection.HeWeather6Bean.AirForecastBean> airForecastBeans;
        private List<AirQualityCollection.HeWeather6Bean.AirNowCityBean> airNowCityBeans;

        public void setBasic(BasicBean basic) {
            this.basic = basic;
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

        public String getStatus() {
            return status;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public List<AirQualityCollection.HeWeather6Bean.AirHourlyBean> getAirHourlyBeans() {
            return airHourlyBeans;
        }

        public void setAirHourlyBeans(List<AirQualityCollection.HeWeather6Bean.AirHourlyBean> airHourlyBeans) {
            this.airHourlyBeans = airHourlyBeans;
        }

        public List<AirForecastBean> getAirForecastBeans() {
            return airForecastBeans;
        }

        public void setAirForecastBeans(List<AirForecastBean> airForecastBeans) {
            this.airForecastBeans = airForecastBeans;
        }

        public List<AirNowCityBean> getAirNowCityBeans() {
            return airNowCityBeans;
        }

        public void setAirNowCityBeans(List<AirNowCityBean> airNowCityBeans) {
            this.airNowCityBeans = airNowCityBeans;
        }

        public static class AirHourlyBean{

            private String aqi;
            private String co;
            private String main;
            private String no2;
            private String o3;
            private String pm10;
            private String pm25;
            private String pub_time;
            private String qlty;
            private String so2;

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public void setCo(String co) {
                this.co = co;
            }

            public void setMain(String main) {
                this.main = main;
            }

            public void setNo2(String no2) {
                this.no2 = no2;
            }

            public void setO3(String o3) {
                this.o3 = o3;
            }

            public void setPm10(String pm10) {
                this.pm10 = pm10;
            }

            public void setPm25(String pm25) {
                this.pm25 = pm25;
            }

            public void setPub_time(String pub_time) {
                this.pub_time = pub_time;
            }

            public void setQlty(String qlty) {
                this.qlty = qlty;
            }

            public void setSo2(String so2) {
                this.so2 = so2;
            }

            public String getAqi() {
                return aqi;
            }

            public String getCo() {
                return co;
            }

            public String getMain() {
                return main;
            }

            public String getNo2() {
                return no2;
            }

            public String getO3() {
                return o3;
            }

            public String getPm10() {
                return pm10;
            }

            public String getPm25() {
                return pm25;
            }

            public String getPub_time() {
                return pub_time;
            }

            public String getQlty() {
                return qlty;
            }

            public String getSo2() {
                return so2;
            }
        }


        public static class AirNowCityBean {

            private String aqi;
            private String co;
            private String main;
            private String no2;
            private String o3;
            private String pm10;
            private String pm25;
            private String pub_time;
            private String qlty;
            private String so2;

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public void setCo(String co) {
                this.co = co;
            }

            public void setMain(String main) {
                this.main = main;
            }

            public void setNo2(String no2) {
                this.no2 = no2;
            }

            public void setO3(String o3) {
                this.o3 = o3;
            }

            public void setPm10(String pm10) {
                this.pm10 = pm10;
            }

            public void setPm25(String pm25) {
                this.pm25 = pm25;
            }

            public void setPub_time(String pub_time) {
                this.pub_time = pub_time;
            }

            public void setQlty(String qlty) {
                this.qlty = qlty;
            }

            public void setSo2(String so2) {
                this.so2 = so2;
            }

            public String getAqi() {
                return aqi;
            }

            public String getCo() {
                return co;
            }

            public String getMain() {
                return main;
            }

            public String getNo2() {
                return no2;
            }

            public String getO3() {
                return o3;
            }

            public String getPm10() {
                return pm10;
            }

            public String getPm25() {
                return pm25;
            }

            public String getPub_time() {
                return pub_time;
            }

            public String getQlty() {
                return qlty;
            }

            public String getSo2() {
                return so2;
            }
        }

        public static class AirNowStationBean {

            private String air_sta;
            private String aqi;
            private String asid;
            private String co;
            private String lat;
            private String lon;
            private String main;
            private String no2;
            private String o3;
            private String pm10;
            private String pm25;
            private String pub_time;
            private String qlty;
            private String so2;

            public void setAir_sta(String air_sta) {
                this.air_sta = air_sta;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public void setAsid(String asid) {
                this.asid = asid;
            }

            public void setCo(String co) {
                this.co = co;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public void setMain(String main) {
                this.main = main;
            }

            public void setNo2(String no2) {
                this.no2 = no2;
            }

            public void setO3(String o3) {
                this.o3 = o3;
            }

            public void setPm10(String pm10) {
                this.pm10 = pm10;
            }

            public void setPm25(String pm25) {
                this.pm25 = pm25;
            }

            public void setPub_time(String pub_time) {
                this.pub_time = pub_time;
            }

            public void setQlty(String qlty) {
                this.qlty = qlty;
            }

            public void setSo2(String so2) {
                this.so2 = so2;
            }

            public String getAir_sta() {
                return air_sta;
            }

            public String getAqi() {
                return aqi;
            }

            public String getAsid() {
                return asid;
            }

            public String getCo() {
                return co;
            }

            public String getLat() {
                return lat;
            }

            public String getLon() {
                return lon;
            }

            public String getMain() {
                return main;
            }

            public String getNo2() {
                return no2;
            }

            public String getO3() {
                return o3;
            }

            public String getPm10() {
                return pm10;
            }

            public String getPm25() {
                return pm25;
            }

            public String getPub_time() {
                return pub_time;
            }

            public String getQlty() {
                return qlty;
            }

            public String getSo2() {
                return so2;
            }
        }

        public static class AirForecastBean{

            private String aqi;
            private String co;
            private String main;
            private String no2;
            private String o3;
            private String pm10;
            private String pm25;
            private String pub_time;
            private String qlty;
            private String so2;

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public void setCo(String co) {
                this.co = co;
            }

            public void setMain(String main) {
                this.main = main;
            }

            public void setNo2(String no2) {
                this.no2 = no2;
            }

            public void setO3(String o3) {
                this.o3 = o3;
            }

            public void setPm10(String pm10) {
                this.pm10 = pm10;
            }

            public void setPm25(String pm25) {
                this.pm25 = pm25;
            }

            public void setPub_time(String pub_time) {
                this.pub_time = pub_time;
            }

            public void setQlty(String qlty) {
                this.qlty = qlty;
            }

            public void setSo2(String so2) {
                this.so2 = so2;
            }

            public String getAqi() {
                return aqi;
            }

            public String getCo() {
                return co;
            }

            public String getMain() {
                return main;
            }

            public String getNo2() {
                return no2;
            }

            public String getO3() {
                return o3;
            }

            public String getPm10() {
                return pm10;
            }

            public String getPm25() {
                return pm25;
            }

            public String getPub_time() {
                return pub_time;
            }

            public String getQlty() {
                return qlty;
            }

            public String getSo2() {
                return so2;
            }
        }
    }



}
