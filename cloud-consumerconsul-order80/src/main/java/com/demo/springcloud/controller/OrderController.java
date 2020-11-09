package com.demo.springcloud.controller;

import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
//    public static final String payment_url = "http://localhost:8001/";
//    改为微服务名称
    public static final String payment_url = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String payment (){
        String result = restTemplate.getForObject(payment_url+"/payment/consul",String.class);
        return result;
    }
}