package miu.service;


import miu.model.User;
import miu.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }
}
