package com.xiaok.kafka.producer;

import com.alibaba.fastjson.JSON;
import com.xiaok.kafka.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2018-12-29
 * Time: 09:44
 */
@RestController
public class KafkaProducerController {

    private static int count = 100;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/send")
    public String send(String name) {

        long start = System.currentTimeMillis();

        for (int i = 1; i < 1000; i++) {
            User user = new User();
            user.setId(String.valueOf(count ++));
            user.setUsername("eeeeeeefreeloop" +count);
            user.setEmail(count + "freeloop@qq.com");
            user.setTime(sdf.format(new Date()));
            user.setType("other");
            kafkaTemplate.send("elk",JSON.toJSONString(user));
        }

        long end = System.currentTimeMillis();
        return name + "time:" + (end - start);
    }
}
