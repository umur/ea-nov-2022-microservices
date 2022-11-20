package com.Todoo.service;

import org.springframework.stereotype.Service;

@Service
public interface HelloConsumer {
    void bindToHelloQueue(String payload);
}
