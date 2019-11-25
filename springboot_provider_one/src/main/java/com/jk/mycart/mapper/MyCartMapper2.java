package com.jk.mycart.mapper;


import com.jk.comd.model.Commodity;

import java.util.List;

public interface MyCartMapper2 {
    List<Commodity> selectByPrimaryKey( Long itemId );
}
