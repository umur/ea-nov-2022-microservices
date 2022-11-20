package com.Todoo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitmqPublisherApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqPublisherApplication.class,args);
    }
}
