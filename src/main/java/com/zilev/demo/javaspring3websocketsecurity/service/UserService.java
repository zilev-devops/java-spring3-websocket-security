package com.zilev.demo.javaspring3websocketsecurity.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User findUserByUsername(String username){
        return (User) User.withUsername(username).build();
    }
}
