package com.example.testdemo.aop;

import com.example.testdemo.test.Result;
import com.example.testdemo.utils.Jwtutils;
import com.example.testdemo.utils.RestUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component//纳入spring容器
@Aspect//声明为切面类
public class DemoAspect {
    @Autowired
    private HttpServletRequest req;
    private static final Logger logger = LoggerFactory.getLogger(DemoAspect.class);


//    ==============================================================基于Hutool-jwt包的 token鉴权开始 ==============================================================
//    @Pointcut("execution( * com.example.testdemo.controller.*.*(..)) &&"
//            + " !execution(* com.example.testdemo.controller.UserController.login(..))")
//    public void protectedResources() {
//    }

//    @Around("protectedResources()")
    @Around("@annotation(com.example.testdemo.utils.Category)")
    public Result authenticate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        Map<String,Object> map = Jwtutils.verify(token);
        int code =(Integer) map.get("isError");
        if (code == 1){
            return RestUtils.error("认证信息无效，请登录");
        }

        if (token == null ){
            return RestUtils.error("认证信息无效，请登录");

        }

        if ((Integer) map.get("isAdmin")== 0){
            return RestUtils.error("您没有权限访问");
        }

        return (Result)proceedingJoinPoint.proceed();
    }
}
