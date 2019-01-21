package com.xiaok.user.login.controller;

import com.netflix.ribbon.proxy.annotation.Http;
import com.xiaok.common.vo.AuthMessage;
import com.xiaok.common.vo.ResultMessage;
import com.xiaok.user.login.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-21
 * Time: 15:20
 */
@Api(description = "登录认证接口")
@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录接口", notes = "登录接口")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultMessage<AuthMessage> login(@ApiParam("账户") @RequestParam String account,
                                            @ApiParam("密码") @RequestParam String password) {
        System.out.println("账户：" + account);
        System.out.println("密码：" + password);
        return loginService.login(account,password);
    }


    @ApiOperation(value = "刷新token接口", notes = "刷新token接口")
    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public ResultMessage<AuthMessage> refresh(@ApiParam("refreshToken") @RequestParam String refreshToken) {
        return null;
    }


    @ApiOperation(value = "退出接口", notes = "退出接口")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResultMessage<String> logout(@ApiParam("token") @RequestHeader String token) {
        return null;
    }
}
