package com.demo.springboot.service;

import com.demo.springboot.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);

    public Payment selectPaymentById(long id);
}
