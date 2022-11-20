package edu.miu.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.messaging.handler.annotation.Payload;

public interface Consumer {

    void receive(ConsumerRecord<String, String> cr, @Payload String message);
}
