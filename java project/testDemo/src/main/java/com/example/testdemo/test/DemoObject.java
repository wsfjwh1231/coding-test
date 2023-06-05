package com.example.testdemo.test;

import org.springframework.stereotype.Component;

@Component
public class DemoObject {
    public void run() {
        System.out.println("DemoObject.run()");
    }

    public Result getNowTime() {
        return new Result();
    }

}
