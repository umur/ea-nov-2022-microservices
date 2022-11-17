package edu.miu.services.impl;

import edu.miu.entities.Users;
import edu.miu.repos.UserRepo;
import edu.miu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public List<Users> getAll() {
        return userRepo.findAll();
    }
}
