package com.quercusdata.awsspringboot.service;

import com.quercusdata.awsspringboot.entity.User;

public interface UserService {

    User findById(Long userId);

    User createUser(User user);
}
