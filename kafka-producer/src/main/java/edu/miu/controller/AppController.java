package edu.miu.controller;

import edu.miu.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/producer")
@RequiredArgsConstructor
public class AppController {

    private final PublisherService publisherService;

    @GetMapping
    public String sendMessages() {
        publisherService.send();
        return "Message sent to the Kafka Topic Successfully";
    }
}
