package com.jk.pay.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PayController {
    @Reference( version = "1.0")
    private PayService payService;
}
