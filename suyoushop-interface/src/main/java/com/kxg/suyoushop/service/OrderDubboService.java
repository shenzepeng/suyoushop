package com.kxg.suyoushop.service;

import com.kxg.suyoushop.request.AddNewOrderRequest;
import com.kxg.suyoushop.request.PayCallBackChangeRequest;
import com.kxg.suyoushop.response.AddNewOrderResponse;
import com.kxg.suyoushop.response.UpdatePayCallResponse;

public interface OrderDubboService {
    AddNewOrderResponse addNewOrder(AddNewOrderRequest request);
    UpdatePayCallResponse updatePayCallBack(PayCallBackChangeRequest request);
}
