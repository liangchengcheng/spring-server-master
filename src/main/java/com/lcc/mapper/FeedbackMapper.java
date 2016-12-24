package com.lcc.mapper;

import com.lcc.model.Feedback;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2016/12/24.
 */
public interface FeedbackMapper {
    int insert(Feedback record);

    int insertSelective(Feedback record);

    List<Feedback> getFeedbacks(Map<String, Object> paramMap);
}
