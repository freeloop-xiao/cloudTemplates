package com.xiaok.gateway.common.verity;

import com.xiaok.common.vo.ResultMessage;

/**
 * author: xiao
 * date:   2019/2/1
 * desc:
 */
public class VerifyFallback implements VerifyClient {

    @Override
    public ResultMessage<String> verify(String token) {
        return new ResultMessage<>("0001", "token验证请求失败!");
    }
}