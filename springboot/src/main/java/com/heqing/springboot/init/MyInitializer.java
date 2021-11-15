package com.heqing.springboot.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author heqing
 * @date 2021/7/14 15:43
 *
 * @Profile 在不同环境加载不同的bean。  如下：只在dev、test环境激活
 */
@Profile({"dev","test"})
@Component
public class MyInitializer {

    private  final Logger log = LoggerFactory.getLogger(MyInitializer.class);

    /**
     * @PostConstruct
     * 该注解被用来修饰一个非静态的void（）方法。被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。
     * PostConstruct在构造函数之后执行，init（）方法之前执行。  Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct(注释的方法)
     */
    @PostConstruct
    public void init() {
        log.info("------ 项目初始化 -----");
    }

}
