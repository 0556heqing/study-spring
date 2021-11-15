package com.heqing.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author heqing
 * @date 2021/7/14 10:40
 *
 * @SpringBootConfiguration 继承至@Configuration，此标注当前类是配置类，并会将当前类内声明的一个或多个以@Bean注解标记的方法的实例纳入到srping容器中，并且实例名就是方法名。
 * @EnableAutoConfiguration 能所有符合自动配置条件的bean的定义加载到spring容器中
 * @ComponentScan 会扫描当前包及其子包下被@Component，@Controller，@Service，@Repository等注解标记的类并纳入到spring容器中进行管理。
 * @SpringBootApplication 相当于使用 @Configuration @EnableAutoConfiguration @ComponentScan
 */
@SpringBootApplication
@ServletComponentScan
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringbootApplication.class);
        // 不打印 banner
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
