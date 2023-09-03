package com.zilev.demo.javaspring3websocketsecurity.security;

import com.zilev.demo.javaspring3websocketsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public UserDetailsServiceCustom(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(s);
        if (user == null) {

            throw new UsernameNotFoundException("User does not exist");

        }

        return new UserDetailsCustom(user);
    }
}