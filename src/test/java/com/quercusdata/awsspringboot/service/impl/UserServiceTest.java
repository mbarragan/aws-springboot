package com.quercusdata.awsspringboot.service.impl;

import com.quercusdata.awsspringboot.entity.User;
import com.quercusdata.awsspringboot.mapper.UserMapper;
import com.quercusdata.awsspringboot.model.UserModel;
import com.quercusdata.awsspringboot.repository.UserRepository;
import com.quercusdata.awsspringboot.util.TestDTOData;
import com.quercusdata.awsspringboot.util.TestEntitiesData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceTestContextConfiguration
    {
        @Bean
        public UserServiceImpl userService()
        {
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserServiceImpl	    userServiceImpl;

    @MockBean
    private UserRepository      userRepository;

    @MockBean
    private UserMapper          userMapper;


    @Test
    public void getUserByIdTest() {

        User user = TestEntitiesData.generateEntityUser(1L, "john", "123");
        UserModel userModel = TestDTOData.generateUser(1L, "john", "123");

        // mock method to get the entity and to map towards a DTO
        Mockito.when(userRepository.findById(1L)).thenReturn( Optional.of(user));
        Mockito.when(userMapper.mapPersistanceToApi( user)).thenReturn( userModel);

        UserModel returnedUser = userServiceImpl.findById( user.getId());

        assertThat(returnedUser.getId()).isEqualTo(userModel.getId());
    }

    @Test
    public void createUserTest() {

        User user = new User();
        User returnedUser = TestEntitiesData.generateEntityUser(1L, "john", "123");
        UserModel userModel = TestDTOData.generateUser(1L, "john", "123");

        Mockito.when( userMapper.mapApiToPersistence( userModel)).thenReturn( user);
        Mockito.when( userRepository.save(user)).thenReturn(returnedUser);
        Mockito.when( userMapper.mapPersistanceToApi( returnedUser)).thenReturn( userModel);

        userServiceImpl.createUser( userModel);

        assertThat(returnedUser.getId()).isEqualTo(userModel.getId());
    }

    @Test
    public void getUsersTest() {

        User user = TestEntitiesData.generateEntityUser(1L, "john", "123");
        UserModel userModel = TestDTOData.generateUser(null, "john", "123");
        List<User> users = Collections.singletonList( user);

        // mock method to get the entity and to map towards a DTO
        Mockito.when(userRepository.findAll()).thenReturn( users);
        Mockito.when(userMapper.mapPersistanceToApi( user)).thenReturn( userModel);

        List<UserModel> returnedUsers = userServiceImpl.getUsers();

        assertThat(returnedUsers.size()).isEqualTo(1);
        assertThat(returnedUsers.get(0).getUsername()).isEqualTo(userModel.getUsername());
    }
}
