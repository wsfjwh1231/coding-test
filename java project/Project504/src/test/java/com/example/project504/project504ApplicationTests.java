package com.example.project504;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ClassUtils;

import java.io.File;

@SpringBootTest
class project504ApplicationTests {

    @Test
    void contextLoads() {
        File file = new File(ClassUtils.getDefaultClassLoader().getResource("").getPath());
        System.out.println("path= "+file.getPath());
    }


}
