package edu.miu.controller;

import edu.miu.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publisher")
@RequiredArgsConstructor
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public void send() {
        publisherService.send();
    }

    @GetMapping(value = "/producer")
    public String producer(@RequestParam(value = "exchangeName", defaultValue = "") String exchange,
                           @RequestParam(value = "routingKey", defaultValue = "") String routingKey,
                           @RequestParam(value = "messageData", defaultValue = "") String messageData) {

        publisherService.sendExchange(exchange, routingKey, messageData);
        return String.format("Message sent to the RabbitMQ %s Exchange Successfully", exchange);
    }

    @GetMapping(value = "/producer/header")
    public String producerHeader(@RequestParam(value = "exchangeName", defaultValue = "") String exchange,
                           @RequestParam(value = "headerKey", defaultValue = "") String headerKey,
                           @RequestParam(value = "messageData", defaultValue = "") String messageData) {

        publisherService.sendHeaderExchange(exchange, headerKey, messageData);
        return String.format("Message sent to the RabbitMQ %s Exchange Successfully", exchange);
    }

}
