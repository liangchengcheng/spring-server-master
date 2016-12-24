package com.lcc.mapper;

import com.lcc.model.AppKey;

import java.util.Map;

/**
 * Created by lcc on 2016/12/24.
 */
public interface AppKeyMapper {
    int insert(AppKey record);

    int insertSelective(AppKey record);

    //搜索
    String SelectKey(Map<String, Object> paramMap);
}
