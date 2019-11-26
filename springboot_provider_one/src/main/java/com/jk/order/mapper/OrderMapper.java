package com.jk.order.mapper;


import org.apache.ibatis.annotations.Param;

import com.jk.order.model.TOrder;
import com.jk.order.model.TOrderinfo;
import com.jk.order.model.TbOrder;


public interface OrderMapper {
    void insertMyOrder( TOrder tOrder );


    void updOrderStatus(@Param("orderId") String orderId);

    void updCommoditys(@Param("count") Integer count,@Param("orderId") String orderId);

    void insertMyOrderInfo( TOrderinfo tOrderinfo );

}
