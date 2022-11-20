package miu.edu.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HelloQueue {
    @Bean
    public Queue hiQueue1()
    {
        return new Queue("hello-queue-1", false);
    }
    @Bean
    public Queue hiQueue2()
    {
        return new Queue("hello-queue-2", false);
    }

    @Bean
    public Queue hiQueue3()
    {
        return new Queue("hello-queue-2", false);
    }
    @Bean
    public FanoutExchange helloFanOutExchange()
    {
        return new FanoutExchange("hello-queue-exchange");
    }

    @Bean
    Binding helloQueue1Binding(Queue hiQueue1, FanoutExchange helloFanOutExchange)
    {
        return BindingBuilder.bind(hiQueue1).to(helloFanOutExchange);
    }
    @Bean
    Binding helloQueue2Binding(Queue hiQueue2, FanoutExchange helloFanOutExchange)
    {
        return BindingBuilder.bind(hiQueue2).to(helloFanOutExchange);
    }
    @Bean
    public DirectExchange helloDirectExchange()
    {
        return new DirectExchange("hello-queue-exchange.direct");
    }
    @Bean
    Binding helloQueue3DBinding(Queue hiQueue2, DirectExchange directExchange)
    {
        return BindingBuilder.bind(hiQueue2).to(directExchange).with("A");
    }
}
