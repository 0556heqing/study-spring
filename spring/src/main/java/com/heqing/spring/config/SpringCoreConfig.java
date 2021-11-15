package com.heqing.spring.config;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author heqing
 * @date 2021/7/16 16:34
 * 注解：
 *  @EnableAspectJAutoProxy：启动AspectJ自动代理
 *  @ComponentScan：启动自动扫描bean
 */
@Configuration
@EnableAspectJAutoProxy
@EnableAsync
@ComponentScan("com.heqing.spring.*")
public class SpringCoreConfig {

    @Bean
    @Profile("dev")
    public void devProfile() {
        System.out.println("--- dev ---");
    }

    @Bean
    @Profile("test")
    public void testProfile() {
        System.out.println("--- test ---");
    }

    @Bean
    @Profile("stg")
    public void stgProfile() {
        System.out.println("--- stg ---");
    }

    @Bean
    @Profile("prod")
    public void prodProfile() {
        System.out.println("--- prod ---");
    }
}
