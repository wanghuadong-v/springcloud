package com.demo.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wanghuadong
 * @Date: 2020/11/18 23:14
 * @Version: 1.0
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.info}")
    private String portNum;

    @GetMapping(value = "/get/info")
    @ResponseBody
    public String getServerPort(){
        return portNum;
    }
}
