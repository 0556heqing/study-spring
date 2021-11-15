package com.heqing.demo.spring.aop;


import com.heqing.spring.aop.service.impl.OrderService;
import com.heqing.spring.aop.service.AopService;
import com.heqing.spring.config.SpringCoreConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = SpringCoreConfig.class
)
public class AopTest {

    @Autowired
    AopService aopService;

    @Autowired
    OrderService orderService;

    @Test
    public void testReture() {
        System.out.println("----- 测试 正常切面 -----");
        System.out.println("--> " + aopService.testReture());
    }

    @Test
    public void testParameter() {
        System.out.println("----- 测试 正常切面（带参数） -----");
        System.out.println("--> " + aopService.testParameter(1, "heqing"));
    }

    @Test
    public void testEx() {
        System.out.println("----- 测试 异常情况 -----");
        aopService.testEx();
    }

    @Test
    public void testOrder() {
        orderService.order();
    }
}
