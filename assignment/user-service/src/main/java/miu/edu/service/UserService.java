package miu.edu.service;

import miu.edu.entity.User;
import org.springframework.stereotype.Repository;


public interface UserService {
    public Iterable<User> getAll();
}
