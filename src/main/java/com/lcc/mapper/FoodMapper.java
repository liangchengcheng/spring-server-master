package com.lcc.mapper;

import com.lcc.model.*;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2016/12/24.
 */
public interface FoodMapper {
    int deleteByPrimaryKey(Map<String, Object> paramMap);

    int insert(Food record);

    int insertSelective(Food record);

    Food selectByPrimaryKey(Map<String, Object> paramMap);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);

    List<Food> getAllFoods(Map<String, Object> paramMap);        //web管理端获取所有的食品

    List<ShortFood> getFoodListDiscount(Map<String, Object> paramMap);   //获取打折商品

    List<ShortFood> getFoodListFresh(Map<String, Object> paramMap);      //获取新品食品

    List<ShortFood> getFoodListWelcome(Map<String, Object> paramMap);   //获取受欢迎商品


    List<ShortFoodWithIm> selectFoods(Map<String, Object> paramMap);

    List<ShortFoodWithIm> selectFoodsByTwoTags(Map<String, Object> paramMap);

    int changeFoodNumber(Map<String, Object> paramMap);   //更新销量和减少库存

    List<VeryShortFood> selectHomeFood(Map<String, Object> paramMap);

    Integer uploadHomeFoodByFoodId(Map<String, Object> paramMap);//上传推送到首页的食品大图

    Integer updateInfoByFoodId(Map<String, Object> paramMap);//更新食品详情图片

    Integer cancelRecommend(Map<String, Object> paramMap);//取消推荐

    List<FoodWithSales> getTopFive(Map<String, Object> paramMap);

    Integer addFoodCountById(Map<String, Object> paramMap);//添加库存

    Integer addFoodCount(Map<String, Object> paramMap);

    String getFoodHomeImage(Map<String, Object> paramMap);

    String getDetailImg(Map<String, Object> paramMap);   //获取食品详情图片
}
