package com.ralphwinner.service;

import com.ralphwinner.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);

    User findUserById(Long id);
}
