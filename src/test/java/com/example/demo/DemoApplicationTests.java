package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author
 */

@SpringBootApplication
@MapperScan("ugarmgp.demo.mapper")
public class DemoApplicationTests {

    @Test
    void contextloads() {
    }


}
