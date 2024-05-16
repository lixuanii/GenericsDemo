package com.example.genericsdemo.err;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

import java.io.Serial;
import java.util.Collection;

/**
 * 业务异常
 *
 * @author ruoyi
 */
public final class ServiceException extends RuntimeException {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String message;


    private String detailMessage;

    /**
     * 空构造方法，避免反序列化问题
     */
    public ServiceException() {
    }

    public ServiceException(String message) {
        this.message = message;
    }


    /**
     * 为 null 则 抛出异常
     */
    public static void requireNonNull(Object obj, String msgKey) {
        requireFalse(obj == null, msgKey);
    }

    /**
     * @see ObjectUtil#isEmpty(Object)
     * 为 Empty 则 抛出异常
     */
    public static void requireNonEmpty(Object obj, String msgKey) {
        requireFalse(ObjectUtil.isEmpty(obj), msgKey);
    }

    /**
     * str为 blank 则抛出异常
     */
    public static void requireNonBlank(String str, String msgKey) {
        requireFalse(StrUtil.isBlank(str), msgKey);
    }

    /**
     * 集合为 Empty 则 抛出异常
     */
    public static void requireCollNonEmpty(Collection<?> collection, String msgKey) {
        requireFalse(CollUtil.isEmpty(collection), msgKey);
    }

    /**
     * 为 false 则 抛出异常
     */
    public static void requireTrue(boolean flag, String msgKey) {
        if (!flag) {
            throwException(msgKey);
        }
    }

    /**
     * 为 true 则 抛出异常
     */
    public static void requireFalse(boolean flag, String msgKey) {
        if (flag) {
            throwException(msgKey);
        }
    }


    private static void throwException(String messageKey) {
        throw new ServiceException(messageKey);
    }

    public ServiceException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    /**
     * 新增构造方法
     */
    public ServiceException(String message, String detailMessage) {
        this.message = message;
        this.detailMessage = detailMessage;
    }


    public String getDetailMessage() {
        return detailMessage;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public ServiceException setMessage(String message) {
        this.message = message;
        return this;
    }

    public ServiceException setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
        return this;
    }
}