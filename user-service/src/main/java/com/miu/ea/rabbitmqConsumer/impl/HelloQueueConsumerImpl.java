package com.miu.ea.rabbitmqConsumer.impl;

import com.miu.ea.rabbitmqConsumer.HelloQueueConsumer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HelloQueueConsumerImpl implements HelloQueueConsumer {

    @Override
    @RabbitListener(queues = {"hello-queue-1"})
    public void bindToHelloQueue(String payload) {
        System.out.println(payload);
    }
}
