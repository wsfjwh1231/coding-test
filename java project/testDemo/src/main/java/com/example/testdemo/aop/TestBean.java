package com.example.testdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBean.class);

//    @Pointcut("execution(* com.example.testdemo.bean.DemoObject.run(..))")
    @AfterThrowing(pointcut = "execution(* com.example.service.*.*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Throwable exception) {
        LOGGER.error("Exception occurred in method: {} with message: {}", joinPoint.getSignature().getName(), exception.getMessage(), exception);
    }
}
