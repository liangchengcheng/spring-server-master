package com.lcc.mapper;

import com.lcc.model.Sellers;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by lcc on 2016/12/24.
 */
public interface SellerMapper {

    Sellers selectByCampusAdmin(String campusAdmin);

    void updateLastLoginTime(@Param(value="date")Date date, @Param(value="campusAdmin") String campusAdmin
    );

    int insertSellective(Sellers seller);
}
