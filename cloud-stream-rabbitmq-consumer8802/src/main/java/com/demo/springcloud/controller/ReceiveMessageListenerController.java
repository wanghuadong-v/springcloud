package com.demo.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author: wanghuadong
 * @Date: 2020/11/29 16:23
 * @Version: 1.0
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String  ServerPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("8802收到的消息是：" + message.getPayload() + "++++端口号是：" + ServerPort);
    }


}
