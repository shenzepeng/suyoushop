package com.kxg.suyoushop.provider.service.impl;

import com.kxg.suyoushop.provider.mapper.OrdersMapper;
import com.kxg.suyoushop.provider.pojo.Orders;
import com.kxg.suyoushop.provider.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class OrderSerciceImpl implements OrderService {
    @Autowired
    private OrdersMapper mapper;
    @Override
    public Integer addNewOrder(Orders orders) {
        return mapper.insert(orders);
    }

    @Override
    public Integer updateOrder(Orders orders) {
        return mapper.updateByPrimaryKeySelective(orders);
    }
}
