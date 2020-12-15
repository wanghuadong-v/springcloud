package com.demo.springcloud.service;

import com.demo.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author: wanghuadong
 * @Date: 2020/12/10 20:55
 * @Version: 1.0
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId")Long userId, @RequestParam("money") BigDecimal money);
}
