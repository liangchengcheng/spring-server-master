package com.lcc.service;

import com.lcc.model.Receiver;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2016/12/25.
 */
public interface ReceiverService {

    int deleteByPrimaryKey(String phoneId,String rank);

    int insertSelective(Receiver record);

    Receiver selectByPrimaryKey(String phoneId,String rank);

    int updateByPrimaryKeySelective(Receiver record);

    int setDefaultAddress(String phone,String rank);

    int getReceiverCounts(String phoneId);

    List<Receiver> selectByPhoneId(String phoneId);

    int insert(Receiver receiver);

    int setRecevierTag(String phoneId);

    Receiver getReceiver(Map<String, Object> paramMap);
}
