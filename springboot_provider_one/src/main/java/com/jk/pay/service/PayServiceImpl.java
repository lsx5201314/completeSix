package com.jk.pay.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.pay.mapper.PayMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0")
public class PayServiceImpl  implements PayService {
    @Autowired
    private PayMapper payMapper;
}
