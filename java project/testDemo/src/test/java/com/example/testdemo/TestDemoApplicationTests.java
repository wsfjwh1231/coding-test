package com.example.testdemo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.example.testdemo.test.DemoObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TestDemoApplicationTests {

    @Autowired
    private DemoObject demoObject;

    @Test
    void contextLoads() {
        String[] tables = {"address", "banner", "brand", "category", "channel", "comment", "commentpic",
                "coupon", "goods", "goodsadtion", "goodscard", "goodsgallery", "introduceinfo",
                "issue", "products", "querytable", "specifications", "topic", "user", "users"};
        //数据源配置
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/webstore", "root", "123456")
                //全局配置
                .globalConfig(builder -> {
                    // 设置作者
                    builder.author("author")
                            // 开启 swagger 模式
                            .enableSwagger()
                            // 覆盖已生成文件
//                            .fileOverride()
                            // 指定输出目录
                            .outputDir("D:\\java\\testDemo\\src\\main\\java")
                            // 注释日期
                            .commentDate("yyyy-MM-dd");
                })

                //包配置
                .packageConfig(builder -> {
                    // 设置父包名
                    builder.parent("com.example.testdemo");
                })

                //策略配置
                .strategyConfig(builder -> {
                    //遍历所有表名
                    for (String table1 : tables) {
                        builder.addInclude(table1)

                                // 设置过滤表前缀
                                .addTablePrefix("t_")
                                //使用Lombok
                                .entityBuilder().enableLombok();

                    }

                })

                //模板引擎配置
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                //执行生成
                .execute();
    }

    //  切面测试类
    @Test
    void aopTest() {
        demoObject.run();
    }

}
