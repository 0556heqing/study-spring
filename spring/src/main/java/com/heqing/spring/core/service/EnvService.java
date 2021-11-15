package com.heqing.spring.core.service;

/**
 * @author heqing
 * @date 2021/7/16 16:34
 */
public interface EnvService {

    /**
     * 测试 envConfig.getProperty
     */
    void placeholder();

    /**
     * 测试 @Value
     */
    void spel();

    /**
     * 测试 对象
     */
    void object();
}
