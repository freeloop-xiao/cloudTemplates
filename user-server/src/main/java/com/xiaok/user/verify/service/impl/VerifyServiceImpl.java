package com.xiaok.user.verify.service.impl;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.xiaok.common.vo.ResultMessage;
import com.xiaok.user.common.util.JwtUtil;
import com.xiaok.user.verify.service.VerifyService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-25
 * Time: 16:17
 */

@Service
public class VerifyServiceImpl implements VerifyService {

    @Override
    public ResultMessage<String> verify(String token) {
        try {
            DecodedJWT decodedJWT = JwtUtil.verifyToken(token);
            String type = JwtUtil.getJwtParam(JwtUtil.TYPE, decodedJWT);
            if (!JwtUtil.AUTH.equals(type)) {
                return new ResultMessage<>("0001", "token类型验证失败!");
            }
        } catch (Exception e) {
            return new ResultMessage<>("0001", "token验证失败!");
        }
        return new ResultMessage<>("0000", "验证成功!");
    }
}
