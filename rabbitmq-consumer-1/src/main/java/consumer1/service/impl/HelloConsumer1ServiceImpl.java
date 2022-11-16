package consumer1.service.impl;

import consumer1.service.HelloConsumer1Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HelloConsumer1ServiceImpl implements HelloConsumer1Service {
    @Override
    @RabbitListener(queues = {"hello-queue-1"})
    public void bindToHelloQueue(String payload) {
        System.out.println(payload);
    }
}
