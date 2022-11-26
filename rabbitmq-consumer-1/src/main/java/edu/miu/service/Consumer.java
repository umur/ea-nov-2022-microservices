package edu.miu.service;

public interface Consumer {

    void bindToQueue(String payload);
}
