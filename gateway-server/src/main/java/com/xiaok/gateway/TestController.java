package com.xiaok.gateway;

import com.xiaok.common.vo.ResultMessage;
import com.xiaok.gateway.common.verity.VerifyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: xiao
 * date:   2019/2/1
 * desc:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private VerifyClient verifyClient;

    @RequestMapping("/feign")
    public ResultMessage<String> test(){
        return verifyClient.verify("hello");
    }
}
