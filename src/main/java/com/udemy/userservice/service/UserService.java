package com.udemy.userservice.service;

import com.lesson1.userservice.model.User;

public interface UserService {

    User createUser(User user);

    User getUserByUserName(String username);
}
