package com.lcc.mapper;

import com.lcc.model.City;

/**
 * Created by lcc on 2016/12/24.
 */
public interface CityMapper {
    int deleteByPrimaryKey(Integer cityId);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer cityId);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}
