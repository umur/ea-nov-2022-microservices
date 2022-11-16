package miu.edu;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @RabbitListener(queues = {"queue-1"})
    public void bindToQueue1(String payload) {
        System.out.println(payload);
    }

    @RabbitListener(queues = {"queue-2"})
    public void bindToQueue2(String payload) {
        System.out.println(payload);
    }
}
