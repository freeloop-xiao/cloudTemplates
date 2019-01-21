package com.xiaok.user.common.dao;

import com.xiaok.user.common.entity.TbRolePermession;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TbRolePermessionMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbRolePermession record);

    int insertSelective(TbRolePermession record);

    TbRolePermession selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbRolePermession record);

    int updateByPrimaryKey(TbRolePermession record);
}