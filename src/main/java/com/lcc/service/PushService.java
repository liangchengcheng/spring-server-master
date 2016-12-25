package com.lcc.service;

/**
 * Created by lcc on 2016/12/25.
 */
public interface PushService {

    void sendPush(String phone, String message, Integer count);

    void sendPushByTag(String tag, String string, int j);
}
