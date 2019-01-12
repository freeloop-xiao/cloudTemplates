package com.xiaok.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2018-12-29
 * Time: 15:21
 */
//@Component
public class KafkaConsumer {

    /**
     * 监听topic1主题,单条消费
     */
    @KafkaListener(topics = "xiaok1",groupId = "xiaok2")
    public void listen0(ConsumerRecord<String, String> record) {
        consumer(record);
    }

    /**
     * 单条消费
     */
    public void consumer(ConsumerRecord<String, String> record) {
        System.out.println(Thread.currentThread().getId() + "===> 主题:" + record.topic() + " 内容: " + record.value());
    }
}
