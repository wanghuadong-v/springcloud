package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/5 11:30
 * @Version: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaSentinelMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaSentinelMain8401.class,args);
    }
}
