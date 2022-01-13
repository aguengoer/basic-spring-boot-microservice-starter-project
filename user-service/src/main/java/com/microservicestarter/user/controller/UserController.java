package com.microservicestarter.user.controller;

import com.microservicestarter.user.VO.ResponseTemplateVO;
import com.microservicestarter.user.entity.UserEntity;
import com.microservicestarter.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public UserEntity saveUser(@RequestBody UserEntity user) {
        log.info("Inside User controller save");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside User controller findById");

        return userService.getUserWithDepartment(userId);
    }
}
