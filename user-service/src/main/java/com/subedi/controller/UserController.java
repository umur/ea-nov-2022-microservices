package com.subedi.controller;

import com.subedi.dto.ProductDto;
import com.subedi.entity.User;
import com.subedi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RestTemplate restTemplate;

    @GetMapping()
    public List<User> getAll(){
        var result = restTemplate.getForObject("http://product-service/products/1", ProductDto.class);
        System.out.println("Hello Result: "+ result);
        return userService.getAll();

    }

}
