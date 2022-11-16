package edu.miu.services.impl;

import edu.miu.services.ConsumerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Override
    @RabbitListener(queues = {"hello-queue-1"})
    public void consumeQueue(String payload) {
        System.out.println(payload);
    }
}
