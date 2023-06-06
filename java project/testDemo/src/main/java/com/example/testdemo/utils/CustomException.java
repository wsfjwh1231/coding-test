package com.example.testdemo.utils;

import com.example.testdemo.test.Result;

//自定义异常工具类
public class CustomException extends RuntimeException{
    private final Result result;

    public CustomException(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }
}
