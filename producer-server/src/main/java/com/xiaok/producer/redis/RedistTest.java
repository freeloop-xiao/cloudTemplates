package com.xiaok.producer.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-02
 * Time: 18:08
 */
@Component
public class RedistTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void test() {
        redisTemplate.opsForValue().set("test", "test");
    }
}
