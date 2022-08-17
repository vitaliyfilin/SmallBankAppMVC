package com.example.smallbankapp.service;

import com.example.smallbankapp.model.Role;
import com.example.smallbankapp.model.User;
import com.example.smallbankapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public boolean postUser(String username, String password) {
        if (!userRepository.existsUserByUsername(username)) {
            User user = new User();
            user.setRoleList(Collections.singletonList(Role.client));
            user.setActive(true);
            user.setPassword(password);
            user.setUsername(username);
            userRepository.save(user);
        } else {
            return false;
        }
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //User user = userRepository.findUserByUsername(username);
        //if (user == null) {
        //    throw new UsernameNotFoundException("Username not found");
        //} else {
        return userRepository.getUserByUsername(username);
    }
}

