package com.osmochilas.creditCardPointManager.service.mapper;

import com.osmochilas.creditCardPointManager.domain.User;
import com.osmochilas.creditCardPointManager.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserEntity toEntity(User user);
    User toDomain(UserEntity userEntity);
}
