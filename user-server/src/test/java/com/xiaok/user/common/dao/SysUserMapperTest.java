package com.xiaok.user.common.dao;

import com.xiaok.user.common.entity.SysUser;
import com.xiaok.user.common.util.IdUtil;
import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * author: xiao
 * date:   2019/1/28
 * desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserMapperTest {

    @Autowired
    private SysUserMapper sysUserMapper;


    @Test
    public void insertSelective() {
        for (int i = 0; i < 10; i++) {
            SysUser user = new SysUser();
            user.setUserId(IdUtil.generate());
            user.setAppId("1");
            sysUserMapper.insertSelective(user);
        }
    }
}