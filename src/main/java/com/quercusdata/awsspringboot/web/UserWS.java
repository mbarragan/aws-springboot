package com.quercusdata.awsspringboot.web;

import com.quercusdata.awsspringboot.model.UserModel;
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
    public ResponseEntity<UserModel> getUserById(@PathVariable("userId") Long userId) {

        log.debug("Entering with userId {}", userId);
        UserModel user = userService.findById(userId);
        log.debug("Leaving");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "",
            produces = { "application/json" },
            consumes = { "application/json" })
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userModel) {

        log.debug("Entering");
        UserModel userReturned = userService.createUser(userModel);

        return new ResponseEntity<>(userReturned, HttpStatus.OK);
    }
}
