package com.lcc.model;

/**
 * Created by lcc on 2016/12/24.
 */
public class City {
    protected Integer cityId;

    protected String cityName;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }
}
