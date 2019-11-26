package com.jk.order.mapper;

import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

    void updOrderStatus(@Param("orderId") String orderId);

    void updCommoditys(@Param("count") Integer count,@Param("orderId") String orderId);
}
