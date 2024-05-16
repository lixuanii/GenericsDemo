package com.example.genericsdemo.request.basic;

import com.example.genericsdemo.request.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * WarehouseInfoDto
 *
 * @author lixuan
 * @date 2024/5/15 16:43
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WarehouseInfoDto extends BaseDto {

    @NotBlank(message = "warehouseCode is null")
    private String warehouseCode;
}
