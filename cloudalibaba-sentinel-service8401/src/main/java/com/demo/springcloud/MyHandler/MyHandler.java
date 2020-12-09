package com.demo.springcloud.MyHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/7 21:23
 * @Version: 1.0
 */
public class MyHandler {
    public static String handlerException1(BlockException exception){
        return "------------handlerException-----1";
    }


    public static String handlerException2(BlockException exception){
        return "------------handlerException----2";
    }
}
