package com.miu.ea.service.impl;

import com.miu.ea.service.HelloQueueService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HelloQueueServiceImpl implements HelloQueueService {

    private final RabbitTemplate rabbitTemplate;
    private final Queue hiQueue1;
    private final Queue hiQueue2;

    @Override
    public void send() {
        rabbitTemplate.convertAndSend(this.hiQueue1.getName(), "Q1 -- Hello World from EA: " + System.currentTimeMillis());
        rabbitTemplate.convertAndSend(this.hiQueue2.getName(), "Q2 -- Hello World from MIU: " + System.currentTimeMillis());
    }
}
