package edu.miu.service.impl;

import edu.miu.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue1;
    private final Queue queue2;

    private final Queue queue3;

    private final Queue queue4;

    @Override
    public void send() {
        rabbitTemplate.convertAndSend(this.queue1.getName(), "Q1 -- Hello World: " + System.currentTimeMillis());
        rabbitTemplate.convertAndSend(this.queue2.getName(), "Q2 -- Hello World: " + System.currentTimeMillis());
    }

    @Override
    public void sendExchange(String exchange, String routingKey, String messageData) {
        String message = String.format("Exchange: %s - Routing key: %s - Message: %s", exchange, routingKey, messageData);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

    @Override
    public void sendHeaderExchange(String exchange, String headerKey, String messageData) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("headerKey", headerKey);
        MessageConverter messageConverter = new SimpleMessageConverter();

        String data =  String.format("Exchange: %s - Header key: %s - Message: %s", exchange, headerKey, messageData);
        Message message = messageConverter.toMessage(data, messageProperties);
        rabbitTemplate.send(exchange, "", message);
    }

}
