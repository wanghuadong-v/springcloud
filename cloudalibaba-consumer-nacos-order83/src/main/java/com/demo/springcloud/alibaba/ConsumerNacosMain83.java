package com.demo.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/2 20:59
 * @Version: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerNacosMain83 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerNacosMain83.class,args);
    }
}
