package com.project.controller;

import com.project.VO.ResponseTemplateVO;
import com.project.model.User;
import com.project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {

        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);

    }

    // This method returns both a Department and User object at the same time.
    // The custom ResponseTemplateVO object contains both a Department and User field.
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {

        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);

    }

}