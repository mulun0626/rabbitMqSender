package org.muyun.rabbitMqSender;

import com.rabbitmq.client.Channel;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class rabbitMqSenderApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void testSendMessage() {
        String message = "hello world";
        rabbitTemplate.convertAndSend("my_boot_fanout_exchange", "", (Object) message, new CorrelationData());
    }


//    @Test
//    void testTopicSendMessage() {
//        String message = "hello world";
//        rabbitTemplate.convertAndSend("my_boot_fanout_exchange", "produce.add", message);
//    }

}
