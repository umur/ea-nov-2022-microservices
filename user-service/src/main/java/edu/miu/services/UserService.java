package edu.miu.services;

import edu.miu.entities.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<Users> getAll();
}
