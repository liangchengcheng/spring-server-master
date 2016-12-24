package com.lcc.mapper;

import com.lcc.model.FoodCategory;
import com.lcc.model.HomeCategory;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2016/12/24.
 */
public interface FoodCategoryMapper {
    int deleteByPrimaryKey(Map<String, Object> paramMap);

    int insert(FoodCategory record);

    int insertSelective(FoodCategory record);

    FoodCategory selectByPrimaryKey(Map<String, Object> paramMap);

    int updateByPrimaryKeySelective(FoodCategory record);

    int updateByPrimaryKey(FoodCategory record);

    List<FoodCategory> getFirstCategory(Map<String, Object> paramMap);

    //List<FoodCategory> getSecondCategoryes(@Param(value="categoryId")Integer id);

    List<FoodCategory> getAllFoodSecondCategories();

    List<FoodCategory> getAllFoodFirstCategories();

    List<HomeCategory> getHomeCategoryInfo(Map<String, Object> paramMap);

    List<FoodCategory> getAllFoodCategories(Map<String, Object> paramMap);

    int getAllCategoryCount();

    Integer addCategoryWhenAddCampus(Map<String, Object> paramMap);
}
