package com.lcc.mapper;

import com.lcc.model.FoodSpecial;
import com.lcc.model.FoodSpecialKey;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2016/12/24.
 */
public interface FoodSpecialMapper {
    int deleteByPrimaryKey(FoodSpecialKey key);

    int insert(FoodSpecial record);

    int insertSelective(FoodSpecial record);

    FoodSpecial selectByPrimaryKey(FoodSpecialKey key);

    int updateByPrimaryKeySelective(FoodSpecial record);

    int updateByPrimaryKey(FoodSpecial record);

    List<FoodSpecial> getFoodSpecialByFoodId(Map<String, Object> paramMap);

    String getSpecialName(Map<String, Object> paramMap);

    int addFoodSpecial(FoodSpecial foodSpecial);

    int getSpecialCount(Map<String, Object> paramMap);

    Integer getSpecialMax(Map<String, Object> paramMap);

    int changeFoodCount(Map<String, Object> paramMap);

    Integer getFoodSpecialCount(Map<String, Object> paramMap);
}
