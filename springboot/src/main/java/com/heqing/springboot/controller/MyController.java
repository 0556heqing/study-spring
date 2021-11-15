package com.heqing.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author heqing
 * @date 2021/7/16 16:34
 */
@RestController
@RequestMapping("/study")
public class MyController {

    private  final Logger log = LoggerFactory.getLogger(MyController.class);

    @GetMapping("/springboot")
    public String springboot(){
        log.info("Controller --> hello springboot");
        return "hello springboot";
    }

    @GetMapping("/valid")
    public String demoValid(@Valid MyReq req) {
        // 示例：http://localhost:8080/study/valid?code=1&name=heqing&version=1.0
        return req.getCode() + "," + req.getName();
    }

    @GetMapping("/error")
    public String error(){
        return 1/0 + "";
    }
}
