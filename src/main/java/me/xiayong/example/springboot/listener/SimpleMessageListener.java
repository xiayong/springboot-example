package me.xiayong.example.springboot.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.core.Ordered;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = "SIMPLE_QUEUE")
public class SimpleMessageListener implements Ordered {

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }

    @RabbitHandler
    public void process(@Payload String message) {
        System.out.println(message);
    }
}
