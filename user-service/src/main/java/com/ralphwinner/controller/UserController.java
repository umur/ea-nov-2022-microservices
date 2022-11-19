package com.ralphwinner.controller;

import com.ralphwinner.entity.User;
import com.ralphwinner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping
    public void save(@RequestBody User user){
        userService.save(user);
    }
}
