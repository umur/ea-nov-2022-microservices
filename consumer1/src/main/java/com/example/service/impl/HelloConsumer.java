package com.example.service.impl;

import com.example.service.IHelloConsumer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HelloConsumer implements IHelloConsumer {


    @Override
    @RabbitListener(queues = {"hello-queue-1"})
    public void bindToHelloQueue(String payload) {
        System.out.println(payload);
    }
}
