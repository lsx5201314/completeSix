package com.jk.pageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("tologin")
    public String   tologin(){
        return "login/login";
    }
    @RequestMapping("toIndex")
    public String toIndex(){
        return "index";
    }
    @RequestMapping("toCart")
    public String toCart(){
        return "shopping_cart";
    }
    @RequestMapping("toGetorder")
    public String toGetorder(){
        return "pay/getOrderInfo";
    }
    @RequestMapping("toPay")
    public String toPay(){
        return "pay/pay";
    }
    @RequestMapping("toPaysuccess")
    public String toPaysuccess(){
        return "pay/paysuccess";
    }
}

