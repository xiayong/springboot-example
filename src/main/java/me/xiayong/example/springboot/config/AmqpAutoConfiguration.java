package me.xiayong.example.springboot.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * auto configuration.
 *
 * @author YongXia.
 * @since 1.0
 */
@Configuration
@PropertySource("classpath:amqp.properties")
@EnableConfigurationProperties(AmqpProperties.class)
public class AmqpAutoConfiguration {
    private AmqpProperties properties;

    @Bean
    public Queue simpleQueue(AmqpAdmin amqpAdmin) {
        Queue queue = new Queue(properties.getSimple().getQueueName());
        queue.setAdminsThatShouldDeclare(amqpAdmin);
        return queue;
    }

    @Bean
    public TopicExchange simpleExchange(AmqpAdmin amqpAdmin) {
        TopicExchange exchange = new TopicExchange(properties.getSimple().getExchangeName());
        exchange.setAdminsThatShouldDeclare(amqpAdmin);
        return exchange;
    }


    @Bean
    public Binding binding(AmqpAdmin amqpAdmin, TopicExchange simpleExchange, Queue simpleQueue) {
        Binding binding = BindingBuilder.bind(simpleQueue).to(simpleExchange).with(properties.getSimple().getRoutingKey());
        binding.setAdminsThatShouldDeclare(amqpAdmin);
        return binding;
    }

    public AmqpProperties getProperties() {
        return properties;
    }

    @Autowired
    public void setProperties(AmqpProperties properties) {
        this.properties = properties;
    }


}
