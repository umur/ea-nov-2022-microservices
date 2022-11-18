package lab6.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Queue productsQueue() {
        return new Queue("products-queue", true);
    }
    @Bean
    public Queue usersQueue(){
        return new Queue("users-queue", true);
    }

    @Bean
    FanoutExchange productsExchange(){
        return new FanoutExchange("products-exchange");
    }
    @Bean
    FanoutExchange usersExchange(){
        return new FanoutExchange("users-exchange");
    }

    @Bean
    Binding productsQueueBinder(Queue productsQueue, FanoutExchange productsExchange){
        return BindingBuilder.bind(productsQueue).to(productsExchange);
    }
    @Bean
    Binding usersQueueBinder(Queue usersQueue, FanoutExchange usersExchange){
        return BindingBuilder.bind(usersQueue).to(usersExchange);
    }

}