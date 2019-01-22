package com.xiaok.user.login.service;

import com.xiaok.common.vo.AuthMessage;
import com.xiaok.common.vo.ResultMessage;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-21
 * Time: 15:39
 */
public interface LoginService {

    ResultMessage<AuthMessage> login(String account, String password, String appId);

    ResultMessage<String> refresh(String token);

    ResultMessage<String> logout(String token);
}
