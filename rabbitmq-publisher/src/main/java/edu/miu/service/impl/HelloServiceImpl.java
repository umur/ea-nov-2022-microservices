package edu.miu.service.impl;

import edu.miu.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloServiceImpl implements HelloService {
    private final RabbitTemplate rabbitTemplate;
    private final Queue hiQueue1;
    private final Queue hiQueue2;

    @Override
    public void send() {
        rabbitTemplate.convertAndSend(this.hiQueue1.getName(), "Q1 -- Hello Queue: " + System.currentTimeMillis());
        rabbitTemplate.convertAndSend(this.hiQueue2.getName(), "Q2 -- Hello Queue: " + System.currentTimeMillis());
    }
}
