package com.miu.ea.controller;

import com.miu.ea.dto.ProductDto;
import com.miu.ea.entity.User;
import com.miu.ea.service.ProductClient;
import com.miu.ea.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private ProductClient productClient;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/products")
    public ProductDto getProductById() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9090/products/id/1", ProductDto.class);
    }

    @GetMapping("/products/all")
    public List<ProductDto> getAllProducts(){
        return productClient.getAllProducts();
    }
}
