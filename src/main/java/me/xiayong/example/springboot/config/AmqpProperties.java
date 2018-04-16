package me.xiayong.example.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author YongXia.
 * @since 1.0
 */
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class AmqpProperties {
    private final Simple simple = new Simple();


    public static final class Simple {
        private String queueName;
        private String exchangeName;
        private String routingKey;

        public String getQueueName() {
            return queueName;
        }

        public void setQueueName(String queueName) {
            this.queueName = queueName;
        }

        public String getExchangeName() {
            return exchangeName;
        }

        public void setExchangeName(String exchangeName) {
            this.exchangeName = exchangeName;
        }

        public String getRoutingKey() {
            return routingKey;
        }

        public void setRoutingKey(String routingKey) {
            this.routingKey = routingKey;
        }
    }


    public Simple getSimple() {
        return simple;
    }
}
