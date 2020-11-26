package com.quercusdata.awsspringboot.util;

import com.quercusdata.awsspringboot.entity.User;

public class TestEntitiesData {

    public static User generateEntityUser(Long userId, String name, String nickname) {
        User user = new User();
        user.setId(userId);
        user.setUsername(name);
        user.setNickname(nickname);
        return user;
    }
}
