package com.osmochilas.creditCardPointManager.service;

import com.osmochilas.creditCardPointManager.domain.User;

import java.util.Optional;

public interface UserService {
   User createUser(User user);

   Optional<User> getUser(String cpf);
}
