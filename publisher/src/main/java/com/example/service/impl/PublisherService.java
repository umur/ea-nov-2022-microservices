package com.example.service.impl;

import com.example.service.IPublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherService implements IPublisherService {

    private final RabbitTemplate rabbitTemplate;

    private final Queue hiQueue1;
    private final Queue hiQueue2;


    @Override
    public void send() {
        rabbitTemplate.convertAndSend(hiQueue1.getName() , "Q1 Hello world: " + System.currentTimeMillis());
        rabbitTemplate.convertAndSend(hiQueue2.getName() , "Q2 Hello world: " + System.currentTimeMillis());
    }
}
