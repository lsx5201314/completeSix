package com.jk.pay.service.impl;

import com.jk.pay.mapper.PayMapper;
import com.jk.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl  implements PayService {
    @Autowired
    private PayMapper payMapper;
}
