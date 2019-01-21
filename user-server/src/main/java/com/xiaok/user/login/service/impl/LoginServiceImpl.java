package com.xiaok.user.login.service.impl;

import com.xiaok.common.vo.AuthMessage;
import com.xiaok.common.vo.ResultMessage;
import com.xiaok.user.login.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
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
    public ResultMessage<AuthMessage> login(String account, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(account,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            System.out.println("账户不正确");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码不正确");
        }catch (ExpiredCredentialsException e){
            System.out.println("凭证过期");
        }catch (LockedAccountException e){
            System.out.println("账户以及被锁定");
        }
        return null;
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
