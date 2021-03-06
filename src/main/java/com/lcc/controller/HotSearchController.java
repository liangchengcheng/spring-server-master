package com.lcc.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.lcc.model.HotSearch;
import com.lcc.service.HotSearchService;
import com.lcc.tools.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hotSearch")
public class HotSearchController {
    @Resource
    private HotSearchService hotSearchService;

    /**
     * 获取所有的热门搜索标签
     *
     * @param campusId 校区id
     */
    @RequestMapping("/getHotSearchs")
    @ResponseBody
    public List<HotSearch> getHotSearchs(@RequestParam Integer campusId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("campusId", campusId);
        List<HotSearch> searchs = hotSearchService.getHotSearchs(paramMap);
        return searchs;
    }

    /**
     * 将标签设为不显示
     *
     * @param hotId 搜索标签id
     */
    @RequestMapping("/setNot2Display")
    @ResponseBody
    public Map<String, Object> setNot2Display(@RequestParam Integer hotId) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            //paramMap.put("campusId",campusId);
            paramMap.put("hotId", hotId);
            int flag = hotSearchService.setNot2Display(paramMap);

            if (flag != -1) {
                resultMap.put(Constants.STATUS, Constants.SUCCESS);
                resultMap.put(Constants.MESSAGE, "修改成功");
            } else {
                resultMap.put(Constants.STATUS, Constants.FAILURE);
                resultMap.put(Constants.MESSAGE, "修改失败");
            }
        } catch (Exception e) {
            resultMap.put(Constants.STATUS, Constants.FAILURE);
            resultMap.put(Constants.MESSAGE, "修改失败");
        }

        return resultMap;
    }

    /**
     * 将标签设为显示
     */
    @RequestMapping("/set2Display")
    @ResponseBody
    public Map<String, Object> set2Display(@RequestParam Integer hotId) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            //paramMap.put("campusId",campusId);
            paramMap.put("hotId", hotId);
            int flag = hotSearchService.set2Display(paramMap);
            if (flag != -1) {
                resultMap.put(Constants.STATUS, Constants.SUCCESS);
                resultMap.put(Constants.MESSAGE, "修改成功");
            } else {
                resultMap.put(Constants.STATUS, Constants.FAILURE);
                resultMap.put(Constants.MESSAGE, "修改失败");
            }
        } catch (Exception e) {
            resultMap.put(Constants.STATUS, Constants.FAILURE);
            resultMap.put(Constants.MESSAGE, "修改失败");
        }

        return resultMap;
    }

    /**
     * 删除标签
     */
    @RequestMapping("/deleteHotSearchs")
    @ResponseBody
    public Map<String, Object> deleteHotSearchs(@RequestParam String hotIds) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();

            String[] hotIdsStrings = hotIds.split(",");
            paramMap.put("hotIds", hotIdsStrings);
            int flag = hotSearchService.deleteHotSearchs(paramMap);
            if (flag != -1) {
                resultMap.put(Constants.STATUS, Constants.SUCCESS);
                resultMap.put(Constants.MESSAGE, "修改成功");
            } else {
                resultMap.put(Constants.STATUS, Constants.FAILURE);
                resultMap.put(Constants.MESSAGE, "修改失败");
            }
        } catch (Exception e) {
            e.getStackTrace();
            resultMap.put(Constants.STATUS, Constants.FAILURE);
            resultMap.put(Constants.MESSAGE, "修改失败");
        }

        return resultMap;
    }

    @RequestMapping("/updateHotSearch")
    @ResponseBody
    public Map<String, Object> updateHotSearch(Integer hotId, String displayName, Integer campusId, String searchTag) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        try {
            HotSearch hotSearch = new HotSearch();
            hotSearch.setSearchTag(searchTag);
            hotSearch.setDisplayName(displayName);

            int flag = -1;
            if (hotId == 0 || hotId == null) {
                //新增
                hotSearch.setCampusId(campusId);
                hotSearch.setCreateTime(new Date().getTime());
                flag = hotSearchService.insert(hotSearch); //添加
            } else {
                hotSearch.setHotId(hotId);
                flag = hotSearchService.update(hotSearch);  //更新
            }

            if (flag != -1) {
                resultMap.put(Constants.STATUS, Constants.SUCCESS);
                resultMap.put(Constants.MESSAGE, "修改成功");
            } else {
                resultMap.put(Constants.STATUS, Constants.FAILURE);
                resultMap.put(Constants.MESSAGE, "修改失败");
            }
        } catch (Exception e) {
            e.getStackTrace();
            resultMap.put(Constants.STATUS, Constants.FAILURE);
            resultMap.put(Constants.MESSAGE, "修改失败");
        }

        return resultMap;
    }
}
