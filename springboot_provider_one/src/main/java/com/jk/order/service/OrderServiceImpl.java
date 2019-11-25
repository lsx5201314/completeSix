package com.jk.order.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0")
public class OrderServiceImpl  implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void updOrderStatus(String orderId,Integer count) {

        orderMapper.updOrderStatus(orderId);
        orderMapper.updCommoditys(count,orderId);
    }
}
