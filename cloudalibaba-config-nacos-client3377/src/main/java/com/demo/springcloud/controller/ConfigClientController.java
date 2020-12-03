package com.demo.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/2 21:28
 * @Version: 1.0
 */
@RestController
//支持nacos的动态刷新
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/config/info")
    @ResponseBody
    public String getConfigInfo(){
        return configInfo;
    }
}
