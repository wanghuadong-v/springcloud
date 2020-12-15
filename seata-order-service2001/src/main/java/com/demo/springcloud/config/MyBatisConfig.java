package com.demo.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/10 21:21
 * @Version: 1.0
 */
@Configuration
@MapperScan({"com.demo.springcloud.dao"})
public class MyBatisConfig {
}
