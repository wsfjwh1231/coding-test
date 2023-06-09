package com.example.testdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2//开启Swagger2
@MapperScan("com.example.testdemo.mybatisPlusTest.mapper")
public class TestDemoApplication  {

    public static void main(String[] args) {
        SpringApplication.run(TestDemoApplication.class, args);
    }


}
