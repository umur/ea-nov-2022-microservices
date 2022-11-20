package edu.miu.productservice.service;

import edu.miu.productservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {

    @GetMapping("/api/v1/users/{id}")
    UserDTO getUserById(@PathVariable Long id);
}
