package com.xiaok.user.register.controller;

import com.xiaok.common.util.ParamUtil;
import com.xiaok.common.vo.ResultMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-22
 * Time: 17:39
 */
@Api(description = "登录认证接口")
@RestController
@RequestMapping("/api/v1")
public class RealNameController {

    @ApiOperation(value = "实名认证第一步", notes = "实名认证第一步")
    @RequestMapping(value = "/realFirst/{appId}", method = RequestMethod.POST)
    public ResultMessage<String> realFist(@ApiParam("手机号") @RequestParam String phone,
                                          @ApiParam("性别 0: 女 1:男") @RequestParam Short sex,
                                          @ApiParam("证件类型 1：身份证") @RequestParam Short idCardType,
                                          @ApiParam("证件号码") @RequestParam Short idCardNo,
                                          @ApiParam("出生日期") @RequestParam String birthday,
                                          @ApiParam("邮箱地址") @RequestParam String email,
                                          @ApiParam("应用id") @PathVariable String appId) {
        ParamUtil.checkParams(phone, idCardNo, birthday, email, appId);
        ParamUtil.checkParams(sex, idCardType);
        return null;
    }

    @ApiOperation(value = "实名认证第一步", notes = "实名认证第一步")
    @RequestMapping(value = "/realSecond/{appId}", method = RequestMethod.POST)
    public ResultMessage<String> realSecond(@ApiParam("手机号") @RequestParam String phone,
                                            @ApiParam("省") @RequestParam String prov,
                                            @ApiParam("市") @RequestParam String city,
                                            @ApiParam("区") @RequestParam String area,
                                            @ApiParam("应用id") @PathVariable String appId) {
        ParamUtil.checkParams(phone, prov, city, area, appId);
        return null;
    }
}
