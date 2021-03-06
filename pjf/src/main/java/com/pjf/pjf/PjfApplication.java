package com.pjf.pjf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pjf.pjf.mapper")
public class PjfApplication {

    public static void main(String[] args) {
        SpringApplication.run(PjfApplication.class, args);
    }

}
