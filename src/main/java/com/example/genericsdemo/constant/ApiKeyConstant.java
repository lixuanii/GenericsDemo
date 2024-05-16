package com.example.genericsdemo.constant;

/**
 * ApiKeyConstance
 *
 * @author lixuan
 * @date 2024/5/16 13:35
 */
public class ApiKeyConstant {


    /***
     * 基础模块
     */
    public static final String API_SERVICE_MODULE_BASIC = "elsa.openapi.basic";
    /***
     * 仓库详情
     */
    public static final String WMS_WAREHOUSE_INFO_KEY = API_SERVICE_MODULE_BASIC + ".warehouse.info";
    /***
     * 仓群
     */
    public static final String WMS_WAREHOUSE_GROUPS_KEY = API_SERVICE_MODULE_BASIC + ".warehouse.groups";


    /***
     * wms模块
     */
    public static final String API_SERVICE_MODULE_WMS = "elsa.openapi.wms";


    /***
     * 费用模块
     */
    public static final String API_SERVICE_MODULE_FEE = "elsa.openapi.fee";


    /***
     * 出库单模块
     */
    public static final String API_SERVICE_MODULE_EX_STORAGE = "elsa.openapi.exStorage";


    /***
     * 入库单模块
     */
    public static final String API_SERVICE_MODULE_IN_STORAGE = "elsa.openapi.inStorage";


    /***
     * 库存模块
     */
    public static final String API_SERVICE_MODULE_INVENTORY = "elsa.openapi.inventory";


}
