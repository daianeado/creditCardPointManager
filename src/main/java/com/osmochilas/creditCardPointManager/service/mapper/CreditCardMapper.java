package com.osmochilas.creditCardPointManager.service.mapper;

import com.osmochilas.creditCardPointManager.domain.CreditCard;
import com.osmochilas.creditCardPointManager.entity.CreditCardEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CreditCardMapper {
    List<CreditCard> toDomain(List<CreditCardEntity> creditCardEntity);
}
