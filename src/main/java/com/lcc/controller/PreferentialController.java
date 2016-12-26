package com.lcc.controller;

import com.lcc.model.Preferential;
import com.lcc.service.CampusService;
import com.lcc.service.PreferentialService;
import com.lcc.tools.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 满减优惠
 * Created by lcc on 2016/12/26.
 */
@Controller
@RequestMapping("preferential")
public class PreferentialController {
    @Resource(name="preferentialService")
    private PreferentialService preferentialService;

    @Resource(name="campusService")
    private CampusService campusService;

    /**
     * 添加满减优惠
     */
    @RequestMapping("addPref")
    @ResponseBody
    public Map<String, Object> addPref(@RequestParam Integer needNumber, @RequestParam Integer discountNum,
                                       Integer campusId, String campusName){
        Map<String, Object> map = new HashMap<String, Object>();
        Preferential preferential =new Preferential();
        preferential.setPreferentialId(null);
        preferential.setNeedNumber(needNumber);
        preferential.setDiscountNum(discountNum);
        if(campusId==null){
            Map<String, Object> tempMap = new HashMap<String, Object>();
            tempMap.put("campusName", campusName);
            preferential.setCampusId(campusService.getIdByName(tempMap));
        }else{
            preferential.setCampusId(campusId);
        }

        int flag = preferentialService.insert(preferential);
        if(flag!=0&&flag!=-1){
            map.put(Constants.STATUS, Constants.SUCCESS);
            map.put(Constants.MESSAGE, "添加成功");
        }else{
            map.put(Constants.STATUS, Constants.FAILURE);
            map.put(Constants.MESSAGE, "添加失败");
        }
        return map;
    }


}
