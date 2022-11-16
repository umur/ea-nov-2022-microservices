package consumer2.service.impl;

import consumer2.service.HelloConsumer2Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HelloConsumer2ServiceImpl implements HelloConsumer2Service {
    @Override
    @RabbitListener(queues = {"hello-queue-2"})
    public void bindToHelloQueue(String payload) {
        System.out.println(payload);
    }
}
