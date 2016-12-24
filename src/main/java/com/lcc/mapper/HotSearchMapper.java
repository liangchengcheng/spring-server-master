package com.lcc.mapper;

import com.lcc.model.HotSearch;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2016/12/24.
 */
public interface HotSearchMapper {
    int deleteByPrimaryKey(Integer hotId);

    int insert(HotSearch record);

    int insertSelective(HotSearch record);

    HotSearch selectByPrimaryKey(Integer hotId);

    int updateByPrimaryKeySelective(HotSearch record);

    int updateByPrimaryKey(HotSearch record);

    List<HotSearch> getHotSearchs(Map<String, Object> paramMap);  //获取校区的所有热搜标签

    int setNot2Display(Map<String, Object> paramMap);           //将标签拿下来

    int set2Dispaly(Map<String, Object> paramMap);             //显示标签

}
