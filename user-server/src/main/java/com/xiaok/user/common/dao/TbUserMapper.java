package com.xiaok.user.common.dao;

import com.xiaok.user.common.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TbUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(String id);

    TbUser selectByPhoneAndAppId(@Param("phone") String phone, @Param("appId") String appId);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
}