package com.osmochilas.creditCardPointManager.controller;

import com.osmochilas.creditCardPointManager.domain.User;
import com.osmochilas.creditCardPointManager.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

}
