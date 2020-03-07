package com.kxg.suyoushop.provider.service;

import com.kxg.suyoushop.provider.pojo.Orders;

public interface OrderService {
    Integer addNewOrder(Orders orders);
    Integer updateOrder(Orders orders);
}
