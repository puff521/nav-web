package com.nav.web.common.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Objects;

/**
 * 安全工具类
 *
 * @author colin
 */
@UtilityClass
@Slf4j
public class SecurityUtils {

    private static final String DOMAIN_PREFIX_HTTP = "http://";
    private static final String DOMAIN_PREFIX_HTTPS = "https://";
    private static final String DOMAIN_CUT = "/";


    /**
     * 获取头字段信息
     */
    public static String getHeader(String key) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            //判断是否还有下一个元素
            String nextElement = headerNames.nextElement();
            //获取headerNames集合中的请求头
            String header2 = request.getHeader(nextElement);
            //通过请求头得到请求内容
            log.debug("工具类打印请求头========={}, VALUE:{}", nextElement, header2);
        }

        String strKey = request.getHeader(key);
        log.debug("打印出来的header值{}, {}", key, strKey);
        return strKey;
    }


}
