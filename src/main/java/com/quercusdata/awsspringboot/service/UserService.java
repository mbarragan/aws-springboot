package com.quercusdata.awsspringboot.service;

import com.quercusdata.awsspringboot.entity.User;
import com.quercusdata.awsspringboot.model.UserModel;

public interface UserService {

    UserModel findById(Long userId);

    UserModel createUser(User user);
}
