package com.heqing.spring.aop.service;

/**
 * @author heqing
 * @date 2021/7/16 16:34
 */
public interface AopService {

    /**
     * 测试 出参
     * @return
     */
    String testReture();

    /**
     * 测试 入参
     * @param index
     * @param value
     * @return
     */
    String testParameter(int index, String value);

    /**
     * 测试 异常
     */
    void testEx();
}
