package edu.miu.services;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    String getUserName(Authentication authentication);
}
