package com.xiaok.user.manager.service.impl;

import com.xiaok.common.exception.CommonException;
import com.xiaok.common.util.ParamUtil;
import com.xiaok.user.common.dao.SysUserMapper;
import com.xiaok.user.common.entity.SysUser;
import com.xiaok.user.manager.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author: xiao
 * date:   2019/2/7
 * desc:
 */
@Service
public class UserManagerServiceImpl implements UserManagerService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public void change(String userId, String userAlias, String phone, Short sex,
                       Short idCardType, String idCardNo, String birthday, String email,
                       String prov, String city, String area) {
        SysUser sysUser = checkSysUser(userId);
        sysUser.setUserAlias(userAlias);
        sysUser.setPhone(phone);
        sysUser.setSex(sex);
        sysUser.setIdCardType(idCardType);
        sysUser.setIdCardNo(idCardNo);
        sysUser.setBirthday(birthday);
        sysUser.setEmail(email);
        sysUser.setProv(prov);
        sysUser.setCity(city);
        sysUser.setArea(area);
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public void lock(String userId) {
        SysUser sysUser = checkSysUser(userId);
        if (sysUser.getLockFlag() == 1) {
            return;
        }
        sysUserMapper.updateLockedByPrimaryKey(userId, (short) 1);
    }

    @Override
    public void cancel(String userId) {
        checkSysUser(userId);
        sysUserMapper.updateDelByPrimaryKey(userId,(short)1);
    }


    private SysUser checkSysUser(String userId) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        if (sysUser == null) {
            throw new CommonException("0001", "用户不存在");
        }
        return sysUser;
    }
}
