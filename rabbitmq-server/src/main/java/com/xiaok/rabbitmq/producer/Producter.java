package com.xiaok.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description: 消息发送生产者
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2018-08-31
 * Time: 14:44
 */
@Component
public class Producter {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * 发送非延迟消息
     * @param exchange 路由器名字
     * @param routingKey 路由
     * @param msg 消息
     */
    public <T> void sendMsg(String exchange, String routingKey, String correlationId, T msg){
        CorrelationData correlationIds = new CorrelationData(correlationId);
        rabbitTemplate.convertAndSend(exchange, routingKey, msg, correlationIds);
    }


    /**
     * 发送消息工具类
     * @param exchange 交换器名字
     * @param routingKey 路由
     * @param correlationId 发送确认id
     * @param msg 消息
     * @param expire 延迟时间(毫秒为单位)
     */
    public  <T> void sendMsg(String exchange, String routingKey, String correlationId ,T msg , String expire){
        CorrelationData correlationIds = new CorrelationData(correlationId);
        rabbitTemplate.convertAndSend(exchange, routingKey, msg, message -> {
            message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, msg.getClass().getName());
            message.getMessageProperties().setExpiration(expire);
            return message; } ,correlationIds);
    }


}
