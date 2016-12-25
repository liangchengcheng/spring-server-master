package com.lcc.service;

import com.lcc.model.News;
import com.lcc.model.SmallNews;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2016/12/25.
 */
public interface NewsService {
    List<SmallNews> getSmallNews(Map<String,Object> map);

    News getNewsById(Long newsId);

    List<News> getPcAllNews(Map<String, Object> requestMap);

    Integer addNews(News news);

    int deleteById(String id);
}
