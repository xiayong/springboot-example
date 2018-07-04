package me.xiayong.example.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author YongXia.
 * @since 1.0
 */
@Getter
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitMQProperties {
    private final Example example = new Example();


    @Getter
    @Setter
    public static final class Example {
        private String queue;
        private String exchange;
        private String routingKey;
    }
}
