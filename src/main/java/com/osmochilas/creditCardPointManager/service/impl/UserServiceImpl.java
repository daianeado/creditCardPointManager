package com.osmochilas.creditCardPointManager.service.impl;

import com.osmochilas.creditCardPointManager.domain.User;
import com.osmochilas.creditCardPointManager.domain.UserCreditCard;
import com.osmochilas.creditCardPointManager.entity.UserEntity;
import com.osmochilas.creditCardPointManager.repository.UserCreditCardRepository;
import com.osmochilas.creditCardPointManager.repository.UserRepository;
import com.osmochilas.creditCardPointManager.service.UserService;
import com.osmochilas.creditCardPointManager.service.mapper.UserCreditCardMapper;
import com.osmochilas.creditCardPointManager.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserCreditCardRepository userCreditCardRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserCreditCardMapper userCreditCardMapper;

    @Override
    public User createUser(User user) {
        user.setCreatedAt(LocalDate.now());
        UserEntity userUnsaved = userMapper.toEntity(user);
        UserEntity userSaved = userRepository.save(userUnsaved);
        return userMapper.toDomain(userSaved);
    }

    @Override
    public Optional<User> getUser(String cpf) {
        Optional<UserEntity> userSaved = userRepository.findByCpf(cpf);
        if(userSaved.isPresent()){
            User user =  userMapper.toDomain(userSaved.get());
            return Optional.of(user);
        }

        return Optional.empty();
    }

    @Override
    public UserCreditCard addCardToUser(UserCreditCard userCreditCard) {
        return userCreditCardMapper
                .toDomain(userCreditCardRepository.save(userCreditCardMapper.toEntity(userCreditCard)));
    }
}
