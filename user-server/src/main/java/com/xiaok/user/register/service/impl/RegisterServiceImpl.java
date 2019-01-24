package com.xiaok.user.register.service.impl;

import com.xiaok.common.vo.ResultMessage;
import com.xiaok.user.common.dao.TbUserMapper;
import com.xiaok.user.common.entity.TbUser;
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
    private TbUserMapper tbUserMapper;

    @Override
    public ResultMessage<String> register(String phone, String smsCode, String appId) {
        // TODO: 2019/1/23 0023 验证短信验证码
        // TODO: 2019/1/23 0023 验证appId
        TbUser user = new TbUser();
        user.setPhone(phone);
        user.setId(IdUtil.generate());
        user.setAppId(appId);
        user.setLoginSalt(PasswordUtil.generateSalt());
        ByteSource solt = ByteSource.Util.bytes(user.getLoginSalt());
        SimpleHash simpleHash = new SimpleHash("MD5", phone.substring(5), solt, 2);
        user.setLoginPwd(simpleHash.toBase64());
        tbUserMapper.insertSelective(user);
        return new ResultMessage<>("0000","注册成功!");
    }
}
