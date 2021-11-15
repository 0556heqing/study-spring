package com.heqing.springboot.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 自定义 容器监听器
 * ApplicationContext容器在启动时，会自动识别并加载EventListener类型的bean，一旦容器内有事件发布，将通知这些注册到容器的EventListener。
 * @author heqing
 * @date 2021/7/14 13:56
 */
@Component
public class MyApplicationListener implements ApplicationListener {

    private  final Logger log = LoggerFactory.getLogger(MyApplicationListener.class);

    /**
     * ContextRefreshedEvent : ApplicationContext 被初始化或刷新时，该事件被发布。此处的初始化是指：所有的Bean被成功装载，
     *      后处理Bean被检测并激活，所有Singleton Bean 被预实例化，ApplicationContext容器已就绪可用。
     * ContextStartedEvent : 当使用 ConfigurableApplicationContext （ApplicationContext子接口）接口中的 start() 方法启动 ApplicationContext 时，该事件被发布。
     * ContextStoppedEvent : 当使用 ConfigurableApplicationContext 接口中的 stop() 停止 ApplicationContext 时，该事件被发布。
     * ContextClosedEvent : 当使用 ConfigurableApplicationContext 接口中的 close() 方法关闭 ApplicationContext 时，该事件被发布。一个已关闭的上下文到达生命周期末端；它不能被刷新或重启。
     * RequestHandledEvent : 这是一个 web-specific 事件，告诉所有 bean HTTP 请求已经被服务。只能应用于使用DispatcherServlet的Web应用。
     *      在使用Spring作为前端的MVC控制器时，当Spring处理用户请求结束后，系统会自动触发该事件。
     * ApplicationReadyEvent : 在tomcat启动，spring mvc初始化完成之后触发，表示应用已经可以接收请求。
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("容器,监听到 --> {}", event.getClass().getName());

        if (event instanceof ContextRefreshedEvent) {
            ContextRefreshedEvent contextEvent = (ContextRefreshedEvent) event;
            initSystemName(contextEvent.getApplicationContext());
        }
    }

    private void initSystemName(ApplicationContext context) {
        Map<String, Object> beans = context.getBeansWithAnnotation(SystemName.class);
        for (Object bean : beans.values()) {
            SystemName typeHandler = bean.getClass().getAnnotation(SystemName.class);
            log.info("--> 加载到bean, name: {}, class: {}", typeHandler.name(), bean.getClass().getName());
        }
    }
}
