package com.xiaok.rabbitmq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Description: rabbitmq基础配置
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2018-08-18
 * Time: 16:01
 */
@Configuration
public class RabbitMqBasicConfig {

    private Logger log = LoggerFactory.getLogger(RabbitMqBasicConfig.class);

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * 配制队列序列化未json格式进行传输
     * @param rabbitListenerContainerFactory
     * @param jackson2JsonMessageConverter
     * @return
     */
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactoryPlus(SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory, Jackson2JsonMessageConverter jackson2JsonMessageConverter) {
        rabbitListenerContainerFactory.setMessageConverter(jackson2JsonMessageConverter);
        rabbitListenerContainerFactory.setConcurrentConsumers(3);
        rabbitListenerContainerFactory.setMaxConcurrentConsumers(5);
        rabbitListenerContainerFactory.setPrefetchCount(50);
        return rabbitListenerContainerFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
        connectionFactory.setPublisherConfirms(true);
        connectionFactory.setPublisherReturns(true);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> log.info("消息发送成功:correlationData({}),ack({}),cause({})", correlationData, ack, cause));
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> log.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}", exchange, routingKey, replyCode, replyText, message));
        return rabbitTemplate;
    }
}
