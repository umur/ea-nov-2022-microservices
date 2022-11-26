package edu.miu.service;

import edu.miu.dto.OrderDto;
import edu.miu.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getUserById(int id);

}
