package edu.miu.service.impl;

import edu.miu.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void send() {
        kafkaTemplate.send("test3", "Hello: " + System.currentTimeMillis());
    }
}
