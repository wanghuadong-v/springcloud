package com.demo.springcloud2020.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.naming.Name;
import javax.print.attribute.standard.MediaSize;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wanghuadong
 * @Date: 2020/11/14 10:26
 * @Version: 1.0
 */
@Service
public class PaymentService {
    /**
     * 能正常访问的方法
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池：" + Thread.currentThread() + "paymentInfo_OK,id:" + id + "\t 哈哈哈";
    }

    /**
     * 服务降级测试
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            //超时时间峰值三秒钟
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 5;
//        int test = 10/0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread() + "paymentInfo_TimeOut,id:" + id + "\t 哈哈哈" + "耗时:" + timeNumber + "秒钟";
    }


    //上个方法的计算异常、超时异常
    //都会使服务降级
    //；来调用此方法
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池：" + Thread.currentThread() + "paymentInfo_TimeOut,id:" + id + "\t 这是兜底的方法！" ;
    }

    /**
     * 以下为服务熔断
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        if (id < 0){
            throw new RuntimeException("*******id不能为负数！");
        }
        String s = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + s;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id")Integer id){
        return "id不能为负数，请稍后再试----id：" + id;
    }
}
