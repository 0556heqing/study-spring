package com.heqing.spring.core.service.impl;

import com.heqing.spring.core.service.BeanService;
import org.springframework.stereotype.Service;

/**
 * @author heqing
 * @date 2021/7/16 16:34
 */
@Service("beanServiceNewImpl")
public class BeanServiceNewImpl implements BeanService {

    @Override
    public void sayHello() {
        System.out.println("--> hello New World !");
    }
}
