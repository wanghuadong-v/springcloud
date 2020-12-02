package com.atguigu.springcloud.alibaba.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/1 22:18
 * @Version: 1.0
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    @ResponseBody
    public String getPayment(@PathVariable("id")Integer id){

        return "nacos regisrty,serverPort:" + serverPort + "\t id:" +id;
    }
}
