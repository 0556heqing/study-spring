package com.heqing.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author heqing
 * @date 2021/7/16 16:34
 */
@Aspect
@Component
@Order(2)
public class Order2Aop {

    @Pointcut("execution(public * com.heqing.spring.aop.service.impl.OrderService.*(..))")
    public void order(){}

    @Before("order()")
    public void before() {
        System.out.println("----第二个切面----");
    }

}
