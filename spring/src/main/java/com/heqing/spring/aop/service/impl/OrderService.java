package com.heqing.spring.aop.service.impl;

import org.springframework.stereotype.Service;

/**
 * @author heqing
 * @date 2021/7/16 16:34
 */
@Service
public class OrderService {

    public void order() {
        System.out.println("测试aop执行顺序");
    }
}
