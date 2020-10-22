package com.quercusdata.awsspringboot.mapper;

import com.quercusdata.awsspringboot.entity.User;
import com.quercusdata.awsspringboot.model.PUser;

public class UserMapper {

    public User mapPersistanceToApi(PUser pUser) {
        User user = new User();
        user.setId(pUser.getId());
        user.setUsername(pUser.getUserName());
        user.setPassword(pUser.getPassword());
        return user;
    }

    public PUser mapApiToPersistence(User user) {
        PUser pUser = new PUser();
        pUser.setId(user.getId());
        pUser.setUserName(user.getUsername());
        pUser.setPassword(user.getPassword());
        return pUser;
    }
}
