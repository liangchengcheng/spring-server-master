package com.lcc.mapper;

import com.lcc.model.DeliverCom;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2016/12/24.
 */
public interface DeliverComMapper {
    int deleteByPrimaryKey(Integer deliverId);

    int insert(DeliverCom record);

    int insertSelective(DeliverCom record);

    DeliverCom selectByPrimaryKey(Integer deliverId);

    int updateByPrimaryKeySelective(DeliverCom record);

    int updateByPrimaryKey(DeliverCom record);

    List<DeliverCom> getDeliverCom(Map<String, Object> paramMap);
}
