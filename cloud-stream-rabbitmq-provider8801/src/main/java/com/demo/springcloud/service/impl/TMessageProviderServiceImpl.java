package com.demo.springcloud.service.impl;

import com.demo.springcloud.service.TMessageProviderService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * @Author: wanghuadong
 * @Date: 2020/11/29 11:03
 * @Version: 1.0
 */
//定义消息的推送管道
@EnableBinding(Source.class)
public class TMessageProviderServiceImpl implements TMessageProviderService {
    @Resource
    private MessageChannel output; //消息发送通道

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("***uuid***" + uuid);
        return uuid;
    }
}
