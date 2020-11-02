package com.demo.springboot.service.impl;

import com.demo.springboot.dao.PaymentDao;
import com.demo.springboot.entities.Payment;
import com.demo.springboot.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment selectPaymentById(long id) {
        return paymentDao.selectPaymentById(id);
    }
}
