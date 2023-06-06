package com.example.testdemo.utils;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Jwtutils {
    public static final String SECRET_KEY = "your_secret_key";
    // 计算1天的毫秒数。1000 毫秒（1 秒）* 60（1 分钟）* 60（1 小时）* 24（1 天
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 *24;

    public static String generateToken(String username) {
        Map<String,Object> hashMap = new HashMap();
        hashMap.put("uid",username);
        hashMap.put("expire_time",System.currentTimeMillis() + EXPIRATION_TIME);

//      createToken 方法使用给定的有效载荷(payload)和密钥生成一个 JWT，并返回该 JWT 的字符串表示。这个 JWT 可以用于身份验证和授权等场景。
        return JWTUtil.createToken(hashMap,SECRET_KEY.getBytes());
    }

    public static JWT parseToken(String token) {
        final JWT jwt = JWTUtil.parseToken(token);
        System.out.println("jwt: "+jwt);
       return jwt;
    }
}
