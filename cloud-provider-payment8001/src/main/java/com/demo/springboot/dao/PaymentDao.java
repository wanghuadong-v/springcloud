package com.demo.springboot.dao;

import com.demo.springboot.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment selectPaymentById(@Param("id")long id);
}
