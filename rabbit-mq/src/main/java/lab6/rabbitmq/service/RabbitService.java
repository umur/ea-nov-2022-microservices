package lab6.rabbitmq.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitService {
    private final RabbitTemplate rabbitTemplate;
    final private Queue productsQueue;
    final private Queue usersQueue;

    public void sendProductsMessage(){
        rabbitTemplate.convertAndSend(productsQueue.getName(), "hello for products");
    }

    public void sendUsersMessage(){
        rabbitTemplate.convertAndSend(usersQueue.getName(), "hello for users");
    }
}
