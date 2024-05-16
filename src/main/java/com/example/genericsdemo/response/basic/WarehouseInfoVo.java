package com.example.genericsdemo.response.basic;

import com.example.genericsdemo.response.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 仓库详情
 *
 * @author lixuan
 * @date 2024/5/15 16:38
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WarehouseInfoVo extends BaseVo {

    /**
     * 仓库编码
     */
    private String warehouseCode;

    /**
     * 仓库名称
     */
    private String warehouseName;

    /**
     * 仓库地址
     */
    private String warehouseAddress;

    /**
     * 仓库联系人
     */
    private String warehouseContact;

    /**
     * 仓库联系人电话
     */
    private String warehouseContactPhone;

}
