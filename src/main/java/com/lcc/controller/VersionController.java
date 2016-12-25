package com.lcc.controller;

import com.lcc.tools.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lcc on 2016/12/25.
 */
@Controller
@RequestMapping("/version")
public class VersionController {

    @RequestMapping("/updateVersion")
    public @ResponseBody Map<String, Object> updateVersion(){
        Map<String, Object> map = new HashMap<String, Object>();
        return map;
    }

    @RequestMapping("/getVersion")
    public @ResponseBody Map<String, Object> getVersion(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ios_version", "1.0.1");
        map.put("android_version", "1.1.0");
        map.put(Constants.STATUS, Constants.SUCCESS);
        map.put(Constants.MESSAGE, "获取版本号成功");
        return map;
    }

}
