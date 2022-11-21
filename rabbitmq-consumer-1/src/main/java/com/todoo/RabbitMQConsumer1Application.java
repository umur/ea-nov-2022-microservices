package com.todoo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitMQConsumer1Application {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQConsumer1Application.class,args);
    }
}
