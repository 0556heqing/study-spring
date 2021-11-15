package com.heqing.springboot.init;

import java.lang.annotation.*;

/**
 * 用于测试 getBeansWithAnnotation
 * @author heqing
 * @date 2021/7/14 15:51
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface SystemName {

    String name() default "demo";

}
