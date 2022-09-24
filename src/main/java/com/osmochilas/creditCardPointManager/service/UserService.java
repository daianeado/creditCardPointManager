package com.osmochilas.creditCardPointManager.service;

import com.osmochilas.creditCardPointManager.domain.User;
import com.osmochilas.creditCardPointManager.domain.UserCreditCard;

import java.util.Optional;

public interface UserService {
   User createUser(User user);
   Optional<User> getUser(String cpf);
   UserCreditCard addCardToUser(UserCreditCard userCreditCard);
}
