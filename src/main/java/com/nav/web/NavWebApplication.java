package com.nav.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nav.web.mapper")
public class NavWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(NavWebApplication.class, args);
    }

}
