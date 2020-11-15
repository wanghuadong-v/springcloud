package com.demo.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySeleRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();//定义为随机,默认为轮循
    }
}