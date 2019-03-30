package com.xiaok.user.common.dao;

import com.xiaok.user.common.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysUserMapper {

    int deleteByPrimaryKey(String userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPhoneAndAppId(@Param("phone") String phone, @Param("appId") String appId);

    SysUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    int updateLockedByPrimaryKey(@Param("userId") String userId, @Param("lockFlag") Short lockFlag);

    int updateDelByPrimaryKey(@Param("userId") String userId, @Param("delFlag") Short delFlag);
}