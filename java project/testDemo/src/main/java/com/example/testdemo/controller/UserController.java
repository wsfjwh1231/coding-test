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
            @ApiResponse(code = 200, message = "成功", response = Result.class, examples = @Example({
                    @ExampleProperty(value = "{\n" +
                            "  \"code\": 200,\n" +
                            "  \"msg\": \"success\",\n" +
                            "  \"data\": {\n" +
                            "    \"token\": \"BearereyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiLkuInlvKAiLCJleHBpcmVfdGltZSI6MTY4NjIzNTY4ODYzMn0.7HUVXZI-HG1i7NUhBBzUOxoqkOC8LQJAnHm4KwJPZRU\",\n" +
                            "    \"object\": {\n" +
                            "      \"id\": null,\n" +
                            "      \"username\": \"三张\",\n" +
                            "      \"password\": null,\n" +
                            "      \"gender\": null,\n" +
                            "      \"lastlogintime\": null,\n" +
                            "      \"lastloginip\": null,\n" +
                            "      \"userlevel\": null,\n" +
                            "      \"nickname\": null,\n" +
                            "      \"mobile\": null,\n" +
                            "      \"avatar\": null,\n" +
                            "      \"weixinopenid\": null,\n" +
                            "      \"sessionkey\": null,\n" +
                            "      \"status\": null,\n" +
                            "      \"addtime\": null,\n" +
                            "      \"updatetime\": null,\n" +
                            "      \"deleted\": null\n" +
                            "    }\n" +
                            "  }\n" +
                            "}")
            })),
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
        // 在这里验证用户名和密码，这里只是示例，所以没有实际的验证逻辑
        String token = Jwtutils.generateToken("三张");
        JWT jwt = JWTUtil.parseToken(token);

        //解析JWT 读取校验数据
        System.out.println(jwt.getHeader(JWTHeader.TYPE));
        System.out.println(jwt.getPayload("uid"));
        System.out.println(jwt.getPayload("expire_time"));

        User user = new User();
        user.setUsername("三张");
        Map<String,Object> map = new HashMap<>();
        map.put("token","Bearer"+token);
        map.put("object", user);

        return RestUtils.success(map);
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
