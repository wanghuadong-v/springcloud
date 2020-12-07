package com.demo.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/5 11:31
 * @Version: 1.0
 */
@RestController
@Slf4j
public class FlowLimitController {


    @GetMapping("/testA")
    @ResponseBody
    public String testA(){
      log.info(Thread.currentThread().getName() + "\t" + "----testA");
        return "----testA";
    }

    @GetMapping("/testB")
    @ResponseBody
    public String testB(){
        return "----testB";
    }

    @GetMapping(value = "/testD")
    @ResponseBody
    public String testD(){
        try {
            TimeUnit.SECONDS.sleep(1);
            log.info("testD 测试RT");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "***testD 测试RT***";
    }

    @GetMapping(value = "/testE")
    @ResponseBody
    public String testE(){

        log.info("testE 测试RT");
        int i = 110/0;
        return "***testE 测试异常数**";
    }
}
