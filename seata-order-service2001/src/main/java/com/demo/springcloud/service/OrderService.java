package com.demo.springcloud.service;

import com.demo.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/10 20:54
 * @Version: 1.0
 */
public interface OrderService {
    //    1、新建订单
    void create(Order order);

}
