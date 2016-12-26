package com.lcc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lcc.model.Order;
import com.lcc.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lcc on 2016/12/27.
 */
@Controller
@RequestMapping("/pay")
public class PayController {
    private PayService payService;
    private OrderService orderService;
    private UserService userService;
    private PushService pushService;
    private FoodService foodService;

    private static final Logger LOGGER = Logger.getLogger(PayController.class);

    public PushService getPushService() {
        return pushService;
    }

    public void setPushService(PushService pushService) {
        this.pushService = pushService;
    }

    @Autowired
    public void setFoodService(FoodService foodService) {
        this.foodService = foodService;
    }

    public PayService getPayService() {
        return payService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setPayService(PayService payService) {
        this.payService = payService;
    }

    public void webHooksForPaySuccess(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        //获取头部信息
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.print(key + " " + value);
        }

        //获取body的内容
        BufferedReader reader = request.getReader();
        StringBuffer buffer = new StringBuffer();
        String str;
        while ((str = reader.readLine()) != null) {
            buffer.append(str);
        }
        reader.close();
        //解析异步通知数据

    }

    /**
     * 支付成功
     **/
    public int doPaySuccess(String buffer) {
        //Charge charge = (Charge)Webhooks.parseEvnet(buffer);
        new Thread(new Runnable() {
            //向超级管理员推送，让其分发订单
            public void run() {
                //推送
                //pushService.sendPushByTag("0","一笔新的订单已经到达，请前往选单中查看，并尽早分派配送员进行配送。For优。", 1);
                Map<String, Object> paramterMap = new HashMap<String, Object>();
                paramterMap.put("campusId", "  ");
                List<String> superPhones = userService.getAllSuperAdminPhone(paramterMap);
                for (String phone : superPhones) {
                    //推送
                    pushService.sendPush(phone, "一笔新的订单已经到达，请前往选单中查看，并尽早分派配送员进行配送。for优。", 1);
                }
            }
        }).start();
        return 1;
    }


}
