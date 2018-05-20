package com.menglingpeng.weeklyweather.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mengdroid on 2018/5/20.
 */

public class AirBarDataEntity implements Serializable {
    private List<Type> typeList;

    public List<Type> getTypeList() {
        return typeList;
    }

    public static class Type implements Serializable {
        private String typeName;//类型名称
        private int value;//空气质量指数
       private int type;//空气质量等级

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public List<Type> parseData(){
        typeList = new ArrayList<>();
        Random r = new Random();
        int all=0;
        for (int i= 0;i<=6;i++){
            Type type = new Type();
            type.setValue(r.nextInt(100));
            type.setTypeName("品类" + i);
            typeList.add(type);
        }
        for (int i= 0;i<=6;i++){
            all+= typeList.get(i).getValue();
        }
        for (int i= 0;i<=6;i++){
            double type = (double) typeList.get(i).getValue()/all;
            typeList.get(i).setType(type);
            System.out.println("==>"+typeList.get(i).getType());
        }
        return typeList;
    }
}
