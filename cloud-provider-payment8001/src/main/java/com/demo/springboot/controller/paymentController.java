package com.demo.springboot.controller;

import com.demo.springboot.entities.CommonResult;
import com.demo.springboot.entities.Payment;
import com.demo.springboot.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class paymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/creat")
    @ResponseBody
    public CommonResult creat(Payment payment){
        int i = paymentService.create(payment);
        if (i > 0){
            return new CommonResult(200,"插入数据库成功！",i);
        }else {
            return new CommonResult(444,"插入数据库失败1",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    @ResponseBody
    public CommonResult getPaymentById(@PathVariable("id")long id){
        Payment payment = paymentService.selectPaymentById(id);
        if (payment != null){
            return new CommonResult(200,"查询数据成功！",payment);
        }else {
            return new CommonResult(444,"没有该记录！",null);
        }
    }
}
