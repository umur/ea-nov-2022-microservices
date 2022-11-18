package edu.miu.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Bean
    public Queue queue1() {
        return new Queue("queue-1", true);
    }

    @Bean
    public Queue queue2() {
        return new Queue("queue-2", true);
    }

    @Bean
    public Queue queue3() {
        return new Queue("queue-3", true);
    }

//    @Bean
//    ApplicationRunner runner(ConnectionFactory cf) {
//        return args -> cf.createConnection().close();
//    }
}
