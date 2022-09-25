package com.osmochilas.creditCardPointManager.service.impl;

import com.osmochilas.creditCardPointManager.domain.Bill;
import com.osmochilas.creditCardPointManager.domain.CreditCard;
import com.osmochilas.creditCardPointManager.entity.BillEntity;
import com.osmochilas.creditCardPointManager.entity.CreditCardEntity;
import com.osmochilas.creditCardPointManager.repository.BillRepository;
import com.osmochilas.creditCardPointManager.repository.CreditCardRepository;
import com.osmochilas.creditCardPointManager.service.CreditCardService;
import com.osmochilas.creditCardPointManager.service.mapper.BillMapper;
import com.osmochilas.creditCardPointManager.service.mapper.CreditCardMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository creditCardRepository;
    private final CreditCardMapper creditCardMapper;

    private final BillRepository billRepository;

    private final BillMapper billMapper;

    CreditCardServiceImpl(CreditCardRepository creditCardRepository,
                          CreditCardMapper creditCardMapper,
                          BillRepository billRepository,
                          BillMapper billMapper) {
        this.creditCardRepository = creditCardRepository;
        this.creditCardMapper = creditCardMapper;
        this.billRepository = billRepository;
        this.billMapper = billMapper;
    }

    @Override
    public List<CreditCard> getCreditCards(String customerId) {
        Optional<List<CreditCardEntity>> creditCardEntity = creditCardRepository.findByUserId(customerId);

        if (creditCardEntity.isPresent()) {
            return creditCardMapper.toDomain(creditCardEntity.get());
        } else {
            return Collections.emptyList();
        }
    }
    @Override
    public List<Bill> getBills(String cpf){
        Optional<List<CreditCardEntity>> optionalCreditCards = creditCardRepository.findByUserId(cpf);
        if(optionalCreditCards.isPresent()){
            List<Bill> bills = new ArrayList<>();
            List<CreditCard> creditCards = creditCardMapper.toDomain(optionalCreditCards.get());
            creditCards.forEach(creditCard -> bills.addAll(findBillsByCreditCard(creditCard)));
            return bills;
        }
        return Collections.emptyList();
    }

    private List<Bill> findBillsByCreditCard(CreditCard creditCard) {
        Optional<List<BillEntity>>optionalBills = billRepository.findByCreditCardId(creditCard.getCreditCardId());
        return optionalBills.map(billEntities -> getBillPoints(creditCard, billEntities)).orElse(Collections.emptyList());
    }

    private List<Bill> getBillPoints(CreditCard creditCard, List<BillEntity> optionalBills) {
        List<Bill> billsCreditCard = billMapper.toDomain(optionalBills);
        billsCreditCard.forEach(bill -> {
            String currency = bill.getAmountCurrency();
            if ("BRL".equals(currency)) {
                bill.setAmountPoints(bill.getAmountValue());
            } else {
                bill.setAmountPoints(getDollarPoints(creditCard, bill));
            }
        });

        return billsCreditCard;
    }

    private Double getDollarPoints(CreditCard creditCard, Bill bill) {
        Double amountBill = bill.getAmountValue();
        Double dollarQuote = 5.26;
        return (amountBill / dollarQuote) * creditCard.getPointsRule();
    }
}
