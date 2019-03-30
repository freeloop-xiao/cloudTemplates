package com.xiaok.user.manager.controller;

import com.xiaok.common.vo.ResultMessage;
import com.xiaok.user.manager.service.SysRoleManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: xiao
 * date:   2019/2/7
 * desc:
 */
@Api(description = "系统角色管理后台接口")
@RestController
@RequestMapping("/api/v1/role")
public class SysRoleManagerController {

    @Autowired
    private SysRoleManagerService sysRoleManagerService;

    @ApiOperation(value = "添加角色", notes = "添加角色")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultMessage<String> add(@ApiParam("角色名称") String roleName,@ApiParam("角色描叙") String roleDesc,@ApiParam("remark") String remark) {
        return sysRoleManagerService.add(roleName,roleDesc,remark);
    }

}
