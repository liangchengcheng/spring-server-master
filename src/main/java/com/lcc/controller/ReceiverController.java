package com.lcc.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lcc.model.Receiver;
import com.lcc.service.OrderService;
import com.lcc.service.ReceiverService;
import com.lcc.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;

/**
 * 这是收货人的控制器，主要处理收货人的信息
 */
@Controller
@RequestMapping("/receiver")
public class ReceiverController {
    private ReceiverService receiverService;
    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public ReceiverService getReceiverService() {
        return receiverService;
    }

    @Autowired
    public void setReceiverService(ReceiverService receiverService) {
        this.receiverService = receiverService;
    }


    /**
     * 添加收貨人信息
     *
     * @param phoneId  用戶手机，id
     * @param phone    收货人手机号
     * @param name     收货人名字
     * @param address  收货人地址
     * @param campusId 校区号
     */
    @RequestMapping("/addReceiver")
    @ResponseBody
    public Map<String, Object> addReceiver(@RequestParam String phoneId, @RequestParam String phone, @RequestParam String name,
                                           @RequestParam String address, @RequestParam Integer campusId) {
        Map<String, Object> map = new HashMap<String, Object>();
        Receiver receiver = new Receiver(phoneId, phone, name, address, campusId);
        try {
            //通过时间生成该记录的序列号，和phoneId一起唯一表志收货人信息
            Calendar calendar = Calendar.getInstance();
            receiver.setRank(String.valueOf(calendar.getTimeInMillis()));

            if (receiverService.getReceiverCounts(phoneId) != 0) {
                receiver.setTag((short) 1);
            } else {
                receiver.setTag((short) 0);
            }

            System.out.println(JSON.toJSONString(receiver));

            if (receiverService.insert(receiver) != -1) {
                map.put(Constants.STATUS, Constants.SUCCESS);
                map.put(Constants.MESSAGE, "添加成功！");
            } else {
                map.put(Constants.STATUS, Constants.FAILURE);
                map.put(Constants.MESSAGE, "添加失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Constants.STATUS, Constants.FAILURE);
            map.put(Constants.MESSAGE, "添加失败！");
        }

        return map;
    }


    /**
     * 根据用户id获取用户存下来的收货人信息
     */
    @RequestMapping("/selectReceiver")
    @ResponseBody
    public Map<String, Object> relectReceiver(@RequestParam String phoneId) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Receiver> receivers = receiverService.selectByPhoneId(phoneId);
            map.put("receivers", receivers);
            map.put(Constants.STATUS, Constants.SUCCESS);
            map.put(Constants.MESSAGE, "获取成功");
        } catch (Exception e) {
            e.getStackTrace();
            map.put(Constants.STATUS, Constants.FAILURE);
            map.put(Constants.MESSAGE, "获取失败！");
        }
        return map;
    }

    /**
     * 更改收货人信息
     *
     * @param phoneId  用户id
     * @param rank     收货人序列，主键
     * @param address  收货人地址
     * @param name     收货人姓名
     * @param phone    收货人手机号
     * @param campusId 校区
     */
    @RequestMapping("/updateReceiver")
    @ResponseBody
    public Map<String, Object> updateReceiver(@RequestParam String phoneId, @RequestParam String rank,
                                              String address, String name, String phone, Integer campusId) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Receiver receiver = new Receiver(phoneId, phone, name, address, campusId);
            receiver.setRank(rank);
            if (receiverService.updateByPrimaryKeySelective(receiver) != -1) {
                map.put(Constants.STATUS, Constants.SUCCESS);
                map.put(Constants.MESSAGE, "更新收货人信息成功");
            } else {
                map.put(Constants.STATUS, Constants.FAILURE);
                map.put(Constants.MESSAGE, "更新收货人信息失败");
            }
        } catch (Exception e) {
            e.getStackTrace();
            map.put(Constants.STATUS, Constants.FAILURE);
            map.put(Constants.MESSAGE, "更新收货人信息失败！");
        }
        return map;
    }

    /**
     * 设置默认收货地址
     *
     * @param phoneId 用户id
     * @param rank    收货人序列号
     */
    @RequestMapping("/setDefaultAddress")
    @ResponseBody
    public Map<String, Object> setDefaultAddress(@RequestParam String phoneId, @RequestParam String rank) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            //将原先的默认收货地址改成非默认
            receiverService.setRecevierTag(phoneId);
            //将新的地址改成默认收货地址
            if (receiverService.setDefaultAddress(phoneId, rank) != -1) {
                map.put(Constants.STATUS, Constants.SUCCESS);
                map.put(Constants.MESSAGE, "设置默认收货地址成功");
            } else {
                map.put(Constants.STATUS, Constants.FAILURE);
                map.put(Constants.MESSAGE, "设置默认收货地址失败");
            }
        } catch (Exception e) {
            e.getStackTrace();
            map.put(Constants.STATUS, Constants.FAILURE);
            map.put(Constants.MESSAGE, "设置默认收货地址失败！");
        }

        return map;
    }


    /**
     * 删除某个收货人地址
     */
    @RequestMapping("/deleteReceiver")
    @ResponseBody
    public Map<String, Object> deleteReceiver(@RequestParam String phoneId, @RequestParam String rank) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            int flag = receiverService.deleteByPrimaryKey(phoneId, rank);
            if (flag != -1 && flag != 0) {
                map.put(Constants.STATUS, Constants.SUCCESS);
                map.put(Constants.MESSAGE, "删除地址成功!");
            } else {
                map.put(Constants.STATUS, Constants.FAILURE);
                map.put(Constants.MESSAGE, "删除地址失败！");
            }
        } catch (Exception e) {
            e.getStackTrace();
            map.put(Constants.STATUS, Constants.FAILURE);
            map.put(Constants.MESSAGE, "删除地址失败！");
        }
        return map;
    }
}
