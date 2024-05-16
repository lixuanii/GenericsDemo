package com.example.genericsdemo.factory;


import cn.hutool.extra.spring.SpringUtil;
import com.example.genericsdemo.service.IApiService;
import com.example.genericsdemo.service.impl.ApiBasicServiceImpl;
import com.example.genericsdemo.service.impl.ApiFeeServiceImpl;
import com.example.genericsdemo.service.impl.ApiInventoryServiceImpl;
import com.example.genericsdemo.service.impl.ApiOrderExStorageServiceImpl;
import com.example.genericsdemo.service.impl.ApiOrderInStorageServiceImpl;
import com.example.genericsdemo.service.impl.ApiProductServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * 模块策略
 *
 * @author lixuan
 * @date 2024/5/16 9:06
 */
public class ApiServiceStrategyFactory {

    public static final Map<String, IApiService> API_SERVICE_MAP = new HashMap<>();


    static {
        // key: elsa.openapi.模块.业务.执行
        // 产品业务模块
        API_SERVICE_MAP.put("elsa.openapi.wms", SpringUtil.getBean(ApiProductServiceImpl.class));
        // 基础业务模块
        API_SERVICE_MAP.put("elsa.openapi.basic", SpringUtil.getBean(ApiBasicServiceImpl.class));
        // 费用业务模块
        API_SERVICE_MAP.put("elsa.openapi.fee", SpringUtil.getBean(ApiFeeServiceImpl.class));
        // 出库单业务模块
        API_SERVICE_MAP.put("elsa.openapi.exStorage", SpringUtil.getBean(ApiOrderExStorageServiceImpl.class));
        // 入库单业务模块
        API_SERVICE_MAP.put("elsa.openapi.inStorage", SpringUtil.getBean(ApiOrderInStorageServiceImpl.class));
        // 库存业务模块
        API_SERVICE_MAP.put("elsa.openapi.inventory", SpringUtil.getBean(ApiInventoryServiceImpl.class));
    }
}
