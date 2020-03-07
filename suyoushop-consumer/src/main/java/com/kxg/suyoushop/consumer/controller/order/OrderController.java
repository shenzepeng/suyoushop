package com.kxg.suyoushop.consumer.controller.order;

import com.kxg.suyoushop.common.SzpJsonResult;
import com.kxg.suyoushop.consumer.hander.CheckHandler;
import com.kxg.suyoushop.request.PayCallBackChangeRequest;
import com.kxg.suyoushop.response.UpdatePayCallResponse;
import com.kxg.suyoushop.service.OrderDubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class OrderController {
    @Reference(version = "1.0.0")
    private OrderDubboService dubboService;
    @Autowired
    private CheckHandler checkHandler;
    //新增订单

    //更新订单

    //删除订单

    /**
     * 支付后回调
     * 支付成功后
     * 支付系统会回调
     * 订单系统
     * 去修状态
     * 状态有支付成功
     * 取消支付
     * @return
     */

    public void payCallBackChangeStatus(@RequestHeader("payToken")String payToken, @RequestBody PayCallBackChangeRequest request){
        if (checkHandler.checkPayToken(payToken,request.getOrderId())){
            dubboService.updatePayCallBack(request);
        }
    }
}
