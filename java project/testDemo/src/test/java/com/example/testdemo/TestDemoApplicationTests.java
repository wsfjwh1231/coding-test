package com.example.testdemo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class TestDemoApplicationTests {

    @Test
    void contextLoads() {
        String url = "jdbc:mysql://localhost:3306/webdb";
        String username = "root123";
        String password = "root123";
        String modelname = "weburl";
//        String tables = "base_url,err_level";
        String tables = "user";
        String mapperUrl = "D:\\java\\demo_websrv\\src\\main\\resources\\"+modelname ;
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("author") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\java\\demo_websrv\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.webgrd") // 设置父包名
                            .moduleName(modelname) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml,mapperUrl)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables) // 设置需要生成的表名
                            .addTablePrefix("t_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }

}
