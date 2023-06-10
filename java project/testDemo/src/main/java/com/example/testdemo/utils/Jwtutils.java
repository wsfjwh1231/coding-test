package com.example.testdemo.utils;

import com.auth0.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Jwtutils {
    public static final String SECRET_KEY = "your_secret_key";
    // 计算24小时的毫秒数。1000 毫秒（1 秒）* 60（1 分钟）* 60（1 小时）* 24（1 天
    private static final long EXPIRATION_TIME = 1000 * 10;

    public static String generateToken(String username,int isAdmin) {

//      设置过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
//      私钥和加密算法
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
//      设置头部信息
        Map<String, Object> header = new HashMap<>(2);
        header.put("type", "JWT");
        header.put("alg", "HS256");
//      返回token字符串
        return JWT.create()
                .withHeader(header)
                .withClaim("uid", username)
                .withClaim("isAdmin",isAdmin)
                .withExpiresAt(date)
                .sign(algorithm);

    }

    public static Map verify(String token) {
        Map<String,Object> map = new HashMap<>();
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            map.put("uid",jwt.getClaim("uid").asString());
            map.put("isAdmin",jwt.getClaim("isAdmin").asInt());
            map.put("isError",0);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isError",1);
            return map;
        }
    }
}
