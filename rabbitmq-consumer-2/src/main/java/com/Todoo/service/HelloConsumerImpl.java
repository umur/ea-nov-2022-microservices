package com.Todoo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HelloConsumerImpl implements HelloConsumer{
    @Override
    @RabbitListener(queues = {"hello-queue-2"})
    public void bindToHelloQueue(String payload) {
        System.out.println(payload);
    }
}
