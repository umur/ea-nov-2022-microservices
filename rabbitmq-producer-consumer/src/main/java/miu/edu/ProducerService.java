package miu.edu;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final RabbitTemplate rabbitTemplate;

    public void send() {
        rabbitTemplate.convertAndSend("queue-1", "Q1 -- Hello World: " + System.currentTimeMillis());
        rabbitTemplate.convertAndSend("queue-2", "Q1 -- Hello World: " + System.currentTimeMillis());
    }
}