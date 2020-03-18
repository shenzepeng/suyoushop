package com.kxg.suyoushop.provider.pay.service.impl;

import com.kxg.suyoushop.provider.pay.service.PayHandler;
import com.kxg.suyoushop.provider.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class payServiceImpl implements PayService {
    @Autowired
    private PayHandler payHandler;
    private final static ConcurrentHashMap<String,String> msg=new ConcurrentHashMap<>();
    @Override
    public String getPayToken(String appId) {
        String token= UUID.randomUUID().toString();
        msg.put(token,appId);
        return token;
    }

    @Override
    public Object payByOrder(String token, Object orderInfo,String appId,String type) {
        String s = msg.get(token);
        if (StringUtils.isEmpty(s)){
            //token错误
        }
        if (!s.equals(appId)){

        }
        if ("weChatPay".equals(type)){
            String s1 = payHandler.weChatPay(orderInfo);
        }
        if ("aliPay".equals(type)){
            String aLiPay = payHandler.aLiPay(orderInfo);
        }
        return null;
    }
}
