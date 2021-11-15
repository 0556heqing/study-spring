package com.heqing.demo.spring.listener;

import com.heqing.spring.config.SpringCoreConfig;
import com.heqing.spring.listener.MyEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = SpringCoreConfig.class
)
public class ListenerTest {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Test
    public void testListener() {
        applicationEventPublisher.publishEvent(new MyEvent(this, "写作业"));
        System.out.println("-----");

        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
