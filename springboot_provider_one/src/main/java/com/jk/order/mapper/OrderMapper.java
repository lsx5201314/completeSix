package com.jk.order.mapper;


import com.jk.order.model.TOrder;
import com.jk.order.model.TOrderinfo;
import com.jk.order.model.TbOrder;

public interface OrderMapper {
    void insertMyOrder( TOrder tOrder );

    void insertMyOrderInfo( TOrderinfo tOrderinfo );
}
