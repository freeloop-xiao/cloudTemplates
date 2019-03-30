package com.xiaok.user.manager.service;

import com.xiaok.common.vo.ResultMessage;
import com.xiaok.user.common.entity.SysRole;

import java.util.List;

/**
 * 角色管理接口
 */
public interface SysRoleManagerService {

    ResultMessage<String> add(String roleName,String roleDesc,String remark);

    ResultMessage<String> change(Integer roleId,String roleName,String roleDesc,String remark);

    ResultMessage<String> del(Integer roleId);

    ResultMessage<List<SysRole>> query(Integer roleId,String roleName,Integer start,Integer limit);
}
