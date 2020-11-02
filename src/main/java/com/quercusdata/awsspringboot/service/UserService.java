package com.quercusdata.awsspringboot.service;

import com.quercusdata.awsspringboot.model.UserModel;

public interface UserService {

    UserModel findById(Long userId);

    UserModel createUser(UserModel user);
}
