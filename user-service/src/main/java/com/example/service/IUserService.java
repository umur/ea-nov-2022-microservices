package com.example.service;

import com.example.entity.User;

public interface IUserService {

    Iterable<User> findAll();
}
