package org.muyun.rabbitMqSender.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class myRabbitConfig {

    private static String EXCHANGE_NAME = "my_boot_fanout_exchange";

    /*
        声明交换机
     */
    @Bean
    public FanoutExchange exchange (){
        return new FanoutExchange(EXCHANGE_NAME, true, false);
    }

//    private static String TOPIC_NAME = "my_boot_fanout_topic";
//
//    /*
//        声明topic交换机
//     */
//    @Bean
//    public TopicExchange topicExchange (){
//        return new TopicExchange(EXCHANGE_NAME, true, false);
//    }
}
