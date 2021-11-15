package com.heqing.springboot.servlet.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @WebFilter 过滤器Filter注解。是Servlet的的一个实用技术了。可通过过滤器，对请求进行拦截，
 *      比如读取session判断用户是否登录、判断访问的请求URL是否有访问权限(黑白名单)等。主要还是可对请求进行预处理。
 * 注意：需要在启动类上增加 @ServletComponentScan。。 如果需要设置过滤顺序，需要通过 FilterRegistrationBean
 * @author heqing
 * @date 2021/7/16 16:33
 */
@WebFilter(filterName="myFilter",urlPatterns={"/*"})
public class MyFilter implements Filter {

    private  final Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Filter（过滤器） --> init: 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Filter（过滤器） --> doFilter: 请求处理");
        //对request、response进行一些预处理,比如设置请求编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 配置跨域访问，部分http请求允许跨域访问
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        processCrossDomain(req, res, "Access-Control-Allow-Origin", "*");
        processCrossDomain(req, res, "Access-Control-Allow-Methods", "GET,POST,HEAD,OPTIONS,PUT");
        processCrossDomain(req, res, "Access-Control-Max-Age", "6000");
        processCrossDomain(req, res, "Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept,token");
        processCrossDomain(req, res, "Access-Control-Allow-Credentials", "true");
        //TODO 进行业务逻辑
        //链路 直接传给下一个过滤器
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("Filter（过滤器） --> destroy: 销毁");
    }

    private void processCrossDomain(HttpServletRequest request, HttpServletResponse response, String headerName, String headerValue) {
        String oldHeadValue = request.getHeader(headerName);
        if (oldHeadValue == null || !oldHeadValue.equals(headerValue)) {
            response.setHeader(headerName, headerValue);
        }
    }
}
