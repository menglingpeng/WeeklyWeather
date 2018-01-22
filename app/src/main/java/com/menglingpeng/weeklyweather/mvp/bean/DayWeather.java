package com.menglingpeng.weeklyweather.mvp.bean;

import java.util.List;

/**
 * Created by mengdroid on 2018/1/22.
 */

public class DayWeather {

    private DataBean data;
    private int status;
    private String message;

    public void setData(DataBean data) {
        this.data = data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public static class DataBean {

        private YesterdayBean yesterday;
        private String city;
        private String aqi;
        private String ganmao;
        private String wendu;
        private List<ForecastBean> forecast;

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public String getCity() {
            return city;
        }

        public String getAqi() {
            return aqi;
        }

        public String getGanmao() {
            return ganmao;
        }

        public String getWendu() {
            return wendu;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public static class YesterdayBean {

            private String date;
            private String high;
            private String fx;
            private String low;
            private String fl;
            private String type;

            public void setDate(String date) {
                this.date = date;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getDate() {
                return date;
            }

            public String getHigh() {
                return high;
            }

            public String getFx() {
                return fx;
            }

            public String getLow() {
                return low;
            }

            public String getFl() {
                return fl;
            }

            public String getType() {
                return type;
            }
        }

        public static class ForecastBean {

            private String date;
            private String high;
            private String fengli;
            private String low;
            private String fengxiang;
            private String type;

            public void setDate(String date) {
                this.date = date;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getDate() {
                return date;
            }

            public String getHigh() {
                return high;
            }

            public String getFengli() {
                return fengli;
            }

            public String getLow() {
                return low;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public String getType() {
                return type;
            }
        }
    }
}
