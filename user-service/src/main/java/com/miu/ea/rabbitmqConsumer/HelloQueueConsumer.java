package com.miu.ea.rabbitmqConsumer;

public interface HelloQueueConsumer {

    void bindToHelloQueue(String payload);
}
