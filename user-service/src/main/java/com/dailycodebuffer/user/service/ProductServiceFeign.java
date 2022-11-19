package com.dailycodebuffer.user.service;

import com.dailycodebuffer.user.VO.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//replacemetn for resttemplate
@FeignClient("DEPARTMENT-SERVICE")
public interface ProductServiceFeign {
    @GetMapping("/department")
    List<Department> getAllDepartments();

    @GetMapping("/department/{id}")
    Department getDepartmentById(@PathVariable("id") Long id);
}
