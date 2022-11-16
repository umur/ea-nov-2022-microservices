package edu.miu.controllers;

import edu.miu.dtos.ProductDto;
import edu.miu.entities.Users;
import edu.miu.services.ProductClient;
import edu.miu.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    private final RestTemplate restTemplate;
    private final ProductClient productClient;

    @Value("${spring.zipkin-base-url}")
    String zipkinUrl;

    @GetMapping
    ResponseEntity<?> getAll() {
        var result = restTemplate.getForObject("http://product-service/products/1", ProductDto.class);
        System.out.println("RESULT -->>> " + result);
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/products/test")
    ResponseEntity<?> getAllProducts() {
        System.out.println("zipkinUrl ==>> " + zipkinUrl);
        return new ResponseEntity<>(productClient.getAllProducts(), HttpStatus.OK);
    }

}
