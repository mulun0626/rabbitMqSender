package org.muyun.rabbitMqSender.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class rabbitConfig implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnsCallback {

    @Resource
    RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ask, String reason) {
        System.out.printf("消息唯一表示" + correlationData);
        if (ask) {
            System.out.printf("消息成功发送到Exchange");
        } else {
            System.out.printf("消息发送Exchange失败" + reason);
        }
    }

    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        System.out.printf("消息没有发送到queue");
    }
}
