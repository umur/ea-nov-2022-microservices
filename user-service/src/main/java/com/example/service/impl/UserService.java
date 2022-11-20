package com.example.service.impl;

import com.example.dto.ProductDto;
import com.example.entity.User;
import com.example.repo.IUserRepo;
import com.example.service.IUserService;
import com.example.service.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepo repo;
    private final ProductClient client;

    @Override
    public Iterable<User> findAll() {

        ProductDto result = client.getAllProducts().get(0);
        System.out.println(result);
        return repo.findAll();
    }
}
