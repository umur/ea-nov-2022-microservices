package edu.miu.service.impl;

import edu.miu.dto.OrderDto;
import edu.miu.dto.ProductDto;
import edu.miu.service.OrderService;
import edu.miu.service.ProductService;
import edu.miu.service.UserService;
import edu.miu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.miu.repository.UserRepositry;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepositry userRepositry;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Override
    public List<User> getAll() {
        return userRepositry.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepositry.findById(id).orElseThrow(() -> new RuntimeException(String.format("User is not exist: %s", id)));
    }

}
