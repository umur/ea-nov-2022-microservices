package edu.miu.controllers;

import edu.miu.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

//    @GetMapping("/user")
//    public ResponseEntity<?> getUsername(Authentication authentication) {
//        return new ResponseEntity<>(authService.getUserName(authentication), HttpStatus.OK);
//    }

    @GetMapping("/user")
    public String getUsername(Authentication authentication) {
        return "Welcome user :)";
    }
}
