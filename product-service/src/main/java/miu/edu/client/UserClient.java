package miu.edu.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "user-service", url = "http://user-service:8080/")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    List<Object> getUsers();
}