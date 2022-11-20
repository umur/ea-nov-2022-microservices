package com.example.service.impl;

import com.example.service.IHelloService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService {

    @RabbitListener(queues = {"hello-queue-2"})
    @Override
    public void getMessageSent(String payload) {
        System.out.println(payload);
    }


}
