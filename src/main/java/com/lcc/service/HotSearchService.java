package com.lcc.service;

import com.lcc.model.HotSearch;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2016/12/25.
 */
public interface HotSearchService {
    List<HotSearch> getHotSearchs(Map<String,Object> paramMap);

    int setNot2Display(Map<String, Object> paramMap);

    int set2Display(Map<String, Object> paramMap);

    int deleteHotSearchs(Map<String, Object> paramMap);

    int insert(HotSearch hotSearch);

    int update(HotSearch hotSearch);

}
