package com.osmochilas.creditCardPointManager.service;

import com.osmochilas.creditCardPointManager.domain.Bill;
import com.osmochilas.creditCardPointManager.domain.CreditCard;

import java.util.List;

public interface CreditCardService {
    List<CreditCard> getCreditCards(String customerId);

    List<Bill> getBills(String cpf);
}
