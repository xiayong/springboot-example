package me.xiayong.example.springboot.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * auto configuration.
 *
 * @author YongXia.
 * @since 1.0
 */
@Configuration
@PropertySource("classpath:rabbit.properties")
@EnableConfigurationProperties(RabbitMQProperties.class)
public class AmqpAutoConfiguration {
}
