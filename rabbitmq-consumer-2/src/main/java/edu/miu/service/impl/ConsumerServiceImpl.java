package edu.miu.service.impl;

import edu.miu.service.ConsumerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Override
    @RabbitListener(queues = {"hello-queue-2"})
    public void consumeQueue(String payload) {
        System.out.println(payload);
    }
}
