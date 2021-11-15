package com.heqing.spring.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author heqing
 * @date 2021/7/16 16:34
 */
@Component
public class MyListener {

    @Async
    @EventListener
    public void myEventDone(MyEvent myEvent){
        String msg = myEvent.getMsg();
        System.out.println("好的，我知道你已完成："+msg);
    }
}
