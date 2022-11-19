package com.miu.ea.controller;

import com.miu.ea.service.HelloQueueService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
@AllArgsConstructor
public class HelloQueueController {

    private HelloQueueService helloQueueService;

    @GetMapping
    public void sendMsg() {
        helloQueueService.send();
    }
}
