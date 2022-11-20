package miu.edu.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping
    public void send() {
        helloService.send();
    }

}