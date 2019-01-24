package com.xiaok.user.login.service.impl;

import com.netflix.discovery.converters.Auto;
import com.xiaok.common.exception.CommonException;
import com.xiaok.common.vo.AuthMessage;
import com.xiaok.common.vo.ResultMessage;
import com.xiaok.user.common.auth.UserToken;
import com.xiaok.user.common.dao.TbUserMapper;
import com.xiaok.user.login.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-21
 * Time: 15:47
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public ResultMessage<AuthMessage> login(String account, String password, String appId) {
        UserToken token = new UserToken(account, password,appId);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            throw new CommonException("0001", "账户不正确");
        } catch (IncorrectCredentialsException e) {
            throw new CommonException("0001", "密码不正确");
        } catch (ExpiredCredentialsException e) {
            throw new CommonException("0001", "凭证过期");
        } catch (LockedAccountException e) {
            throw new CommonException("0001", "账户被锁定");
        }
        return new ResultMessage<>("0000","登录成功");
    }

    @Override
    public ResultMessage<String> refresh(String token) {
        return null;
    }

    @Override
    public ResultMessage<String> logout(String token) {
        return null;
    }
}
