package com.jk.pay.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.pay.mapper.PayMapper;
import com.jk.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PayServiceImpl  implements PayService {
    @Autowired
    private PayMapper payMapper;
}
