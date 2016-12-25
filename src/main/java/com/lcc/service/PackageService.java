package com.lcc.service;

import com.lcc.model.DeliverCom;
import com.lcc.model.PackageOrder;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2016/12/25.
 */
public interface PackageService {
    List<DeliverCom> getDeliverCom(Map<String, Object> paramMap);

    int insert(PackageOrder packageOrder);

    int setPackageAdmin(Map<String, Object> paramMap);
}
