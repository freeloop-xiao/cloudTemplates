package com.xiaok.user.register.service;

import com.xiaok.common.vo.ResultMessage;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-22
 * Time: 17:41
 */
public interface RegisterService {
    ResultMessage<String> register(String phone, String smsCode, String appId);
}
