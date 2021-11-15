package com.heqing.springboot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理
 * @ControllerAdvice：控制器增强，使@ExceptionHandler、@InitBinder、@ModelAttribute注解的方法应用到所有的 @RequestMapping注解的方法。
 * @author heqing
 * @date 2021/7/16 18:22
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * @ExceptionHandler : 异常处理器，此注解的作用是当出现其定义的异常时进行处理的方法
     * 拦截Exception类的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(Exception e){
        Map<String,Object> result = new HashMap<>(1);
        result.put("respCode", "-1");
        result.put("respMsg", e.getMessage());
        return result;
    }
}
