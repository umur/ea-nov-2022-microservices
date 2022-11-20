package miu.service;

import miu.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUserById(int id);
}
