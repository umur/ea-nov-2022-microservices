package edu.miu.services;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public String getUserName(Authentication authentication) {
        return authentication.getName();
    }
}
