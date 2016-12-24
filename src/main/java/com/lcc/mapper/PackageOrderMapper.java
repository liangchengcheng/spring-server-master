package com.lcc.mapper;

import com.lcc.model.PackageOrder;

import java.util.Map;

/**
 * Created by lcc on 2016/12/24.
 */
public interface PackageOrderMapper {
    int deleteByPrimaryKey(String packageId);

    int insert(PackageOrder record);

    int insertSelective(PackageOrder record);

    PackageOrder selectByPrimaryKey(String packageId);

    int updateByPrimaryKeySelective(PackageOrder record);

    int updateByPrimaryKey(PackageOrder record);

    int setAdminPhone(Map<String, Object> paramMap);
}
