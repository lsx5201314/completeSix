package com.jk.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.common.CommonConf;
import com.jk.order.model.TbOrder;
import com.jk.order.service.OrderService;
import com.jk.user.model.CmsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private HttpServletRequest request;
    @Resource
    private HttpServletResponse response;
    @Reference(version = "1.0")
    private OrderService orderService;
    @RequestMapping("add")
    @ResponseBody
    public String add( @RequestBody TbOrder order){
        HttpSession session = request.getSession();
        CmsUser user= (CmsUser) session.getAttribute(session.getId());
        order.setUserId(user.getCmsUserId()+"");
        String redisPayKey= CommonConf.PAYLOG_CACHE_KEY+user.getCmsUserName();
        //获取当前登录人账号
        order.setSourceType("2");//订单来源  PC
        String redisMyCartKey= CommonConf.LOGIN_CACHE_KEY+user.getCmsUserName();
        try {
            //这里需要从购物车拉取数据
            String orderId = orderService.add(order, redisMyCartKey, redisPayKey, user);
            return orderId;
        } catch (Exception e) {
            e.printStackTrace();
            return "新增失败";
        }
    }

}
