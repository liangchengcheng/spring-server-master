package com.lcc.model;

/**
 * Created by lcc on 2016/12/24.
 */
public class Preferential {
    private Integer preferentialId;

    private Integer needNumber;

    private Integer discountNum;

    private Integer campusId;

    public Integer getCampusId() {
        return campusId;
    }

    public void setCampusId(Integer campusId) {
        this.campusId = campusId;
    }

    public Integer getPreferentialId() {
        return preferentialId;
    }

    public void setPreferentialId(Integer preferentialId) {
        this.preferentialId = preferentialId;
    }

    public Integer getNeedNumber() {
        return needNumber;
    }

    public void setNeedNumber(Integer needNumber) {
        this.needNumber = needNumber;
    }

    public Integer getDiscountNum() {
        return discountNum;
    }

    public void setDiscountNum(Integer discountNum) {
        this.discountNum = discountNum;
    }

}
