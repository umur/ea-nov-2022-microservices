package edu.miu.userservice.service;

import edu.miu.userservice.entity.User;

public interface UserService {

    User findUserById(int id);
}
