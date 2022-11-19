package edu.miu.service.impl;

import edu.miu.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloServiceImpl implements HelloService {
    private final RabbitTemplate template;

    private final Queue queue1;
    private final Queue queue2;


    @Override
    public void sendMessage() {
        template.convertAndSend(this.queue1.getName(), "Q1 -- Hello World: " + System.currentTimeMillis());
        template.convertAndSend(this.queue2.getName(), "Q2 -- Hello World: " + System.currentTimeMillis());

    }
}
