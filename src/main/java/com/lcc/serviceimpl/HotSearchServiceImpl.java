package com.lcc.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.lcc.mapper.HotSearchMapper;
import com.lcc.model.HotSearch;
import com.lcc.service.HotSearchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2016/12/25.
 */
@Service("/hotSearchService")
public class HotSearchServiceImpl implements HotSearchService {
    @Resource
    private HotSearchMapper hotSearchMapper;

    public List<HotSearch> getHotSearchs(Map<String,Object> paramMap) {
        return hotSearchMapper.getHotSearchs(paramMap);
    }

    public int setNot2Display(Map<String, Object> paramMap) {
        return hotSearchMapper.setNot2Display(paramMap);
    }

    public int set2Display(Map<String, Object> paramMap) {
        return hotSearchMapper.set2Dispaly(paramMap);
    }

    public int deleteHotSearchs(Map<String, Object> paramMap) {
        String[] hotIdsStrings=(String[])paramMap.get("hotIds");

        int flag=-1;
        System.out.println(JSON.toJSONString(hotIdsStrings));
        for (String id : hotIdsStrings) {
            flag=hotSearchMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
        return flag;
    }

    public int insert(HotSearch hotSearch) {
        return hotSearchMapper.insertSelective(hotSearch);
    }

    public int update(HotSearch hotSearch) {
        return hotSearchMapper.updateByPrimaryKeySelective(hotSearch);
    }

}
