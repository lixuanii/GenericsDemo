package com.example.genericsdemo.response.basic;

import com.example.genericsdemo.response.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统仓群
 *
 * @author lixuan
 * @date 2024/5/15 16:36
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WarehouseGroupListVo extends BaseVo {

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
}
