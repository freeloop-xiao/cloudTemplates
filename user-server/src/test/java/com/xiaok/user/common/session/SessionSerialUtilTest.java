package com.xiaok.user.common.session;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.session.mgt.SimpleSession;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * author: xiao
 * date:   2019/1/31
 * desc:
 */
public class SessionSerialUtilTest {

    @Test
    public void serial(){
        UserSession session = new UserSession();
        session.setUserId("123456");
        session.setHost("192.168.1.1");
        System.out.println(JSON.toJSONString(session));
    }

}