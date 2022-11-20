package miu.edu;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class RabbitmqConsumer2 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqConsumer2.class,args);
    }
}
