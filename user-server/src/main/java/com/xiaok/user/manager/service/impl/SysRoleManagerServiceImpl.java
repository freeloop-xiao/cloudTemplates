package com.xiaok.user.manager.service.impl;

import com.xiaok.common.vo.ResultMessage;
import com.xiaok.user.common.dao.SysRoleMapper;
import com.xiaok.user.common.entity.SysRole;
import com.xiaok.user.manager.service.SysRoleManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleManagerServiceImpl implements SysRoleManagerService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public ResultMessage<String> add(String roleName, String roleDesc, String remark) {
        SysRole role = new SysRole();
        role.setRoleName(roleName);
        role.setRoleDesc(roleDesc);
        role.setRemark(remark);
        sysRoleMapper.insertSelective(role);
        return ResultMessage.newSuccess("添加角色成功!");
    }

    @Override
    public ResultMessage<String> change(Integer roleId, String roleName, String roleDesc, String remark) {
        SysRole role = new SysRole(roleId,roleName,null,roleDesc,remark);
        sysRoleMapper.updateByPrimaryKey(role);
        return ResultMessage.newSuccess("修改角色成功！");
    }

    @Override
    public ResultMessage<String> del(Integer roleId) {
         sysRoleMapper.deleteByPrimaryKey(roleId);
         return ResultMessage.newSuccess("删除角色成功!");
    }

    @Override
    public ResultMessage<List<SysRole>> query(Integer roleId, String roleName,Integer start,Integer limit) {
        List<SysRole> list = sysRoleMapper.selectBySelective(new SysRole(roleId,roleName));
        ResultMessage<List<SysRole>> resultMessage = new ResultMessage<>("0000","获取角色成功！");
        resultMessage.setData(list);
        return resultMessage;
    }
}
