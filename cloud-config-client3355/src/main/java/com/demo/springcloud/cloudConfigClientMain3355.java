package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: wanghuadong
 * @Date: 2020/11/18 23:18
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class cloudConfigClientMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(cloudConfigClientMain3355.class,args);
    }
}
