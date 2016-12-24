package com.lcc.mapper;

import com.lcc.model.News;
import com.lcc.model.SmallNews;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2016/12/24.
 */
public interface NewsMapper {
    int deleteByPrimaryKey(Long newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Long newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    List<SmallNews> getSmallNews(Map<String,Object> map);

    List<News> getPcAllNews(Map<String, Object> requestMap);
}
