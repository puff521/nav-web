package com.nav.web.common.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author puff
 * @date 2020-06-23
 **/
@AllArgsConstructor
@NoArgsConstructor
public enum ResultCode implements IResultCode, Serializable {

    FAIL(-2,"fail"),
    ERROR(-1, "error"),
    SUCCESS(0, "success"),
    AUTHENTICATION_NOPASS(1, "登录已过期，请重新登录"),
    AUTHORIZATION_NOPASS(2, "授权失败"),
    GOOGLEAUTH_NOPASS(3, "谷歌身份验证码错误"),
    REQUEST_LIMIT(4, "规定时间超过请求次数"),
    RISK(6, "风险操作"),
    EMPTY_TWITHDRAWMONEY(7, "未设置交易密码"),
    MULTIDEVICE(8, "帐号已在其他设备登录,请重新登录"),
    PLATFORM_MAINTAIN(9, "平台维护中"),
    UN_BIND_BANKCARD(10, "请先绑定银行卡后再充值"),

    OSS_DELETE_ERROR(80103, "图片删除失败"),

    //业务级代码（101-999）
    PARAMETER_NOTNULLL(101, "参数必填"),

    PARAM_ERROR(101, "请求参数错误"),
    CUSTOM(999, "自定义");


    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    private Integer code;

    private String msg;

    @Override
    public String toString() {
        return "{" +
                "\"code\":\"" + code + '\"' +
                ", \"msg\":\"" + msg + '\"' +
                '}';
    }

    public static ResultCode getValue(Integer code) {
        for (ResultCode value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return ERROR; // 默认系统执行错误
    }


}
