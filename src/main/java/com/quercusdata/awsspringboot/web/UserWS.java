package com.quercusdata.awsspringboot.web;

import com.quercusdata.awsspringboot.entity.User;
import com.quercusdata.awsspringboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserWS {

    private static final Logger log	= LoggerFactory.getLogger(UserWS.class);

    @Autowired
    private UserService userService;


    @GetMapping(value = "/{userId}",
            produces = { "application/json" })
    public ResponseEntity<User> getUserById(@RequestParam(value = "A unique identifier for a `User`.",required=true) @PathVariable("userId") Long userId) {
        User user = userService.findById(userId);
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    //TODO create
}
