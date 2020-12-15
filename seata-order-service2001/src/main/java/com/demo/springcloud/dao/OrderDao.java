package com.demo.springcloud.dao;

import com.demo.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/10 20:38
 * @Version: 1.0
 */
@Mapper
public interface OrderDao {
//    1、新建订单
    void create(Order order);

//    2.修改订单状态，从0变为1
    void update(@Param("userId")Long userId,@Param("status")Integer status);
}
