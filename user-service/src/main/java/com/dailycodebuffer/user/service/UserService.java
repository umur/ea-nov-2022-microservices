package com.dailycodebuffer.user.service;

import com.dailycodebuffer.user.VO.Department;
import com.dailycodebuffer.user.VO.ResponseTemplateVO;
import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.repository.UserRepository;
import com.dailycodebuffer.user.vault.Credentials;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
//@AllArgsConstructor
//@NoArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductServiceFeign productServiceFeign;




    public User saveUser(User user) {
        log.info("UserService:saveUser() : User saved");
        return userRepository.save(user);
    }

    public User findById(Long id) {
        log.info("UserService:findById() : User findById");

        return userRepository.findById(id).get();
    }
        int retryCount = 1;
//    @CircuitBreaker,@Retry, and @RateLimiter Configuration are in application.yml
//    @CircuitBreaker(name = "UserService",fallbackMethod = "userServiceFallBackMethod")
//    @Retry(name="UserService",fallbackMethod = "userServiceFallBackMethod")
    @RateLimiter(name = "UserService",fallbackMethod = "userServiceFallBackMethod")
    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("UserService:getUserWithDepartment() : ResponseTemplateVO getUserWithDepartment");
        System.out.println("Retry invoked "+retryCount++);
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findById(userId).get();
        vo.setUser(user);
        /////Using Feign
        Department department = productServiceFeign.getDepartmentById(user.getDepartmentId());

        //////Using RestTemplate
//        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+user.getDepartmentId(), Department.class);
        vo.setDepartment(department);
        return vo;
    }

    public ResponseTemplateVO userServiceFallBackMethod(Exception e){
        return new ResponseTemplateVO();
//        return "User Service is taking longer than " +
//                "Expected, please try again later";
    }
}
