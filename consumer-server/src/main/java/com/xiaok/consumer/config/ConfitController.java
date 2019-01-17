package com.xiaok.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-16
 * Time: 11:46
 */
@RestController
public class ConfitController {

    @Value("${age}")
    private String name;

    @RequestMapping("/getConfigInfo")
    public String getConfgiInfo(){
        return this.name;
    }

}
