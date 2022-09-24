package com.osmochilas.creditCardPointManager.controller;

import com.osmochilas.creditCardPointManager.domain.User;
import com.osmochilas.creditCardPointManager.domain.UserCreditCard;
import com.osmochilas.creditCardPointManager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users/{cpf}")
    ResponseEntity<User> userExists(@PathVariable String cpf) {
        Optional<User> user = userService.getUser(cpf);
        if (user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users/credit-cards")
    ResponseEntity<UserCreditCard> addCreditCardForUser(@RequestBody UserCreditCard userCreditCard) {
        return new ResponseEntity<>(userService.addCardToUser(userCreditCard), HttpStatus.CREATED);
    }
}
