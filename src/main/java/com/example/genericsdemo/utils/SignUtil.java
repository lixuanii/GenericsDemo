package com.example.genericsdemo.utils;

import com.example.genericsdemo.request.BaseDto;
import com.example.genericsdemo.response.BaseVo;
import com.example.genericsdemo.response.Result;


/**
 * SignUtil 验签
 *
 * @author lixuan
 * @date 2024/5/15 16:59
 */
public class SignUtil {

    /**
     * 验证基本参数与签名
     * 签名 = ElsaSecureUtil.getElsaEncode( appId + 秘钥 + 随机盐)
     *
     * @param baseDto 请求参数
     * @return 验证结果 true通过
     */
    public static Result<BaseVo> validationBaseAndSign(BaseDto baseDto) {
        // TODO: 2024/5/16 验签
        return Result.success();
    }
}
