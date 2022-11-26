package edu.miu;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitMQConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQConsumerApplication.class, args);
    }

}
