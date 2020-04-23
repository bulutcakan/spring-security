package com.bulut.security.service;

import com.bulut.security.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
