package com.nav.web.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * 当请求状态400,401,404,500时，跳转到指定页面
 */
@Configuration
public class ErrorPageConf implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage page400 = new ErrorPage(HttpStatus.BAD_REQUEST, "/html/404.html");
        ErrorPage page401 = new ErrorPage(HttpStatus.UNAUTHORIZED, "/3rd/404.html");
        ErrorPage page404 = new ErrorPage(HttpStatus.NOT_FOUND, "/3rd/404.html");
        ErrorPage page500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/3rd/500.html");

        registry.addErrorPages(page400,page401,page404,page500);
    }
}

