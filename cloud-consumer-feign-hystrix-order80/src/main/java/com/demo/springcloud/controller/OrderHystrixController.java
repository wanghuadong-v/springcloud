package com.demo.springcloud.controller;

import com.demo.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.support.FallbackCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: wanghuadong
 * @Date: 2020/11/14 12:02
 * @Version: 1.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService orderHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String s = orderHystrixService.paymentInfo_OK(id);
        return s;
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
//            //超时时间峰值三秒钟
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
//        int test = 10/0;
        String s = orderHystrixService.paymentInfo_TimeOut(id);
        return  s;
    }
    //上个方法的计算异常、超时异常
    //都会使服务降级
    //；来调用此方法
    public String paymentInfo_TimeoutHandler(Integer id){
        return "消费者端，对方支付系统繁忙，请10秒后再试~：---线程池：" + Thread.currentThread() + "paymentInfo_TimeOut,id:" + id + "\t 这是兜底的方法！" ;
    }

    /**
     * 下面是全局的fallbackMethod
     */
    public String payment_Global_FallbackMethod(){
        return "我是全局的异常处理方法，-------请稍后再试~";
    }

}
