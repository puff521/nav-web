package com.nav.web.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author puff
 **/
@Component
@Data
//@Builder
@ToString
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {

    private Integer code;

    private T data;

    private String msg;

    private Integer total;

    public static <T> Result<T> success() {
        return success(null);
    }

    public Result(String msg) {
        this.code= ResultCode.CUSTOM.getCode();
        this.msg = msg;
    }

    public Result() {

    }

    public static <T> Result<T> success(T data) {
        ResultCode rce = ResultCode.SUCCESS;
//        if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
//            rce = ResultCode.FAIL;
//        }
        return result(rce, data);
    }



    public static <T> Result<T> success(T data, Long total) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(data);
        result.setTotal(total.intValue());
        return result;
    }

    public static <T> Result<T> getPageSuccess(T data, Long total) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(data);
        result.setTotal(total.intValue());
        return result;
    }



    public static <T> Result<T> failed() {
        return result(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMsg(), null);
    }

    public static <T> Result<T> failed(String msg) {
        return result(ResultCode.FAIL.getCode(), msg, null);
    }

    public static <T> Result<T> failed(Integer code,String msg) {
        return result(code, msg, null);
    }

    public static <T> Result<T> judge(boolean status) {
        if (status) {
            return success();
        } else {
            return failed();
        }
    }

    public static <T> Result<T> failed(IResultCode resultCode) {
        return result(resultCode.getCode(), resultCode.getMsg(), null);
    }

    public static <T> Result<T> failed(IResultCode resultCode, String msg) {
        return result(resultCode.getCode(), msg, null);
    }

    private static <T> Result<T> result(IResultCode resultCode, T data) {
        return result(resultCode.getCode(), resultCode.getMsg(), data);
    }

    private static <T> Result<T> resultMsg(IResultCode resultCode, String msg) {
        return result(resultCode.getCode(), msg, null);
    }

    private static <T> Result<T> result(Integer code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public static boolean isSuccess(Result<?> result) {
        return result != null && ResultCode.SUCCESS.getCode().equals(result.getCode());
    }

}
