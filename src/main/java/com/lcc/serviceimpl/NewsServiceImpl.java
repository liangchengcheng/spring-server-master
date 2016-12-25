package com.lcc.serviceimpl;

import com.lcc.mapper.NewsMapper;
import com.lcc.model.News;
import com.lcc.model.SmallNews;
import com.lcc.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2016/12/25.
 */
@Service("/newsService")
public class NewsServiceImpl implements NewsService {
    private NewsMapper newsMapper;

    public NewsMapper getNewsMapper() {
        return newsMapper;
    }

    @Autowired
    public void setNewsMapper(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    public List<SmallNews> getSmallNews(Map<String,Object> map) {
        return newsMapper.getSmallNews(map);
    }

    public News getNewsById(Long newsId) {
        return newsMapper.selectByPrimaryKey(newsId);
    }

    public List<News> getPcAllNews(Map<String, Object> requestMap) {
        return newsMapper.getPcAllNews(requestMap);
    }

    public Integer addNews(News news) {
        return newsMapper.insert(news);
    }

    public int deleteById(String id) {
        return newsMapper.deleteByPrimaryKey(Long.valueOf(id));
    }
}
