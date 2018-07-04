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
//    private RabbitMQProperties properties;

//    @Bean
//    public Queue simpleQueue(AmqpAdmin amqpAdmin) {
//        Queue queue = new Queue(properties.getExample().getQueueName());
//        queue.setAdminsThatShouldDeclare(amqpAdmin);
//        return queue;
//    }
//
//    @Bean
//    public TopicExchange simpleExchange(AmqpAdmin amqpAdmin) {
//        TopicExchange exchange = new TopicExchange(properties.getExample().getExchangeName());
//        exchange.setAdminsThatShouldDeclare(amqpAdmin);
//        return exchange;
//    }
//
//
//    @Bean
//    public Binding binding(AmqpAdmin amqpAdmin, TopicExchange simpleExchange, Queue simpleQueue) {
//        Binding binding = BindingBuilder.bind(simpleQueue).to(simpleExchange).with(properties.getExample().getRoutingKey());
//        binding.setAdminsThatShouldDeclare(amqpAdmin);
//        return binding;
//    }
//
//    public RabbitMQProperties getProperties() {
//        return properties;
//    }
//
//    @Autowired
//    public void setProperties(RabbitMQProperties properties) {
//        this.properties = properties;
//    }


}
