package me.xiayong.example.springboot.rabbit;

import me.xiayong.example.springboot.ExampleSpringBootApplicationTests;
import me.xiayong.example.springboot.config.RabbitMQProperties;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author YongXia.
 * @since 1.0
 */
public class MessageSendTests extends ExampleSpringBootApplicationTests {
    @Autowired
    private RabbitMQProperties rabbitMQProperties;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    @Repeat(5)
    public void testSendTextMessage() throws InterruptedException {
        RabbitMQProperties.Example example = this.rabbitMQProperties.getExample();
        rabbitTemplate.convertAndSend(example.getExchange(), example.getRoutingKey(), "text message " + UUID.randomUUID().toString());
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
