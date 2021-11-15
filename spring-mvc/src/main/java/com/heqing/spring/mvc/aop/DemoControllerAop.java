package com.heqing.spring.mvc.aop;

import com.alibaba.fastjson.JSONObject;
import com.heqing.spring.mvc.util.ResultUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author heqing
 * @date 2021/7/16 16:34
 */
@Aspect
@Component
public class DemoControllerAop {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoControllerAop.class);

    @Pointcut("execution(public * com.heqing.spring.mvc.controller..*(..)) && !execution(* com.heqing.spring.mvc.controller.DemoController.modelAttribute(..))")
    public void controller(){}

    @Around("controller()")
    public Object logService(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();

        // 获取类名
        String className = joinPoint.getTarget().getClass().getName();
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();

        try {
            // 获取入参
            String parameString = "";
            Object[] objects = joinPoint.getArgs();
            if (objects != null && objects.length > 0) {
                StringBuilder parame = new StringBuilder();
                for (Object object : objects) {
                    if (!(object instanceof HttpServletRequest) && !(object instanceof HttpServletResponse)) {
                        parame.append(JSONObject.toJSONString(object)).append(",");
                    }
                }
                parameString = parame.toString();
                String komma = ",";
                if(parameString.endsWith(komma)) {
                    parameString = parameString.substring(0, parameString.length()-1);
                }
            }
            LOGGER.info("--接口请求--> 类名:{}, 方法名:{}, 入参：{}", className, methodName, parameString);
        } catch (Exception e) {
            // log
            return ResultUtil.buildError();
        }

        Object result = null;
        try {
            result = joinPoint.proceed();
            if(result == null) {
                result = (ResultUtil)ResultUtil.buildSuccess();
            } else if(result instanceof ResultUtil) {
                result = (ResultUtil<?>)result;
            } else {
                result = (ModelAndView)result;
            }
        } catch (DemoException e) {
            if(e.getCode() != null && !StringUtils.isEmpty(e.getMsg())) {
                result = ResultUtil.buildError(e.getCode(), e.getMsg());
            } else {
                result = ResultUtil.buildError();
            }
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            result = ResultUtil.buildError(sw.toString().substring(0, 1000));
        } catch (Throwable throwable) {
            result = ResultUtil.buildError(throwable.getMessage());
        }
        LOGGER.info("--接口响应--> 类名:{}, 方法名:{}, 出参：{},响应时间：{}", className, methodName, JSONObject.toJSONString(result), (System.currentTimeMillis()-startTime));
        return result;
    }

}
