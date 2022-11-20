package miu.edu.service.impl;

import miu.edu.service.HelloConsumerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HelloConsumerServiceImpl implements HelloConsumerService {

    @Override
    @RabbitListener(queues = {"hello-queue-2"})
    public void bindToHelloQueue(String payLoad) {
        System.out.println(payLoad);
    }
}
