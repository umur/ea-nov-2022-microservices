package edu.miu.services;

import org.springframework.stereotype.Service;

@Service
public interface ConsumerService {
    void consumeQueue(String payload);
}
