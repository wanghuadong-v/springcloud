package com.demo.springcloud.controller;

import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
//    public static final String payment_url = "http://localhost:8001/";
//    改为微服务名称
    public static final String payment_url = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(payment_url+"/payment/create" ,payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        return restTemplate.getForObject(payment_url+"/payment/get/" + id,CommonResult.class);
    }
}
