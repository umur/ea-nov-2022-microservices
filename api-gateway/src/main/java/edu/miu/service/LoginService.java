package edu.miu.service;

import edu.miu.model.LoginRequest;
import edu.miu.model.LoginResponse;

public interface LoginService {

    LoginResponse login(LoginRequest loginRequest);

}
