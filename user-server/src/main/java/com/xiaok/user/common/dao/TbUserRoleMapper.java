package com.xiaok.user.common.dao;

import com.xiaok.user.common.entity.TbUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TbUserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbUserRole record);

    int insertSelective(TbUserRole record);

    TbUserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbUserRole record);

    int updateByPrimaryKey(TbUserRole record);
}