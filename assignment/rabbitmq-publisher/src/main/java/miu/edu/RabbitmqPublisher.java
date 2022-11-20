package miu.edu;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitmqPublisher {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqPublisher.class,args);
    }
}
