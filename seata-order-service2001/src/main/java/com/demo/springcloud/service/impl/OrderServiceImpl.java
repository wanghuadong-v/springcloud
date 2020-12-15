package com.demo.springcloud.service.impl;

import com.demo.springcloud.dao.OrderDao;
import com.demo.springcloud.domain.Order;
import com.demo.springcloud.service.AccountService;
import com.demo.springcloud.service.OrderService;
import com.demo.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/10 20:56
 * @Version: 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private AccountService accountService;
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;

    @Override
    public void create(Order order) {
        log.info("----->开始新建订单");
        orderDao.create(order);

        log.info("----->订单微服务开始调用库存，做扣减。-------库存");
        storageService.decrease(order.getProductId(),order.getCount());

        log.info("---->订单微服务开始调用库存，做扣减end------账户");
        accountService.decrease(order.getUserId(),order.getMoney());

//        4.修改订单状态，从0改为1,1代表已经完成
        log.info("----->修改订单状态-----订单状态");
        orderDao.update(order.getUserId(),0);
        log.info("------>修改订单状态结束");

        log.info("------>下订单结束了");


    }
}
