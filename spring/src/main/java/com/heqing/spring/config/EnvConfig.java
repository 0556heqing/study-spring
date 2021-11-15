package com.heqing.spring.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author heqing
 * @date 2021/7/16 16:34
 */
@Component
@PropertySource({"classpath:env/env.properties", "classpath:env/env-${env}.properties"})
public class EnvConfig {
}
