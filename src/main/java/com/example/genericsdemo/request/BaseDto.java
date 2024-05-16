package com.example.genericsdemo.request;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


/***
 * 接口请求参数基类
 * @date: 2024/5/16 16:48
 */
@Data
public class BaseDto implements Serializable {


    @NotBlank(message = "接口Key interfaceType，不能为空！")
    private String interfaceKey;

    @NotBlank(message = "签名 sign，不能为空！")
    private String sign;
}
