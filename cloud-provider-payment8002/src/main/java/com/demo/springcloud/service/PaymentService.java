package com.demo.springcloud.service;

import com.demo.springcloud.entities.Payment;

public interface PaymentService {
    public int create(Payment payment);

    public Payment selectPaymentById(long id);
}
