package com.osmochilas.creditCardPointManager.domain;

import lombok.Data;

import java.util.List;

@Data
public class CreditCard {
    private Integer id;
    private String bankId;
    private String bankName;
    private String creditCardId;
    private String creditCardName;
    private Double pointsRule;
    private String currency;
    private String cpf;
    private User user;
}
