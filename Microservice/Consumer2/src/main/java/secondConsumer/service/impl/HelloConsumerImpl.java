package secondConsumer.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import secondConsumer.service.HelloConsumer;

public class HelloConsumerImpl implements HelloConsumer {
    @Override
    @RabbitListener(queues = {"hello-queue-two"})
    public void bindToHelloQueue(String payload) {
        System.out.println(payload);

    }
}
