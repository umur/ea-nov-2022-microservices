package com.todoo.Service;

import org.springframework.stereotype.Service;

@Service
public interface HelloConsumer {
    void bindToHelloQueue(String payload);
}
