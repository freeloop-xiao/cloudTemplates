package com.xiaok.user.verify.service;

import com.xiaok.common.vo.ResultMessage;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-25
 * Time: 16:17
 */
public interface VerifyService {

    ResultMessage<String> verify(String token);
}
