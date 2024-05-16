package com.example.genericsdemo.service.impl;

import com.example.genericsdemo.context.AbstractApiContext;
import com.example.genericsdemo.constant.ApiKeyConstant;
import com.example.genericsdemo.pojo.BsnWarehouse;
import com.example.genericsdemo.request.basic.WarehouseGroupListDto;
import com.example.genericsdemo.request.basic.WarehouseInfoDto;
import com.example.genericsdemo.response.basic.WarehouseGroupListVo;
import com.example.genericsdemo.response.basic.WarehouseInfoVo;
import org.springframework.stereotype.Service;


/**
 * 基础业务实现
 *
 * @author lixuan
 * @date 2024/5/15 16:31
 */
@Service
public class ApiBasicServiceImpl extends AbstractApiContext {


    {
        // 查询系统仓群   elsa.openapi.basic.warehouse.groups
        EVENT_MAP.put(ApiKeyConstant.WMS_WAREHOUSE_GROUPS_KEY, baseDto -> getWarehouseGroupList((WarehouseGroupListDto) baseDto));
        DTO_CLASS_MAP.put(ApiKeyConstant.WMS_WAREHOUSE_GROUPS_KEY, WarehouseGroupListDto.class);

        // 查询系统仓库详情  elsa.openapi.basic.warehouse.info
        EVENT_MAP.put(ApiKeyConstant.WMS_WAREHOUSE_INFO_KEY, baseDto -> getWarehouseInfo((WarehouseInfoDto) baseDto));
        DTO_CLASS_MAP.put(ApiKeyConstant.WMS_WAREHOUSE_INFO_KEY, WarehouseInfoDto.class);

    }


    /***
     * 查询系统仓群
     * @param: warehouseGroupListDto
     * @return:
     * @date: 2024/5/16 13:46
     */
    public WarehouseGroupListVo getWarehouseGroupList(WarehouseGroupListDto warehouseGroupListDto) {
        // TODO: 2024/5/15  查询系统仓群
        return new WarehouseGroupListVo();
    }


    /***
     * 查询系统仓库详情
     * @param: warehouseInfoDto 查询条件
     * @return: 仓库详情内容
     * @date: 2024/5/15 17:23
     */
    public WarehouseInfoVo getWarehouseInfo(WarehouseInfoDto warehouseInfoDto) {
        // service.getWarehouseInfo(warehouseInfoDto)
        BsnWarehouse warehouse = new BsnWarehouse();
        if (warehouse == null) {
            return null;
        }
        WarehouseInfoVo warehouseInfoVo = new WarehouseInfoVo();
        warehouseInfoVo.setWarehouseCode(warehouse.getWhCode());
        warehouseInfoVo.setWarehouseName(warehouse.getWhName());
        warehouseInfoVo.setWarehouseAddress(warehouse.getAddress());
        warehouseInfoVo.setWarehouseContact(warehouse.getContact());
        warehouseInfoVo.setWarehouseContactPhone(warehouse.getContactPhone());
        return warehouseInfoVo;
    }


}
