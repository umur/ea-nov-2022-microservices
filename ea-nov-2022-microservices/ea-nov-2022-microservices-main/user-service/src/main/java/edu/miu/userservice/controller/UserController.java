package edu.miu.userservice.controller;

import edu.miu.userservice.entity.User;
import edu.miu.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public User getUserById(@RequestParam int id) {
        return userService.findUserById(id);
    }
}
