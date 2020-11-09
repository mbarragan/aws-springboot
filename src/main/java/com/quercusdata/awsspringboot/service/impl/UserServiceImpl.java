package com.quercusdata.awsspringboot.service.impl;

import com.quercusdata.awsspringboot.entity.User;
import com.quercusdata.awsspringboot.exception.CRUDBadRequestException;
import com.quercusdata.awsspringboot.exception.CRUDNotFoundException;
import com.quercusdata.awsspringboot.mapper.UserMapper;
import com.quercusdata.awsspringboot.model.UserModel;
import com.quercusdata.awsspringboot.repository.UserRepository;
import com.quercusdata.awsspringboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log	= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserModel findById(Long userId) {

        log.debug("Entering with userId {}", userId);
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()) {
            throw new CRUDNotFoundException("Could not find User with ID: " + userId);
        }
        log.debug("Leaving. Found user {}", user.get().toString());
        return userMapper.mapPersistanceToApi(user.get());
    }

    @Override
    public UserModel createUser(UserModel userModel) {

        log.debug("Entering");
        User user = userMapper.mapApiToPersistence( userModel);
        User returnedUser = userRepository.save(user);
//        if(returnedUser == null) {
//            throw new CRUDNotFoundException("Could not create the user " + userModel.getUsername());
//        }

        log.debug("Leaving. Created user {}", user.toString());
        return userMapper.mapPersistanceToApi(returnedUser);
    }

    @Override
    public List<UserModel> getUsers() {
        log.debug("Entering");
        List<User> users = userRepository.findAll();
        log.debug("Leaving");
        return users.stream().map(user -> userMapper.mapPersistanceToApi( user)).collect(Collectors.toList());
    }

    @Override
    public UserModel updateUser(Long userId, UserModel userModel) {
        log.debug("Entering with userId {}", userId);
        if(userId == null || userModel == null) {
            throw new CRUDBadRequestException("Bad request. Empty userId or userModel.");
        }
        Optional<User> optUserById = userRepository.findById(userId);
        if( !optUserById.isPresent()) {
            throw new CRUDNotFoundException("No user found to update");
        }
        User userById = optUserById.get();
        userById.setUsername( userModel.getUsername());
        userById.setPassword( userModel.getPassword());
        log.debug("Leaving");

        return userMapper.mapPersistanceToApi( userRepository.save( userById));
    }
}
