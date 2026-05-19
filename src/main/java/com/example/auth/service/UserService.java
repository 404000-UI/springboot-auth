package com.example.auth.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.auth.entity.UserEntity;
import com.example.auth.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity signup(String name, String phoneNumber, String password) {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        this.userRepository.save(user);
        return user;
    }

    public Optional<UserEntity> signin(String name, String password) {
        return this.userRepository.findByNameAndPassword(name, password);
    }

    public UserEntity leave(String name, String password) {
        Optional<UserEntity> u = this.userRepository.findByNameAndPassword(name, password);
        if (u.isPresent()) {
            UserEntity user = u.get();
            this.userRepository.delete(user);
            return user;
        } else {
            return null;
        }
    }

}
