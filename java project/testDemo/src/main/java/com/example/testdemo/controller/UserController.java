package com.example.testdemo.controller;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTHeader;
import cn.hutool.jwt.JWTUtil;
import com.example.testdemo.entity.User;
import com.example.testdemo.service.IUserService;
import com.example.testdemo.test.Result;
import com.example.testdemo.utils.Jwtutils;
import com.example.testdemo.utils.RestUtils;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


//  用户登录

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "访问令牌", dataType = "string", paramType = "header", required = false, example = "Bearer your_token"),
            @ApiImplicitParam(name = "X-Request-ID", value = "请求ID", dataType = "string", paramType = "header", required = false, example = "12345678")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功") ,
            @ApiResponse(code = 400,message = "参数错误"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 403,message = "禁止访问"),
            @ApiResponse(code = 404,message = "资源不存在"),
            @ApiResponse(code = 500,message = "服务器错误")
    })
    @ApiOperation(value = "用户登录",notes = "提供用户名和密码，返回用户信息和token。注意，此接口需要提供以下请求头参数：Authorization：（访问令牌）",response = User.class)
    @GetMapping("/login")
    public Result login(@ApiParam(value = "用户名",required = true,example = "username") @RequestParam String username,
                        @ApiParam(value = "密码",required = true,example = "password") @RequestParam String password,
                        @ApiParam(value = "备注",example = "beizhu") @RequestParam(required = false) String beizhu) {
        userService.login();
        userService.register();
        // 生成token
        String token = Jwtutils.generateToken("三张",1);

        User user = new User();
        user.setUsername("三张");
        Map<String,Object> map = new HashMap<>();
        map.put("token",token);
        map.put("object", user);

        return RestUtils.success(map);
    }

//    测试token是否有效
    @GetMapping("/protected")
    public Result protectedResource() {
        return RestUtils.success();
    }

//    注册
    @GetMapping("/token/{token}")
    public Result parse(@PathVariable String token) {
        return RestUtils.success();
    }
}
