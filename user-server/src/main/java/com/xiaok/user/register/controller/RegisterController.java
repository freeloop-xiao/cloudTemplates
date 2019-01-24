package com.xiaok.user.register.controller;

import com.xiaok.common.util.ParamUtil;
import com.xiaok.common.vo.ResultMessage;
import com.xiaok.user.register.service.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-22
 * Time: 16:31
 */
@Api(description = "登录认证接口")
@RestController
@RequestMapping("/api/v1")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @ApiOperation(value = "注册接口", notes = "注册接口")
    @RequestMapping(value = "/register/{appId}", method = RequestMethod.POST)
    public ResultMessage<String> register(@ApiParam("手机号") @RequestParam String phone,
                                          @ApiParam("验证码") @RequestParam String smsCode,
                                          @ApiParam("应用id") @PathVariable String appId) {
        ParamUtil.checkParams(phone, smsCode, appId);
        return registerService.register(phone, smsCode, appId);
    }
}