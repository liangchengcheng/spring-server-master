package com.lcc.model;

/**
 * Created by lcc on 2016/12/24.
 */
public class FoodWithSales {
    private Long foodId;
    private String foodName;
    private Integer sales;
    public Long getFoodId() {
        return foodId;
    }
    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }
    public String getFoodName() {
        return foodName;
    }
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public Integer getSales() {
        return sales;
    }
    public void setSales(Integer sales) {
        this.sales = sales;
    }

}
