package com.lcc.serviceimpl;

import com.lcc.mapper.ReceiverMapper;
import com.lcc.model.Receiver;
import com.lcc.model.ReceiverKey;
import com.lcc.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2016/12/25.
 */

@Service("receiverService")
public class ReceiverServiceImpl implements ReceiverService {
    private ReceiverMapper receiverMapper;

    public ReceiverMapper getReceiverMapper() {
        return receiverMapper;
    }

    @Autowired
    public void setReceiverMapper(ReceiverMapper receiverMapper) {
        this.receiverMapper = receiverMapper;
    }

    public int deleteByPrimaryKey(String phoneId, String rank) {
        return receiverMapper.deleteByPrimaryKey(new ReceiverKey(phoneId,rank));

    }

    public int insertSelective(Receiver record) {
        return receiverMapper.insertSelective(record);
    }

    public Receiver selectByPrimaryKey(String phoneId, String order) {
        return receiverMapper.selectByPrimaryKey(new ReceiverKey(phoneId,order));
    }

    public int updateByPrimaryKeySelective(Receiver record) {
        return receiverMapper.updateByPrimaryKeySelective(record);
    }

    public int setDefaultAddress(String phone,String rank) {
        return receiverMapper.setDefaultAddress(phone,rank);
    }

    public int getReceiverCounts(String phoneId) {

        return receiverMapper.getReceiverCounts(phoneId);
    }

    public List<Receiver> selectByPhoneId(String phoneId) {
        return receiverMapper.selectByPhoneId(phoneId);
    }

    public int insert(Receiver receiver) {
        return receiverMapper.insert(receiver);
    }

    public int setRecevierTag(String phoneId) {
        return receiverMapper.setReceiverTag(phoneId);
    }

    public Receiver getReceiver(Map<String, Object> paramMap) {
        return receiverMapper.getReceiver(paramMap);
    }
}
