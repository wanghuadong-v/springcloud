package com.demo.springcloud.controller;

import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.Payment;
import com.demo.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.security.PrivateKey;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class paymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/payment/create")
    @ResponseBody
    public CommonResult creat(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        if (i > 0){
            return new CommonResult(200,"插入数据库成功！",i);
        }else {
            return new CommonResult(444,"插入数据库失败1",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    @ResponseBody
    public CommonResult<Payment> getPaymentById(@PathVariable("id")long id){
        Payment payment = paymentService.selectPaymentById(id);
        if (payment != null){
            return new CommonResult(200,"查询数据成功！端口号：" + serverPort ,payment);
        }else {
            return new CommonResult(444,"没有该记录！端口号：" + serverPort,null);
        }
    }

    @GetMapping(value = "/payment/discover")
    @ResponseBody
    public Object discover(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println("****element****" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    @ResponseBody
    public String getPaymentLb(){
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    @ResponseBody
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
