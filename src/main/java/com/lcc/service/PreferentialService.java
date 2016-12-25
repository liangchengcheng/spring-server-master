package com.lcc.service;

import com.lcc.model.Preferential;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2016/12/25.
 */
public interface PreferentialService {

    int deleteByPrimaryKey(Integer preferentialId);

    int insert(Preferential record);

    int insertSelective(Preferential record);

    Preferential selectByPrimaryKey(Integer preferentialId);

    int updateByPrimaryKeySelective(Preferential record);

    int updateByPrimaryKey(Preferential record);

    List<Preferential> getPreferential(Map<String, Object> paramMap);
}
