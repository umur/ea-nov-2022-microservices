package miu.edu.service;

import miu.edu.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> findAll();
    Optional<UserDTO> findOne(Long id);
    UserDTO save(UserDTO product);
    void delete(Long id);
}
