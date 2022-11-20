package edu.miu.service.Impl;

import edu.miu.repo.UserRepo;
import edu.miu.service.UserService;
import edu.miu.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    @Override
    public Iterable <User> getAll () {
        return userRepo.findAll ();
    }
}
