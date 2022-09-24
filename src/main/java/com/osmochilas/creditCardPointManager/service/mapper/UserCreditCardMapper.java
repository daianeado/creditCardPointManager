package com.osmochilas.creditCardPointManager.service.mapper;

import com.osmochilas.creditCardPointManager.domain.UserCreditCard;
import com.osmochilas.creditCardPointManager.entity.UserCreditCardEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserCreditCardMapper {
    UserCreditCardEntity toEntity(UserCreditCard userCreditCard);
    UserCreditCard toDomain(UserCreditCardEntity userCreditCardEntity);
}
