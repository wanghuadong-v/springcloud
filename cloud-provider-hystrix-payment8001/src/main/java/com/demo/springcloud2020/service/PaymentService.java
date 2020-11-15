package com.demo.springcloud2020.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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
}
