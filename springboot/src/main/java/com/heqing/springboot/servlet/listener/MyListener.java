package com.heqing.springboot.servlet.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @WebListener 用于监听servletContext、HttpSession和servletRequest等域对象的创建和销毁事件。
 * 监听域对象的属性发生修改的事件。用于在事件发生前、发生后做一些必要的处理。一般是获取在线人数等业务需求。
 * @author heqing
 * @date 2021/7/16 17:30
 */
@WebListener
public class MyListener implements ServletRequestListener {

    private  final Logger log = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("Listener（监听器） --> requestDestroyed：销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("Listener（监听器） --> requestInitialized：初始化");
    }
}
