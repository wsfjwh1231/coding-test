package com.example.testdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component//纳入spring容器
@Aspect//声明为切面类
public class DemoAspect {
    @Pointcut("execution(* com.example.testdemo.test.DemoObject.run(..))")
    private void cut() {};

    @Before("cut()")
    public void before() {
        System.out.println("before");
    }
}
