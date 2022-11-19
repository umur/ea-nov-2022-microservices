package com.miu.ea.service.impl;

import com.miu.ea.entity.User;
import com.miu.ea.repository.UserRepository;
import com.miu.ea.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
