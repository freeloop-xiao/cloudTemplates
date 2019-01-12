package com.xiaok.consumer.hystrix;

import com.xiaok.consumer.remote.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * Description: 熔断器响应
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2018-12-28
 * Time: 10:53
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "hello" +name+", this messge send failed ";
    }
}
