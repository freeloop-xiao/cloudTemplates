package com.xiaok.user.manager.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.xiaok.common.vo.ResultMessage;
import com.xiaok.user.common.util.JwtUtil;
import com.xiaok.user.manager.service.UserManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * author: xiao
 * date:   2019/2/7
 * desc:
 */
@Api(description = "用户管理后台接口")
@RestController
@RequestMapping("/api/v1/user")
public class UserManagerController {

    @Autowired
    private UserManagerService userManagerService;


    @ApiOperation(value = "用户锁定接口", notes = "用户锁定接口")
    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public ResultMessage<String> change(@ApiParam("用户id") String userId,
                                        @ApiParam("别名") String userAlias,
                                        @ApiParam("手机号") String phone,
                                        @ApiParam("性别：0-女 1-男") Short sex,
                                        @ApiParam("证件类型 1-身份证") Short idCardType,
                                        @ApiParam("证件号码") String idCardNo,
                                        @ApiParam("生日YYYY-MM-DD") String birthday,
                                        @ApiParam("邮件") String email,
                                        @ApiParam("省编码") String provCode,
                                        @ApiParam("市编码") String cityCode,
                                        @ApiParam("区编码") String areaCode) {
        userManagerService.change(userId, userAlias, phone, sex, idCardType, idCardNo, birthday, email, provCode, cityCode, areaCode);
        return new ResultMessage<>("0000", "修改成功!");
    }


    @ApiOperation(value = "用户锁定接口", notes = "用户锁定接口")
    @RequestMapping(value = "/lock", method = RequestMethod.POST)
    public ResultMessage<String> lock(@ApiParam("用户id") String userId) {
        userManagerService.lock(userId);
        return new ResultMessage<>("0000", "锁定成功!");
    }


    @ApiOperation(value = "用户注销接口", notes = "用户注销接口")
    @RequestMapping(value = "/cancel", method = RequestMethod.DELETE)
    public ResultMessage<String> cancel(@ApiParam("用户id") String userId) {
        userManagerService.cancel(userId);
        return new ResultMessage<>("0000", "注销成功!");
    }
}
