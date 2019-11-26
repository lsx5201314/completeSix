package com.jk.mycart.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.jk.comd.model.Commodity;
import com.jk.mycart.mapper.MyCartMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

@Service( version = "1.0")
public class MyCartServiceImpl2 implements MyCartService2 {
    @Autowired
    private MyCartMapper2 myCartMapper2;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public List<Commodity> findCartListFromRedis( String redisMyCartKey ) {
        List<Commodity> cartList =redisTemplate.opsForList().range(redisMyCartKey,0,-1);
        if(cartList==null){
            cartList=new ArrayList();
        }
        return cartList;
    }

    @Override
    public List<Commodity> mergeCartList( List<Commodity> cartList_cookie, List<Commodity> cartList_redis ) {
        //合并购物车
        for(Commodity cart:cartList_cookie){
                    cartList_redis.add(cart);
        }
        return cartList_redis;
    }

    @Override
    public void saveCartListToRedis( String redisMyCartKey, List<Commodity> cartList ) {
        for (Commodity cart:cartList) {
            redisTemplate.opsForList().leftPush(redisMyCartKey,cart);
        }


    }

    @Override
    public List<Commodity> addGoodsToCartList( List<Commodity> cartList, Long itemId, Integer num ) {
        List<Commodity> resultRedisCartList= myCartMapper2.selectByPrimaryKey(itemId);

        for (Commodity cart:resultRedisCartList) {
                cart.setProductNum(num);
                cart.setAllPriceProduct(num*cart.getCommodityPrice()+"");
        }
        return resultRedisCartList;
    }

    @Override
    public Integer queryMyCartAllPrice( String redisMyCartKey ) {
        List<Commodity> cartList =redisTemplate.opsForList().range(redisMyCartKey,0,redisTemplate.opsForList().size(redisMyCartKey));
        Integer myCartAllPrice=0;
        for (Commodity cart:cartList) {
            myCartAllPrice+=cart.getProductNum()*(int)cart.getCommodityPrice();
        }
        return myCartAllPrice;
    }

    @Override
    public void removeMyCartByGoodsId( String id, String redisMyCartKey ) {
        List<Commodity> cartList =redisTemplate.opsForList().range(redisMyCartKey,0,redisTemplate.opsForList().size(redisMyCartKey));
        for (int i = 0; i < cartList.size(); i++) {
           if((cartList.get(i).getProductId()+"").equals(id)){
               cartList.remove(cartList.get(i));
           }
        }

        redisTemplate.delete(redisMyCartKey);
        if(cartList.size()>0){
            for (Commodity cart:cartList) {
                redisTemplate.opsForList().leftPush(redisMyCartKey,cart);
            }
        }


    }

    @Override
    public void changeMyCart( List<Commodity> mycartInfoList, String redisMyCartKey ) {
        redisTemplate.delete(redisMyCartKey);
        for (Commodity cart:mycartInfoList) {
            redisTemplate.opsForList().leftPush(redisMyCartKey,cart);
        }
    }

    @Override
    public String findMyCartCount( String redisMyCartKey ) {
        List<Commodity> cartList =redisTemplate.opsForList().range(redisMyCartKey,0,-1);
        StringBuffer stringBuffer = new StringBuffer();
        if(cartList.size()>0){
            for (Commodity cart:cartList) {
                stringBuffer.append(cart.getProductNum());
            }
        }
        return stringBuffer.toString();
    }


}
