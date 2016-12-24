package com.lcc.mapper;

import com.lcc.model.PushMessage;

/**
 * Created by lcc on 2016/12/24.
 */
public interface PushMessageMapper {
    int deleteByPrimaryKey(Integer pushId);

    int insert(PushMessage record);

    int insertSelective(PushMessage record);

    PushMessage selectByPrimaryKey(Integer pushId);

    int updateByPrimaryKeySelective(PushMessage record);

    int updateByPrimaryKey(PushMessage record);
}
