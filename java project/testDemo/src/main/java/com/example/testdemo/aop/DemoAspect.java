package com.example.testdemo.aop;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.example.testdemo.test.Result;
import com.example.testdemo.utils.Jwtutils;
import com.example.testdemo.utils.RestUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Component//纳入spring容器
@Aspect//声明为切面类
public class DemoAspect {
    private static final Logger logger = LoggerFactory.getLogger(DemoAspect.class);



    @Around("@annotation(com.example.testdemo.utils.Token)")
    public Result authenticate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String token = request.getHeader("token");
//        Map<String,Object> map = Jwtutils.verify(token);
//        int code =(Integer) map.get("isError");
//        if (code == 1){
//            return RestUtils.error("认证信息无效，请登录");
//        }
//
//        if (token == null ){
//            eturn RestUtils.error("认证信息无效，请登录");r
//
//        }
//
//        if ((Integer) map.get("isAdmin")== 0){
//            return RestUtils.error("您没有权限访问");
//        }
//
//        return (Result)proceedingJoinPoint.proceed();nnnnnnnnnnnnnnnnnnnnnn                              nn
//        ===============================================================Hutool token 开始==================================================================
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        boolean isToken = Jwtutils.verify(token);
        if (isToken){
            final JWT jwt = JWTUtil.parseToken(token);
            String username = (String) jwt.getPayload("username");
            int isadmin = (int) jwt.getPayload("isAdmin");

            if (isadmin == 0) {
                return RestUtils.error("您没有权限访问");
            }
            System.out.println(username);
            System.out.println(isadmin);
            return (Result)proceedingJoinPoint.proceed();
        }else {
            return RestUtils.error("认证信息无效，请登录");
        }
    }
}
