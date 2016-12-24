package com.lcc.model;

/**
 * Created by lcc on 2016/12/24.
 */
public class MiniOrder {
    private Short status;
    private Integer orderCount;
    public Short getStatus() {
        return status;
    }
    public void setStatus(Short status) {
        this.status = status;
    }
    public Integer getOrderCount() {
        return orderCount;
    }
    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }
}
