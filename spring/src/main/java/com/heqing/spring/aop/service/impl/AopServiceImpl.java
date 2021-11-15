package com.heqing.spring.aop.service.impl;

import com.heqing.spring.aop.service.AopService;
import org.springframework.stereotype.Service;

/**
 * @author heqing
 * @date 2021/7/16 16:34
 */
@Service
public class AopServiceImpl implements AopService {

    @Override
    public String testReture() {
        return "Hello spring aop";
    }

    @Override
    public String testParameter(int index, String value) {
        return "恭喜，测试成功！";
    }

    @Override
    public void testEx() {
        int num = 1/0;
    }
}
