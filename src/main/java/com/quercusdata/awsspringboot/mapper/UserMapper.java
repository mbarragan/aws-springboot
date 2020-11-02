package com.quercusdata.awsspringboot.mapper;

import com.quercusdata.awsspringboot.entity.User;
import com.quercusdata.awsspringboot.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapApiToPersistence(UserModel userModel) {
        User user = new User();
        user.setId(userModel.getId());
        user.setUsername(userModel.getUsername());
        user.setPassword(userModel.getPassword());
        return user;
    }

    public UserModel mapPersistanceToApi(User user) {
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setUsername(user.getUsername());
        userModel.setPassword(user.getPassword());
        return userModel;
    }
}
