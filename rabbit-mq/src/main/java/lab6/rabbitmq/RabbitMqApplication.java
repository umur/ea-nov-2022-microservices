package lab6.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableRabbit
@EnableEurekaClient
public class RabbitMqApplication {
	public static void main(String[] args) {
		SpringApplication.run(RabbitMqApplication.class, args);
	}
}
