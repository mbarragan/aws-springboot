package com.quercusdata.awsspringboot.service;

import com.quercusdata.awsspringboot.model.UserModel;

import java.util.List;

public interface UserService {

    UserModel findById(Long userId);

    UserModel createUser(UserModel user);

    List<UserModel> getUsers();
}
