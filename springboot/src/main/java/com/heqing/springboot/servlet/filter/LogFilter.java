package com.heqing.springboot.servlet.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @WebFilter 过滤器Filter注解。是Servlet的的一个实用技术了。可通过过滤器，对请求进行拦截，
 *      比如读取session判断用户是否登录、判断访问的请求URL是否有访问权限(黑白名单)等。主要还是可对请求进行预处理。
 * 注意：需要在启动类上增加 @ServletComponentScan。。 如果需要设置过滤顺序，需要通过 FilterRegistrationBean
 * @author heqing
 * @date 2021/7/16 16:33
 */
@WebFilter(filterName="logFilter",urlPatterns={"/*"})
public class LogFilter implements Filter {

    private  final Logger log = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Filter（过滤器） --> doFilter: 开始处理日志");
        //链路 直接传给下一个过滤器
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
