package com.example.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.entity.UserEntity;
import com.example.auth.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public UserEntity signup(@RequestParam(value = "name") String name,
            @RequestParam(value = "phoneNumber") String phoneNumber,
            @RequestParam(value = "password") String password) {
        UserEntity user = this.userService.signup(name, phoneNumber, password);
        return user;
    }

    @GetMapping("signin")
    public Optional<UserEntity> signin(@RequestParam(value = "name") String name,
            @RequestParam(value = "password") String password) {
        return this.userService.signin(name, password);
    }

    @PostMapping("/leave")
    public UserEntity leave(@RequestParam(value = "name") String name,
            @RequestParam(value = "password") String passoword) {
        return this.userService.leave(name, passoword);
    }

}
