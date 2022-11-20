package edu.miu.controller;

import edu.miu.dto.ProductDto;
import edu.miu.serivce.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import edu.miu.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final ProductClient productClient;

    private final RestTemplate restTemplate;

    @GetMapping("/products/{id}")
    public ProductDto getById(@PathVariable("id") Integer id){
        var result = restTemplate.getForObject ("http://product-service/products/"+id,ProductDto.class);
        System.out.println (result);
        return result;
    }

    @GetMapping("/products")
    public List <ProductDto> getAllProducts(){
       return productClient.getAllProducts ();

    }


}
