package com.xiaok.gateway.common.verity;

import com.xiaok.common.util.ParamUtil;
import com.xiaok.common.vo.ResultMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * author: xiao
 * date:   2019/2/1
 * desc:
 */
@FeignClient(name = "spring-cloud-user",fallback = VerifyFallback.class)
@RequestMapping(value = "/api/v1")
public interface VerifyClient {

    @ApiOperation(value = "远程验证接口", notes = "远程验证接口")
    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    ResultMessage<String> verify(@RequestParam("token") String token);

}