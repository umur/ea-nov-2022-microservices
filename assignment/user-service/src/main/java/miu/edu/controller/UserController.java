package miu.edu.controller;



import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

import miu.edu.dto.ProductDto;
import miu.edu.entity.User;
import miu.edu.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@RefreshScope
public class UserController {
    public final UserServiceImpl userService;
    public final RestTemplate restTemplate;

    private final static String CBGetAll ="userService";

//    @Value("${welcome.message}")
//    private String message;

    @GetMapping

    public Iterable<User> GetAll()
    {
        var result = restTemplate.getForObject("http://product-service/products/1", ProductDto.class);
        System.out.println(result);
        return userService.getAll();
    }
    public Iterable<User> showDummyData(Exception e)
    {
        User dummyData = new User();
        dummyData.setId(1);
        dummyData.setAge(1);
        dummyData.setName("This is a dummy Data");
        List<User> dummy = Arrays.asList(dummyData);
        Iterable<User> dummyIterable = dummy;
        return  dummyIterable;
    }
//    @GetMapping("/message")
//    public String getMessage()
//    {
//        return message;
//    }



}
