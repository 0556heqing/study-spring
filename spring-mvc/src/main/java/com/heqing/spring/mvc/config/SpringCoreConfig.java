package com.heqing.spring.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author heqing
 * @date 2021/7/16 16:34
 */
@Configuration
@ComponentScan(basePackages = "com.heqing.spring.*",
        excludeFilters = {@ComponentScan.Filter(type=FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class SpringCoreConfig {

}
