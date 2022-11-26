package edu.miu.service.impl;

import edu.miu.service.Consumer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerImpl implements Consumer {

    @Override
    @RabbitListener(queues = {"queue-1"})
    public void bindToQueue(String payload) {
        System.out.println(payload);
    }
}
