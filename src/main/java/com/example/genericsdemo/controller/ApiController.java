package com.example.genericsdemo.controller;

import com.example.genericsdemo.context.AbstractApiContext;
import com.example.genericsdemo.response.BaseVo;
import com.example.genericsdemo.response.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApiController
 *
 * @author lixuan
 * @date 2024/5/15 11:12
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping
    public Result<? extends BaseVo> api(@RequestBody Object params) {
        if (params == null) {
            return Result.error("api.params.null", null);
        }
        return AbstractApiContext.openApi(params);
    }

}
