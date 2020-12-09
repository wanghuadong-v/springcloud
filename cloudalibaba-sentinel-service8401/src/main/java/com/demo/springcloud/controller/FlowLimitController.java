package com.demo.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.demo.springcloud.MyHandler.MyHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    @ResponseBody
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){
        return "-----testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "-----deal_testHotKey,嘿嘿嘿~";
    }


    @GetMapping("/SentinelResource")
    @SentinelResource(value = "SentinelResource",blockHandlerClass = MyHandler.class,blockHandler = "handlerException1")
    @ResponseBody
    public String testHotKey1(){
        return "SentinelResource----test---";
    }
}
