package com.xiaok.user.common.dao;

import com.xiaok.user.common.entity.TbPermession;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TbPermessionMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbPermession record);

    int insertSelective(TbPermession record);

    TbPermession selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbPermession record);

    int updateByPrimaryKey(TbPermession record);
}