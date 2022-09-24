package com.osmochilas.creditCardPointManager.service;

import com.osmochilas.creditCardPointManager.domain.CreditCard;

import java.util.List;

public interface CreditCardService {
    List<CreditCard> getCreditCards(String customerId);
}
