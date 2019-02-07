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
@Api(description = "用户管理接口")
@RestController
@RequestMapping("/api/v1/user")
public class UserManagerController {

    @Autowired
    private UserManagerService userManagerService;


    @ApiOperation(value = "用户锁定接口", notes = "用户锁定接口")
    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public ResultMessage<String> change(@RequestHeader("Authorization") String token,
                                        @ApiParam("别名") String userAlias,
                                        @ApiParam("手机号") String phone,
                                        @ApiParam("性别：0-女 1-男") Short sex,
                                        @ApiParam("证件类型 1-身份证") Short idCardType,
                                        @ApiParam("证件号码") String idCardNo,
                                        @ApiParam("生日") String birthday,
                                        @ApiParam("邮件") String email,
                                        @ApiParam("省") String prov,
                                        @ApiParam("市") String city,
                                        @ApiParam("区") String area) {
        DecodedJWT decodedJWT = JwtUtil.verifyToken(token);
        String userId = JwtUtil.getJwtParam(JwtUtil.USER_ID, decodedJWT);
        userManagerService.change(userId, userAlias, phone, sex, idCardType, idCardNo, birthday, email, prov, city, area);
        return new ResultMessage<>("0000", "修改成功!");
    }


    @ApiOperation(value = "用户锁定接口", notes = "用户锁定接口")
    @RequestMapping(value = "/lock", method = RequestMethod.POST)
    public ResultMessage<String> lock(@RequestHeader("Authorization") String token) {
        DecodedJWT decodedJWT = JwtUtil.verifyToken(token);
        String userId = JwtUtil.getJwtParam(JwtUtil.USER_ID, decodedJWT);
        userManagerService.lock(userId);
        return new ResultMessage<>("0000", "锁定成功!");
    }


    @ApiOperation(value = "用户注销接口", notes = "用户注销接口")
    @RequestMapping(value = "/cancel", method = RequestMethod.DELETE)
    public ResultMessage<String> cancel(@RequestHeader("Authorization") String token) {
        DecodedJWT decodedJWT = JwtUtil.verifyToken(token);
        String userId = JwtUtil.getJwtParam(JwtUtil.USER_ID, decodedJWT);
        userManagerService.cancel(userId);
        return new ResultMessage<>("0000", "注销成功!");
    }
}
