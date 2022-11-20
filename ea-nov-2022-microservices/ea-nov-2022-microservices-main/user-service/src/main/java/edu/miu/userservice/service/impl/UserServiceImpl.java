package edu.miu.userservice.service.impl;

import edu.miu.userservice.entity.User;
import edu.miu.userservice.repository.UserRepository;
import edu.miu.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findUserById(int id) {
        return userRepository.findAllById(id);
    }
}
