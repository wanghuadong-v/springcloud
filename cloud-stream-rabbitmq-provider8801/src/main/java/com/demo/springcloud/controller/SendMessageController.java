package com.demo.springcloud.controller;

import com.demo.springcloud.service.TMessageProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: wanghuadong
 * @Date: 2020/11/29 11:19
 * @Version: 1.0
 */
@RestController
public class SendMessageController {
    @Resource
    private TMessageProviderService tMessageProviderService;

    @GetMapping(value = "/sendMessage")
    public void send(){
        tMessageProviderService.send();
    }




}
