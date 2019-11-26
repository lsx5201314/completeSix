package com.jk.order.service;

import com.jk.order.model.TbOrder;
import com.jk.user.model.CmsUser;

public interface OrderService {

    String add( TbOrder order, String redisMyCartKey, String redisPayKey, CmsUser user );


    void updOrderStatus(String orderId,Integer count);

}
