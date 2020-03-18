package com.kxg.suyoushop.provider.dubboservice;

import com.kxg.suyoushop.constant.SuYouShopConstants;
import com.kxg.suyoushop.provider.pojo.Orders;
import com.kxg.suyoushop.provider.service.OrderService;
import com.kxg.suyoushop.request.AddNewOrderRequest;
import com.kxg.suyoushop.request.PayCallBackChangeRequest;
import com.kxg.suyoushop.response.AddNewOrderResponse;
import com.kxg.suyoushop.response.UpdatePayCallResponse;
import com.kxg.suyoushop.service.OrderDubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
@Service(version = "1.0.0")
public class OrderDubboServiceImpl implements OrderDubboService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private OrderService orderService;
    private ReentrantLock reentrantLock;
    private ReentrantReadWriteLock reentrantReadWriteLock;
    @Override
    public AddNewOrderResponse addNewOrder(AddNewOrderRequest request) {

        Orders orders=new Orders();
        orders.setCarId(request.getCarId());
        orders.setCreateTime(new Date());
        orders.setUpdateTime(new Date());
        orders.setShopId(request.getShopId());
        orders.setUserId(request.getUserId());
        orders.setStatus(SuYouShopConstants.NOT_PAY_STATUS);
        Integer result = orderService.addNewOrder(orders);
        AddNewOrderResponse response=new AddNewOrderResponse();
        response.setEnd(result);
        reentrantLock.unlock();
        return response;
    }

    @Override
    public UpdatePayCallResponse updatePayCallBack(PayCallBackChangeRequest request) {
        Orders orders=new Orders();
        orders.setStatus(request.getStatus());
        orders.setId(request.getOrderId());
        if (SuYouShopConstants.PAY_SUCCESS.equals(request.getStatus())){
            orders.setPayCode(request.getPayCode());
        }
        Integer result = orderService.updateOrder(orders);
        UpdatePayCallResponse response=new UpdatePayCallResponse();
        response.setEnd(result);
        return response;
    }
}
