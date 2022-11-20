package com.example;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableRabbit
public class Publisher
{
    public static void main( String[] args )
    {
        SpringApplication.run(Publisher.class, args);
    }
}
