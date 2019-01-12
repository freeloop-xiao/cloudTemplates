package com.xiaok.kafka.producer;

import com.xiaok.kafka.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/send")
    public String send(String name) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            User user = new User();
            user.setId(String.valueOf(count ++));
            user.setUsername("xiaok1" +count);
            user.setEmail(count + "@qq.com");
            kafkaTemplate.send("elk", user.toString());
        }
        long end = System.currentTimeMillis();
        return name + "time:" + (end - start);
    }
}
