package com.jk.mycart.service;


import com.jk.comd.model.Commodity;

import java.util.List;

public interface MyCartService2 {
    List<Commodity> findCartListFromRedis( String redisMyCartKey );

    List<Commodity> mergeCartList( List<Commodity> cartList_cookie, List<Commodity> cartList_redis );

    void saveCartListToRedis( String redisMyCartKey, List<Commodity> cartList );

    List<Commodity> addGoodsToCartList( List<Commodity> cartList, Long itemId, Integer num );

    Integer queryMyCartAllPrice( String redisMyCartKey );

    void removeMyCartByGoodsId( String id, String redisMyCartKey );

    void changeMyCart( List<Commodity> mycartInfoList, String redisMyCartKey );

    String findMyCartCount( String redisMyCartKey );
}
