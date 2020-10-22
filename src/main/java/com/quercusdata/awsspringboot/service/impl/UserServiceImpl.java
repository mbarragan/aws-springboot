package com.quercusdata.awsspringboot.service.impl;

import com.quercusdata.awsspringboot.entity.User;
import com.quercusdata.awsspringboot.mapper.UserMapper;
import com.quercusdata.awsspringboot.model.PUser;
import com.quercusdata.awsspringboot.repository.UserRepository;
import com.quercusdata.awsspringboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log	= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


    @Override
    public User findById(Long userId) {
        Optional<PUser> pUser = userRepository.findById(userId);
        return pUser.map(user -> userMapper.mapPersistanceToApi(user)).orElse(null);
    }

    @Override
    public User createUser(User user) {
        PUser pUser = userMapper.mapApiToPersistence(user);
        return userMapper.mapPersistanceToApi(userRepository.save(pUser));
    }
}
