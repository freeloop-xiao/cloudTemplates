package com.xiaok.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-02
 * Time: 14:57
 */
@Component
public class Consumer {
    @RabbitListener(queues = {"queue.name"})
    public void repayQueueQueryConsumer(String msg, Message message, Channel channel) {
        try {
            System.out.println("接收：" +msg);
            // TODO: 2019/1/2 0002 逻辑处理
        } catch (Exception e) {
            // TODO: 2019/1/2 0002 异常处理 
        } finally {
            try {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException e) {
            }
        }
    }
}
