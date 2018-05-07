package com.menglingpeng.weeklyweather.mvp.bean;

import me.yokeyword.indexablerv.IndexableEntity;

/**
 * Created by mengdroid on 2018/5/7.
 */

public class CityEntity implements IndexableEntity{

    private long id;
    private String name;
    private String pinyin;

    public CityEntity() {
    }

    public CityEntity(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Override
    public String getFieldIndexBy() {
        return name;
    }

    @Override
    public void setFieldIndexBy(String indexByField) {
        this.name = indexByField;
    }

    /*
    保存排序field的拼音,在执行比如搜索等功能时有用 （若不需要，空实现该方法即可）
     */

    @Override
    public void setFieldPinyinIndexBy(String pinyin) {
        this.pinyin = pinyin;
    }
}
