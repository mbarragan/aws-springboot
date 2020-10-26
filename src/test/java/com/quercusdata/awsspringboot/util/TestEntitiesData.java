package com.quercusdata.awsspringboot.util;

import com.quercusdata.awsspringboot.entity.User;

public class TestEntitiesData {

    public static User generateEntityUser(long userId, String name, String password) {
        User user = new User();
        user.setId(userId);
        user.setUsername(name);
        user.setPassword(password);
        return user;
    }
}
