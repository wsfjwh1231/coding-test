package com.example.testdemo.controller;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTHeader;
import cn.hutool.jwt.JWTUtil;
import com.example.testdemo.service.IUserService;
import com.example.testdemo.test.Result;
import com.example.testdemo.utils.Jwtutils;
import com.example.testdemo.utils.RestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

//  用户登录

    @GetMapping("/login")
    public Result login() {
        userService.login();
        userService.register();
        // 在这里验证用户名和密码，这里只是示例，所以没有实际的验证逻辑
        String token = Jwtutils.generateToken("三张");
        JWT jwt = JWTUtil.parseToken(token);

        //解析JWT 读取校验数据
        System.out.println(jwt.getHeader(JWTHeader.TYPE));
        System.out.println(jwt.getPayload("uid"));
        System.out.println(jwt.getPayload("expire_time"));
        return RestUtils.success("Bearer " + token);
    }

//    测试token是否有效
    @GetMapping("/protected")
    public String protectedResource() {
        return "This is a protected resource";
    }

//    JWT解析
    @GetMapping("/token/{token}")
    public Result parse(@PathVariable String token) {
        return RestUtils.success(Jwtutils.parseToken(token));
    }
}
