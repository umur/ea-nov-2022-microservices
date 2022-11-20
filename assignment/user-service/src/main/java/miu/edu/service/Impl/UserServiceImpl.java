package miu.edu.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.entity.User;
import miu.edu.repository.UserRepo;
import miu.edu.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public final UserRepo userRepo;

    @Override
    public Iterable<User> getAll() {
        return userRepo.findAll();
    }
}
