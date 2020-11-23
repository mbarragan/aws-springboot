package com.quercusdata.awsspringboot.web;

import com.quercusdata.awsspringboot.entity.User;
import com.quercusdata.awsspringboot.model.UserModel;
import com.quercusdata.awsspringboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.activation.MimeType;
import java.util.List;

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
    @CrossOrigin(origins = {"http://localhost:4200", "http://127.0.0.1:4200"})
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userModel) {

        log.debug("Entering");
        UserModel userReturned = userService.createUser(userModel);
        log.debug("Leaving");
        return new ResponseEntity<>(userReturned, HttpStatus.OK);
    }

    @GetMapping(value="",
            produces = { "application/json" })
    public ResponseEntity<List<UserModel>> getUsers() {

        log.debug("Entering");
        List<UserModel> userModels = userService.getUsers();
        log.debug("Leaving");
        return new ResponseEntity<>(userModels, HttpStatus.OK);
    }

    @PutMapping(value="/{userId}",
            produces = { "application/json" },
            consumes = { "application/json" })
    public ResponseEntity<UserModel> updateUser(@PathVariable("userId") Long userId, @RequestBody UserModel userModel) {

        log.debug("Entering with userId {}", userId);
        UserModel userReturned = userService.updateUser(userId, userModel);
        log.debug("Leaving");
        return new ResponseEntity<>(userReturned, HttpStatus.OK);
    }

    @DeleteMapping(value="/{userId}",
            produces = { "application/json" })
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }
}
