package com.xf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xf.mapper")
public class DdupRun {

    public static void main(String[] args) {
        SpringApplication.run(DdupRun.class, args);
    }

}
