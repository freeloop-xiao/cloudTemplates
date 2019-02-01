package com.xiaok.user.verify.controller;

import com.xiaok.common.util.ParamUtil;
import com.xiaok.common.vo.ResultMessage;
import com.xiaok.user.verify.service.VerifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-25
 * Time: 16:09
 */
@Api(description = "token验证接口")
@RestController
@RequestMapping("/api/v1")
public class VerifyController {

    @Autowired
    private VerifyService verifyService;

    @ApiOperation(value = "验证接口", notes = "验证接口")
    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public ResultMessage<String> verify(@ApiParam("token") @RequestParam String token) {
        ParamUtil.checkParams(token);
        return verifyService.verify(token);
    }

}
