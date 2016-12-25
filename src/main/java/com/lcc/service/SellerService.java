package com.lcc.service;

import com.lcc.model.Sellers;

import java.util.Date;

/**
 * Created by lcc on 2016/12/25.
 */
public interface SellerService {
    public Sellers selectByCampusAdmin(String campusAdmin);

    public void updateLastLoginTime(Date date, String campusAdmin);

    public void addASeller(Sellers seller);
}
