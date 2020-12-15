package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/9 21:37
 * @Version: 1.0
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SeateOrderMainApp2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeateOrderMainApp2001.class,args);
    }
}
