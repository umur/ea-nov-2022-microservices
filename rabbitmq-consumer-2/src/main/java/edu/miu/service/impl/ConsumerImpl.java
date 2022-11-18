package edu.miu.service.impl;

import edu.miu.service.Consumer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerImpl implements Consumer {

    @Override
    @RabbitListener(queues = {"queue-2"})
    public void bindToQueue2(String payload) {
        System.out.println(payload);
    }
}
