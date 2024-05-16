package com.example.genericsdemo.context;


import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import com.example.genericsdemo.err.ServiceException;
import com.example.genericsdemo.factory.ApiServiceStrategyFactory;
import com.example.genericsdemo.request.BaseDto;
import com.example.genericsdemo.response.BaseVo;
import com.example.genericsdemo.response.Result;
import com.example.genericsdemo.service.IApiService;
import com.example.genericsdemo.utils.SignUtil;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * AbstractApiContext
 *
 * @author lixuan
 * @date 2024/5/15 11:22
 */
@Component
public abstract class AbstractApiContext implements IApiService {

    private static final Validator VALIDATOR = SpringUtil.getBean(Validator.class);

    public static <T> Result<? extends BaseVo> openApi(T dto) {
        try {
            // 父类参数获取
            BaseDto baseDto = JSONUtil.toBean(JSONUtil.toJsonStr(dto), BaseDto.class);
            // 获取type, type == elsa.openapi.basic.warehouse.info
            String type = String.valueOf(baseDto.getInterfaceKey());
            // 获取请求参数实际类型
            Class<? extends BaseDto> realClass = DTO_CLASS_MAP.get(type);
            ServiceException.requireNonNull(realClass, "请检查interfaceType是否正确");
            // 实际参数转换
            BaseDto instance = JSONUtil.toBean(JSONUtil.toJsonStr(dto), realClass);
            // 1. 参数校验
            Result<BaseVo> result = validatorParams(instance);
            if (result.getCode() != 200) {
                return result;
            }
            // 2.验签
            result = SignUtil.validationBaseAndSign(baseDto);
            if (result.getCode() != 200) {
                return result;
            }
            // TODO: 2024/5/15 token校验


            // 截取至业务部分即可 == elsa.openapi.basic
            String serviceType = extractPrefix(type);
            IApiService apiService = ApiServiceStrategyFactory.API_SERVICE_MAP.get(serviceType);
            ServiceException.requireNonNull(apiService, "interfaceType错误！");
            // 3.service实现
            BaseVo resultVo = apiService.doSomething(type, instance);
            // 设值
            result.setData(resultVo);
            // 4.内容返回
            return result;
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }


    /***
     * 提取到第N个.之前的部分
     * @param: type
     * @param: nthDot
     * @return:
     * @date: 2024/5/15 16:15
     */
    private static String extractPrefix(String type) {
        int index = -1;
        for (int i = 0; i < 3; i++) {
            index = type.indexOf('.', index + 1);
            // 如果点的数量少于 nthDot，返回原始字符串
            if (index == -1) {
                return type;
            }
        }
        return type.substring(0, index);
    }


    /**
     * 验证请求参数
     *
     * @param baseDto 验证对象
     * @param <T>     泛型支持
     * @return 验证结果
     */
    private static <T extends BaseDto> Result<BaseVo> validatorParams(T baseDto) {
        Set<ConstraintViolation<T>> violationSet = VALIDATOR.validate(baseDto);
        //验证不通过
        if (!violationSet.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            // 读取错误消息
            for (ConstraintViolation<? extends BaseDto> cv : violationSet) {
                sb.append(cv.getPropertyPath()).append(cv.getMessage()).append(" | ");
            }
            //删除最后一个 | ，并返回结果
            return Result.paramsError(sb.delete(sb.length() - 3, sb.length()).toString());
        }
        return Result.success();
    }
}
