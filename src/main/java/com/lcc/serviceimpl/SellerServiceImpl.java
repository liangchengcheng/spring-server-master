package com.lcc.serviceimpl;

import com.lcc.mapper.SellerMapper;
import com.lcc.model.Sellers;
import com.lcc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by lcc on 2016/12/25.
 */
@Service("sellerService")
public class SellerServiceImpl implements SellerService {
    //操作用户的信息
    private SellerMapper sellerMapper;

    @Autowired
    public void setSellerMapper(SellerMapper sellerMapper) {
        this.sellerMapper = sellerMapper;
    }

    public Sellers selectByCampusAdmin(String campusAdmin) {
        return sellerMapper.selectByCampusAdmin(campusAdmin);
    }

    public void updateLastLoginTime(Date date, String campusAdmin) {
        sellerMapper.updateLastLoginTime(date, campusAdmin);

    }

    public void addASeller(Sellers seller) {
        sellerMapper.insertSellective(seller);
    }


}
