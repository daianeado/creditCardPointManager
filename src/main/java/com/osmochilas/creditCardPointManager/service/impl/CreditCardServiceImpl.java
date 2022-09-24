package com.osmochilas.creditCardPointManager.service.impl;

import com.osmochilas.creditCardPointManager.domain.CreditCard;
import com.osmochilas.creditCardPointManager.entity.CreditCardEntity;
import com.osmochilas.creditCardPointManager.repository.CreditCardRepository;
import com.osmochilas.creditCardPointManager.service.CreditCardService;
import com.osmochilas.creditCardPointManager.service.mapper.CreditCardMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository creditCardRepository;
    private final CreditCardMapper creditCardMapper;

    CreditCardServiceImpl(CreditCardRepository creditCardRepository,
                          CreditCardMapper creditCardMapper) {
        this.creditCardRepository = creditCardRepository;
        this.creditCardMapper = creditCardMapper;
    }

    @Override
    public List<CreditCard> getCreditCards(String customerId) {
        Optional<List<CreditCardEntity>> creditCardEntity = creditCardRepository.findByUserId(customerId);

        if (creditCardEntity.isPresent()) {
            return creditCardMapper.toDomain(creditCardEntity.get());
        } else {
            return new ArrayList<>();
        }
    }
}
