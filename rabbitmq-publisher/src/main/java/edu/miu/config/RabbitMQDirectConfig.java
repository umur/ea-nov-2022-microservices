package edu.miu.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("direct-exchange");
    }

    @Bean
    Binding directQueue1Binding(Queue queue1, DirectExchange exchange) {
        return BindingBuilder.bind(queue1).to(exchange).with("direct-queue-1");
    }

    @Bean
    Binding directQueue11Binding(Queue queue1, DirectExchange exchange) {
        return BindingBuilder.bind(queue1).to(exchange).with("direct-queue-all");
    }

    @Bean
    Binding directQueue2Binding(Queue queue2, DirectExchange exchange) {
        return BindingBuilder.bind(queue2).to(exchange).with("direct-queue-2");
    }

}
