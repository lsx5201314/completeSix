package com.jk.order.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.jk.comd.model.Commodity;
import com.jk.entity.model.TbPayLog;
import com.jk.order.mapper.OrderMapper;
import com.jk.order.mapper.TbOrderItemMapper;
import com.jk.order.model.TOrder;
import com.jk.order.model.TOrderinfo;
import com.jk.order.model.TbOrder;
import com.jk.pay.mapper.PayMapper;
import com.jk.user.model.CmsUser;
import com.jk.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service( version = "1.0")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private IdWorker idWorker;
    @Autowired
    private PayMapper payLogMapper;
    @Autowired
    private TbOrderItemMapper orderItemMapper;
    @Override
    public String add( TbOrder order, String redisMyCartKey, String redisPayKey, CmsUser user ) {
        //1.从redis中提取购物车列表
        List<Commodity> cartList =redisTemplate.opsForList().range(redisMyCartKey,0,-1);
        List<String> orderIdList=new ArrayList();//订单ID集合
        double total_money=0;//总金额
        //2.循环购物车列表添加订单
        for(Commodity  cart:cartList){
            TbOrder tbOrder=new TbOrder();
            long orderId = idWorker.nextId();	//获取ID
            orderIdList.add(orderId+"");
            total_money+=cart.getProductNum()*cart.getCommodityPrice();//合计
            //-------------------------------------------------------------------
            TOrderinfo tOrderinfo = new TOrderinfo();
            tOrderinfo.setOrderinfoid(orderId+"");
            tOrderinfo.setOrderinfooid(orderId+"");
            tOrderinfo.setOrderinfopid(cart.getProductId()+"");
            tOrderinfo.setOrderinfocprice(cart.getCommodityPrice());
            tOrderinfo.setNumber(cart.getProductNum()+"");
            tOrderinfo.setAllprice(total_money);
            //----------支付类型以及地址
            TOrder tOrder = new TOrder();
            tOrder.setOrderid(orderId+"");
            tOrder.setPayment(total_money+"");
            tOrder.setPaytype(1+"");
            tOrder.setStatus(0);
            tOrder.setCreatetime(new Date());
            tOrder.setUserid(user.getCmsUserId());
            tOrder.setUsername(user.getCmsUserName());
            tOrder.setRecarea(order.getReceiver());
            tOrder.setRecphone(order.getReceiverMobile());
            tOrder.setReceiver(order.getReceiver());
            //新增cyp
            orderMapper.insertMyOrder(tOrder);
            orderMapper.insertMyOrderInfo(tOrderinfo);
        }
        //添加支付日志
        String orderId= idWorker.nextId()+"";
        if("1".equals(order.getPaymentType())){
            TbPayLog payLog=new TbPayLog();
            payLog.setOutTradeNo(orderId);//支付订单号
            payLog.setCreateTime(new Date());
            payLog.setUserId(user.getCmsUserId()+"");//用户ID
            payLog.setOrderList(orderIdList.toString().replace("[", "").replace("]", ""));//订单ID串
            payLog.setTotalFee( (long)( total_money*100)   );//金额（分）
            payLog.setTradeState("0");//交易状态
            payLog.setPayType("1");//微信
            redisTemplate.opsForList().leftPush(redisPayKey,payLog);
        }
        //3.清除redis中的购物车
        redisTemplate.opsForList().remove(orderId,0,-1);
        return orderId;
    }

    @Override
    public void updOrderStatus( String orderId ) {

    }
}
