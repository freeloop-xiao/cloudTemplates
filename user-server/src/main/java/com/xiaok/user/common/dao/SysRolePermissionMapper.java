package com.xiaok.user.common.dao;

import com.xiaok.user.common.entity.SysRolePermissionKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(SysRolePermissionKey key);

    int insert(SysRolePermissionKey record);

    int insertSelective(SysRolePermissionKey record);
}