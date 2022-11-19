package edu.miu.service.impl;

import edu.miu.entity.User;
import edu.miu.repo.UserRepo;
import edu.miu.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo repo;

    @Override
    public Iterable<User> findAll() {
        return repo.findAll();
    }
}
