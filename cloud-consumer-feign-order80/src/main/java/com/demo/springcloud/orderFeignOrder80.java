package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: wanghuadong
 * @Date: 2020/11/12 22:10
 * @Version: 1.0
 */
@SpringBootApplication
@EnableFeignClients
public class orderFeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(orderFeignOrder80.class,args);
    }
}
