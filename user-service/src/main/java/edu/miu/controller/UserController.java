package edu.miu.controller;

import edu.miu.config.MyConfig;
import edu.miu.dto.ProductDto;
import edu.miu.entity.User;
import edu.miu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@RestController
@RequestMapping("users")
@EnableDiscoveryClient
@EnableConfigurationProperties(value = MyConfig.class)
public class UserController {
    private final UserService service;

    @Autowired
    private MyConfig config;

    @Autowired
    private RestTemplate template;

    @GetMapping("/getConfigData")
    public MyConfig getConfig(){
        return config;
    }

    @Autowired
    private DiscoveryClient client;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<User> findAllUsers(){

        URI uri = client.getInstances("product-service").stream().map(si -> si.getUri()).findFirst()
                .map(s -> s.resolve("/products/1")).get();
        //var result = template.getForObject("http://localhost:9090/products", ProductDto.class);
        var result = template.getForObject(uri, ProductDto.class);
        System.out.println(result);

        return service.findAll();
    }

}
