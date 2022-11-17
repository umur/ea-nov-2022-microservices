package com.subedi.service.impl;

import com.subedi.entity.User;
import com.subedi.repo.UserRepo;
import com.subedi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }
}
