package com.kxg.suyoushop.provider.pay.service;

public interface PayHandler {
    String weChatPay(Object o);
    String aLiPay(Object o);
    String unionPay(Object o);
}
