package com.dailycodebuffer.user.controller;

import com.dailycodebuffer.user.VO.ResponseTemplateVO;
import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.service.UserService;
import com.dailycodebuffer.user.vault.Credentials;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    private Credentials credentials;


    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("UserController:saveUser() : User saved");
        return userService.saveUser(user);
    }

//    @GetMapping("{id}")
//    public User findById(@PathVariable("id") Long id){
//        log.info("UserController:findById() : User findById");
//
//        return userService.findById(id);
//    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long usserId){
        log.info("UserController:getUserWithDepartment() : User and department");
        return userService.getUserWithDepartment(usserId);
    }

    @GetMapping("/testvault")
    public String vault(){
        return credentials.getUsername()+" &Password "+credentials.getPassword() ;
    }

}
