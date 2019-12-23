package com.udemy.userservice.service.impl;

import com.lesson1.userservice.model.Role;
import com.lesson1.userservice.model.User;
import com.lesson1.userservice.model.UserRole;
import com.lesson1.userservice.repository.UserRepository;
import com.lesson1.userservice.service.UserService;
import org.apache.catalina.security.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {

        Optional<User> userLocal = userRepository.findUserByUsername(user.getUsername());

        if (!userLocal.isPresent()) {
            LOGGER.info("User with username {} already exists. Nothing will be done.", user.getUsername());
            return userLocal.get();
        }
        Set<UserRole> userRoleSet = new HashSet<>();
        Role localRole = new Role();
        localRole.setId(1L);
        userRoleSet.add(new UserRole(user, localRole));
        user.setUserRoles(userRoleSet);

        String password = SecurityUtil.


        return userRepository.save(user);
    }

    @Override
    public User getUserByUserName(String username) {
        return userRepository.findUserByUsername(username).orElse(null);
    }
}
