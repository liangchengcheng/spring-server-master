package com.lcc.model;

/**
 * Created by lcc on 2016/12/24.
 */
public class FoodSpecialKey {
    protected Long foodId;
    protected Integer campusId;

    protected Integer specialId;

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public Integer getSpecialId() {
        return specialId;
    }

    public void setSpecialId(Integer specialId) {
        this.specialId = specialId;
    }
}
