package edu.miu.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQHeaderConfig {

    @Bean
    HeadersExchange headerExchange() {
        return new HeadersExchange("header-exchange");
    }

    @Bean
    Binding headerQueue1Binding(Queue queue1, HeadersExchange headerExchange) {
        return BindingBuilder.bind(queue1).to(headerExchange).where("headerKey").matches("header-queue-1");
    }

    @Bean
    Binding headerQueue2Binding(Queue queue2, HeadersExchange headerExchange) {
        return BindingBuilder.bind(queue2).to(headerExchange).where("headerKey").matches("header-queue-2");
    }

}
