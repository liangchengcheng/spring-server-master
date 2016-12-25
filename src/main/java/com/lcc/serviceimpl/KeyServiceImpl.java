package com.lcc.serviceimpl;

import com.lcc.mapper.AppKeyMapper;
import com.lcc.service.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by lcc on 2016/12/25.
 */
@Service("keyService")
public class KeyServiceImpl implements KeyService {
    private AppKeyMapper keyMapper;

    @Autowired
    public void setKeyMapper(AppKeyMapper keyMapper) {
        this.keyMapper = keyMapper;
    }

    public String SelectKey(Map<String, Object> paramMap) {
        return keyMapper.SelectKey(paramMap);
    }
}
