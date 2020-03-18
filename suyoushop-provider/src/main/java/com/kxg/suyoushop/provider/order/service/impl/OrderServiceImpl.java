package com.kxg.suyoushop.provider.order.service.impl;

import com.kxg.suyoushop.provider.order.service.OrderService;
import com.kxg.suyoushop.provider.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private PayService payService;
    @Override
    public Object makeSureOrder(Long id) {
//        //1,获取支付的token
//        String payToken = payService.getPayToken();
//        //2.开始下单
//        Object object=new Object();
//        payService.payByOrder(payToken,object);
        return null;
    }
}
