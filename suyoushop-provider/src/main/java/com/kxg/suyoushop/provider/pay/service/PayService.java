package com.kxg.suyoushop.provider.pay.service;

public interface PayService {
    String getPayToken(String appId);
    Object payByOrder(String token,Object orderInfo,String appId,String type);
}
