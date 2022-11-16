package edu.miu.service.impl;

import edu.miu.CircuitBreakerApplication;
import edu.miu.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    CircuitBreakerFactory circuitBreakerFactory;

    @Override
    public String getReview() {
        RestTemplate restTemplate = new RestTemplate();
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        String url = "https://jsonplaceholder.typicode.com/posts/1/comments";
        return circuitBreaker.run(() -> restTemplate.getForObject(url, String.class), throwable -> getDefaultReview());
    }

    private String getDefaultReview() {
        return "This is default review :)";
    }
}
