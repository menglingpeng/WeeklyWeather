package com.menglingpeng.weeklyweather.mvp.bean;

import java.util.List;

/**
 * Created by mengdroid on 2018/2/5.
 */

public class LifeIndex {

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
        private List<LifestyleBean> lifestyle;

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public void setLifestyle(List<LifestyleBean> lifestyle) {
            this.lifestyle = lifestyle;
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

        public List<LifestyleBean> getLifestyle() {
            return lifestyle;
        }

        public static class LifestyleBean {

            private String brf;
            private String txt;
            private String type;

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getBrf() {
                return brf;
            }

            public String getTxt() {
                return txt;
            }

            public String getType() {
                return type;
            }
        }
    }
}
