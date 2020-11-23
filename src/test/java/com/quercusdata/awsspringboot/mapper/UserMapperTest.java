package com.quercusdata.awsspringboot.mapper;

import com.quercusdata.awsspringboot.entity.User;
import com.quercusdata.awsspringboot.model.UserModel;
import com.quercusdata.awsspringboot.util.TestDTOData;
import com.quercusdata.awsspringboot.util.TestEntitiesData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


@RunWith(SpringRunner.class)
public class UserMapperTest {

    @TestConfiguration
    static class TemplateMapperTestContextConfiguration
    {
        @Bean
        public UserMapper templateMapper()
        {
            return new UserMapper();
        }
    }

    @Autowired
    UserMapper			userMapper;

    @Test
    public void mapPersistanceToApiUserTest() {

        User user = TestEntitiesData.generateEntityUser(1L, "john", "123");
        UserModel expectedUser = userMapper.mapPersistanceToApi(user);

        assertThat("User id", expectedUser.getId(), equalTo(user.getId()));
        assertThat("User name", expectedUser.getUsername(), equalTo(user.getUsername()));
        assertThat("User pass", expectedUser.getNickname(), equalTo(user.getNickname()));
    }

    @Test
    public void mapApiToPersistanceUserTest() {
        UserModel userModel = TestDTOData.generateUser(1L, "john", "123");
        User expectedUser = userMapper.mapApiToPersistence(userModel);

        assertThat("User id", expectedUser.getId(), equalTo(userModel.getId()));
        assertThat("User name", expectedUser.getUsername(), equalTo(userModel.getUsername()));
        assertThat("User pass", expectedUser.getNickname(), equalTo(userModel.getNickname()));
    }
}
