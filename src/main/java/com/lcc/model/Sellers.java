package com.lcc.model;

import java.util.Date;

/**
 * Created by lcc on 2016/12/24.
 */
public class Sellers {
    private String campusAdmin;

    private String password;

    private Short type;

    private Integer campusId;

    private Date lastLoginDate;

    public String getCampusAdmin() {
        return campusAdmin;
    }

    public void setCampusAdmin(String campusAdmin) {
        this.campusAdmin = campusAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Integer getCampusId() {
        return campusId;
    }

    public void setCampusId(Integer campusId) {
        this.campusId = campusId;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
