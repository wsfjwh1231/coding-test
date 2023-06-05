package com.example.testdemo.bean;

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
