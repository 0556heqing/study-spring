package com.heqing.springboot.servlet.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author heqing
 * @date 2021/7/16 17:40
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器, 多个拦截器时 以此添加执行顺序按添加顺序
        registry.addInterceptor(new MyInterceptor())
                //所有路径都被拦截
                .addPathPatterns("/**")
                //添加不拦截路径,如：html静态资源
                .excludePathPatterns("/**/*.html");
    }

}