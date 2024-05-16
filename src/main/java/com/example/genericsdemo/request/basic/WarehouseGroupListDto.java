package com.example.genericsdemo.request.basic;

import com.example.genericsdemo.request.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 获取仓群列表
 *
 * @author lixuan
 * @date 2024/5/15 16:42
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WarehouseGroupListDto extends BaseDto {

    private String warehouseCode;
}
