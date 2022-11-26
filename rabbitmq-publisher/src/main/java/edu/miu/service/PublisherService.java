package edu.miu.service;

public interface PublisherService {

    void send();

    void sendExchange(String exchange, String routingKey, String messageData);

    void sendHeaderExchange(String exchange, String headerKey, String messageData);
}
