package miu.controller;

import miu.dto.ProductDTO;
import miu.model.User;
import miu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
//        var result = restTemplate.getForObject("http://localhost:8081/products/1", ProductDTO.class);

        var result = restTemplate.getForObject("http://product-service/products/1", ProductDTO.class);

        System.out.println(result);

        return userService.getUserById(id);
    }
}
