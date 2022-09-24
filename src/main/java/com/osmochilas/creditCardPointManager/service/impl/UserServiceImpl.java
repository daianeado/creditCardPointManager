package com.osmochilas.creditCardPointManager.service.impl;

import com.osmochilas.creditCardPointManager.domain.User;
import com.osmochilas.creditCardPointManager.entity.UserEntity;
import com.osmochilas.creditCardPointManager.repository.UserRepository;
import com.osmochilas.creditCardPointManager.service.UserService;
import com.osmochilas.creditCardPointManager.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    UserServiceImpl(UserRepository userRepository,
                                UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User createUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        UserEntity userUnsaved = userMapper.toEntity(user);
        UserEntity userSaved = userRepository.save(userUnsaved);
        return userMapper.toDomain(userSaved);
    }
}
