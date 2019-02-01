package com.xiaok.user.common.session;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * author: xiao
 * date:   2019/2/1
 * desc:
 */
@Service
public class UserSessionManager {

    private static final String SESSION_PREFIX = "user:session:";


    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    public UserSession getSession(String userId) {
        String userSessionStr = redisTemplate.opsForValue().get(SESSION_PREFIX + userId);
        if (userSessionStr == null) {
            return null;
        }
        return JSON.parseObject(userSessionStr, UserSession.class);
    }

    public void setSession(String userId, UserSession userSession) {
        if (userId == null || userSession == null) {
            return;
        }
        redisTemplate.opsForValue().set(SESSION_PREFIX + userId, JSON.toJSONString(userSession), 3, TimeUnit.DAYS);
    }

    public void delSession(String userId) {
        if (userId == null) {
            return;
        }
        redisTemplate.delete(SESSION_PREFIX + userId);
    }
}
