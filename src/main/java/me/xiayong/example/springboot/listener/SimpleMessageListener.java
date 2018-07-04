package me.xiayong.example.springboot.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(
    bindings = @QueueBinding(
        value = @Queue(value = "${spring.rabbitmq.example.queue}", durable="true", autoDelete = "false"),
        exchange = @Exchange(value = "${spring.rabbitmq.example.exchange}", type = ExchangeTypes.TOPIC),
        key = "${spring.rabbitmq.example.routing-key}"),
    admin = "amqpAdmin")
public class SimpleMessageListener implements Ordered {
    private Logger logger = LoggerFactory.getLogger(SimpleMessageListener.class);


    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }

    @RabbitHandler
    public void process(@Payload String message) {
        logger.info("Message received: {}", message);
    }
}
