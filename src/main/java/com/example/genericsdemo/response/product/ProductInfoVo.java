package com.example.genericsdemo.response.product;

import com.example.genericsdemo.response.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品信息
 *
 * @author lixuan
 * @date 2024/5/15 11:25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductInfoVo extends BaseVo {

    private String name;

    private String sku;
}
