package com.lcc.serviceimpl;

import java.util.List;
import java.util.Map;

import com.lcc.mapper.PreferentialMapper;
import com.lcc.model.Preferential;
import com.lcc.service.PreferentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("preferentialService")
public class PreferentialServiceImpl implements PreferentialService {
    @Autowired
    private PreferentialMapper preferentialMapper;

    public int deleteByPrimaryKey(Integer preferentialId) {
        return preferentialMapper.deleteByPrimaryKey(preferentialId);
    }

    public int insert(Preferential record) {
        return preferentialMapper.insert(record);
    }

    public int insertSelective(Preferential record) {
        return preferentialMapper.insert(record);
    }

    public Preferential selectByPrimaryKey(Integer preferentialId) {
        return preferentialMapper.selectByPrimaryKey(preferentialId);
    }

    public int updateByPrimaryKeySelective(Preferential record) {
        return preferentialMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Preferential record) {
        return preferentialMapper.updateByPrimaryKey(record);
    }

    public List<Preferential> getPreferential(Map<String, Object> paramMap) {
        return preferentialMapper.getPreferential(paramMap);
    }

}
