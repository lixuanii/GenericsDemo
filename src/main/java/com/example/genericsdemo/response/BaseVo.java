package com.example.genericsdemo.response;

import lombok.Data;

/**
 * api返回值
 *
 * @author lixuan
 * @date 2024/5/15 11:20
 */
@Data
public class BaseVo {

    private String serverCode = "ELSA";

    private String serverName = "链仓科技";
}
