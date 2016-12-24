package com.lcc.model;

/**
 * Created by lcc on 2016/12/24.
 */
public class DeliverCom {
    private Integer deliverId;

    private String category;

    public Integer getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(Integer deliverId) {
        this.deliverId = deliverId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }
}
