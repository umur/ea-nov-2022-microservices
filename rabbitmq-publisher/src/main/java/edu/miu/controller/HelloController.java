package edu.miu.controller;

import edu.miu.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publishers")
public class HelloController {
    @Autowired
    private HelloService service;

    @GetMapping
    public void send() {
        service.sendMessage();
    }

}
