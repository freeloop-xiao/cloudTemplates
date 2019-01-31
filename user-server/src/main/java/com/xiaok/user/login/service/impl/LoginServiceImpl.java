package com.xiaok.user.login.service.impl;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.xiaok.common.exception.CommonException;
import com.xiaok.common.vo.AuthMessage;
import com.xiaok.common.vo.ResultMessage;
import com.xiaok.user.common.auth.UserToken;
import com.xiaok.user.common.dao.SysUserMapper;
import com.xiaok.user.common.entity.SysUser;
import com.xiaok.user.common.util.JwtUtil;
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

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public ResultMessage<AuthMessage> login(String account, String password, String appId) {
        UserToken token = new UserToken(account, password, appId);
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
        ResultMessage<AuthMessage> resultMessage = new ResultMessage<>("0000", "登录成功");
        resultMessage.setData(generateAuthInfo(account, appId));
        return resultMessage;
    }


    @Override
    public ResultMessage<AuthMessage> refresh(String refreshToken) {
        DecodedJWT jwt;
        try {
            jwt = JwtUtil.verifyToken(refreshToken);
        }catch (Exception e){
            throw new CommonException("0001","刷卡token验证失败!");
        }
        String userId = JwtUtil.getJwtParam(JwtUtil.USER_ID,jwt);
        String type = JwtUtil.getJwtParam(JwtUtil.TYPE,jwt);
        if (JwtUtil.AUTH.equals(type)){
            throw new CommonException("0001","token类型错误!");
        }
        ResultMessage<AuthMessage> resultMessage = new ResultMessage<>("0000", "刷新token成功");
        resultMessage.setData(generateAuthInfo(userId));
        return resultMessage;
    }

    @Override
    public ResultMessage<String> logout(String token) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return null;
    }


    private AuthMessage generateAuthInfo(String account, String appId) {
        SysUser sysUser = sysUserMapper.selectByPhoneAndAppId(account, appId);
        String token = JwtUtil.createToken(sysUser.getUserId(), sysUser.getAppId(), JwtUtil.AUTH);
        String refreshToken = JwtUtil.createToken(sysUser.getUserId(), sysUser.getAppId(), JwtUtil.REFRESH);
        return new AuthMessage(token, JwtUtil.EXPIRE, refreshToken);
    }

    private AuthMessage generateAuthInfo(String userId) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        String token = JwtUtil.createToken(sysUser.getUserId(), sysUser.getAppId(), JwtUtil.AUTH);
        String refreshToken = JwtUtil.createToken(sysUser.getUserId(), sysUser.getAppId(), JwtUtil.AUTH);
        return new AuthMessage(token, JwtUtil.EXPIRE, refreshToken);
    }

}
