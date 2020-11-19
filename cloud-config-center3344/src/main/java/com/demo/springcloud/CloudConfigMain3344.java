package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: wanghuadong
 * @Date: 2020/11/18 22:25
 * @Version: 1.0
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigMain3344.class,args);
    }
}
