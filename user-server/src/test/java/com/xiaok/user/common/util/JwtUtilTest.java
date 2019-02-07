package com.xiaok.user.common.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * author: xiao
 * date:   2019/1/31
 * desc:
 */
public class JwtUtilTest {

    @Test
    public void createToken() {
        System.out.println(JwtUtil.createToken("123","123","auth",""));
    }

    @Test
    public void verifyToken() {
        System.out.println(JwtUtil.verifyToken(JwtUtil.createToken("123","123","auth","")));
    }
}