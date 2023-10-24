package com.nav.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.nav.web.mapper")
public class NavWebApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(NavWebApplication.class, args);
    }


    /**
     * 工程打成war需要继承SpringBootServletInitializer，重写SpringApplicationBuilder 方法
     * @date 2020年3月5日
     * @author binge
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(NavWebApplication.class);
    }
}
