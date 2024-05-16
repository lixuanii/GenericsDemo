package com.example.genericsdemo.response;


import cn.hutool.http.HttpStatus;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lixua
 */
@Data
public class Result<T> implements Serializable {
    private int code;

    private String msg;

    private T data;


    public Result() {
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private static <T> Result<T> restResult(int code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success() {
        return Result.success("success", null);
    }

    public static <T> Result<T> success(T data) {
        return Result.success("success", data);
    }

    public static <T> Result<T> success(String msg, T data) {
        return restResult(HttpStatus.HTTP_OK, msg, data);
    }

    public static <T> Result<T> error(String msg) {
        return Result.error(msg, null);
    }

    public static <T> Result<T> error(String msg, T data) {
        return restResult(HttpStatus.HTTP_INTERNAL_ERROR, msg, data);
    }

    public static <T> Result<T> paramsError(String msg) {
        return restResult(HttpStatus.HTTP_BAD_REQUEST, msg, null);
    }

}
