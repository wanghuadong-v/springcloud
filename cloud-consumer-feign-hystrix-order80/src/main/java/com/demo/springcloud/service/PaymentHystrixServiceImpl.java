package com.demo.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: wanghuadong
 * @Date: 2020/11/15 10:28
 * @Version: 1.0
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "---------PaymentHystrixService---------OK--------";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-------------------PaymentHystrixService-------TIMEOUT------";
    }
}
