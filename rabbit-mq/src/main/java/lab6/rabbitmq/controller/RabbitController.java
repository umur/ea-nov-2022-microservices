package lab6.rabbitmq.controller;

import lab6.rabbitmq.service.RabbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class RabbitController {
    final private RabbitService rabbitService;

    @GetMapping("products")
    public void sendProductService(){
        this.rabbitService.sendProductsMessage();
    }

    @GetMapping("users")
    public void sendUsersService(){
        this.rabbitService.sendUsersMessage();
    }

}
