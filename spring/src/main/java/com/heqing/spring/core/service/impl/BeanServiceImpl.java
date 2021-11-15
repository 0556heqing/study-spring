package com.heqing.spring.core.service.impl;

import com.heqing.spring.core.service.BeanService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author heqing
 * @date 2021/7/16 16:34
 */
@Service("beanServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BeanServiceImpl implements BeanService {

    @Override
    public void sayHello() {
        System.out.println("--> hello World !");
    }

}
