package com.xiaok.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xiaok
 * Email: 306934150@qq.com
 * Date: 2019-01-03
 * Time: 11:45
 */
@Configuration
public class QueueConfig {
    @Bean
    public Queue queueName() {
        return new Queue("queue.name", true, false, false);
    }

    @Bean
    public DirectExchange queueExchange() {
        return new DirectExchange("queue.name");
    }

    @Bean
    public Binding payBinding() {
        return BindingBuilder.bind(queueName()).to(queueExchange()).with("queue.name");
    }

}
