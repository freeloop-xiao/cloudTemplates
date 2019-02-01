package com.xiaok.user.register.service.impl;

import com.xiaok.common.exception.CommonException;
import com.xiaok.common.vo.ResultMessage;
import com.xiaok.user.common.dao.SysUserMapper;
import com.xiaok.user.common.entity.SysUser;
import com.xiaok.user.common.util.IdUtil;
import com.xiaok.user.common.util.PasswordUtil;
import com.xiaok.user.register.service.RegisterService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description: 注册业务实现类
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-22
 * Time: 17:43
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public ResultMessage<String> register(String phone, String smsCode, String appId) {
        checkUser(phone, appId);
        // TODO: 2019/1/23 0023 验证短信验证码
        // TODO: 2019/1/23 0023 验证appId
        SysUser user = new SysUser();
        user.setPhone(phone);
        user.setUserId(IdUtil.generate());
        user.setAppId(appId);
        user.setLoginSalt(PasswordUtil.generateSalt());
        ByteSource solt = ByteSource.Util.bytes(user.getLoginSalt());
        SimpleHash simpleHash = new SimpleHash("MD5", phone.substring(5), solt, 2);
        user.setLoginPwd(simpleHash.toBase64());
        sysUserMapper.insertSelective(user);
        return new ResultMessage<>("0000", "注册成功!");
    }

    private void checkUser(String phone, String appId) {
        SysUser sysUser = sysUserMapper.selectByPhoneAndAppId(phone, appId);
        if (sysUser != null) {
            throw new CommonException("0001", "改手机号已经注册!");
        }
    }
}
