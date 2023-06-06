package com.example.testdemo.aop;

import cn.hutool.jwt.JWTUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.testdemo.utils.CustomException;
import com.example.testdemo.utils.Jwtutils;
import com.example.testdemo.utils.RestUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component//纳入spring容器
@Aspect//声明为切面类
public class DemoAspect {
    private static final Logger logger = LoggerFactory.getLogger(DemoAspect.class);

    //  使用@Pointcut注解定义切点，拦截impl包下的所有类的方法
    @Pointcut(value = "execution( * com.example.testdemo.service.impl.*.*(..))")
    public void loginPointcut() {
    }

    @Before(value = "loginPointcut()")  //有2个，引入时注意辨别
    /* 该方法是一个前置通知，在RestaurantCustomer.login()之前执行 */
    public void beforeAdvice() {
        logger.info("---检验token");
    }

    @AfterReturning(value = "loginPointcut()")
    /* 该方法是一个后置通知，在RestaurantCustomer.login()之后执行 */
    public void afterAdvice() {
        logger.info("---处理返回结果");

    }


    //    ==============================================================基于java-jwt包的 token鉴权开始 ==============================================================


//    @Pointcut("execution( * com.example.testdemo.controller.*.*(..)) &&"
//            + " !execution(* com.example.testdemo.controller.UserController.login(..))")
//    public void protectedResources() {
//    }

//    @Before("protectedResources()")
//    public void authenticate(JoinPoint joinPoint) throws Exception {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//
//        String token = request.getHeader("Authorization");
//        if (token == null || !token.startsWith("Bearer ")) {
//            throw new RuntimeException("Invalid or missing token");
//        }
//
//        try {
//            DecodedJWT decodedJWT = Jwtutils.parseToken(token);
//            request.setAttribute("claims", decodedJWT);
//        } catch (Exception ex) {
//            throw new RuntimeException("Token validation failed");
//        }
//    }

//    ==============================================================基于Hutool-jwt包的 token鉴权开始 ==============================================================
    @Pointcut("execution( * com.example.testdemo.controller.*.*(..)) &&"
            + " !execution(* com.example.testdemo.controller.UserController.login(..))")
    public void protectedResources() {
    }

//    HTTP请求头中获取JWT，对其进行解码和验证，并将解码后的JWT对象存储在HttpServletRequest对象中，以便在后续的请求处理中使用。
    @Before("protectedResources()")
    public void authenticate() {
//        从当前上下文中获取HTTP请求并将其转换为HttpServletRequest对象，以便在接下来的代码中使用。
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        从HTTP请求头中获取Authorization头的值，该值包含JWT字符串。
        String token = request.getHeader("Authorization");
        //检查传入的token是否为空或者是否以"Bearer "开头。如果不是，抛出一个运行时异常。
        if (token == null || !token.startsWith("Bearer ")) throw new RuntimeException("Invalid or missing token");
        try {
//          将解析后的JWT对象存储在HttpServletRequest对象的"claims"属性中。如果解析失败，抛出一个运行时异常。
            request.setAttribute("claims", JWTUtil.verify(token.replace("Bearer ", ""), Jwtutils.SECRET_KEY.getBytes()));

            System.out.println("test： "+JWTUtil.verify(token.replace("Bearer ", ""), Jwtutils.SECRET_KEY.getBytes()));//true

        } catch (RuntimeException run) {
            throw new CustomException(RestUtils.error("未登录或登录超时"));
        }


        // 解析用户权限信息
//        JWTClaimsSet claimsSet = jwt.getJWTClaimsSet();
//        List<String> roles = claimsSet.getStringListClaim("roles");
//        List<String> permissions = claimsSet.getStringListClaim("permissions");
//
//        // 存储用户权限信息
//        Authority authority = new Authority();
//        authority.setRoles(roles);
//        authority.setPermissions(permissions);
//
//        // 将用户权限信息存储到当前请求上下文中
//        request.setAttribute("authority", authority);
    }
}
