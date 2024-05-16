package com.example.genericsdemo.service;

import com.example.genericsdemo.err.ServiceException;
import com.example.genericsdemo.request.BaseDto;
import com.example.genericsdemo.response.BaseVo;
import lombok.val;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * IApiService
 *
 * @author lixuan
 * @date 2024/5/15 12:06
 */
public interface IApiService {

    /**
     * service做为业务模块区分。一个业务可以处理很多件事情。（多个处理方法）
     */
    Map<String, Function<BaseDto, ? extends BaseVo>> EVENT_MAP = new HashMap<>();

    /***
     * 真实类
     */
    Map<String, Class<? extends BaseDto>> DTO_CLASS_MAP = new HashMap<>();

    /***
     * 执行
     * @param: type 路径key
     * @param: dto 请求参数
     * @return: BaseApiVo子类
     * @date: 2024/5/15 17:16
     */
    @SuppressWarnings("unchecked")
    default <T extends BaseDto, R extends BaseVo> R doSomething(String type, T dto) {
        ServiceException.requireNonNull(type, "interfaceType为空！");
        ServiceException.requireNonNull(dto, "baseDto为空！");
        val function = EVENT_MAP.get(type);
        ServiceException.requireNonNull(function, "interfaceType错误！");
        return (R) function.apply(dto);
    }
}
