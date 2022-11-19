package edu.miu.service;

import edu.miu.entity.User;

public interface UserService {
    Iterable<User> findAll();
}
