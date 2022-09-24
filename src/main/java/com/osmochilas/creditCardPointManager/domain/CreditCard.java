package com.osmochilas.creditCardPointManager.domain;

import lombok.Data;

@Data
public class CreditCard {
    private Long id;
    private String bankId;
    private String bankName;
    private String creditCardId;
    private String creditCardName;
    private Double points;
    private String currency;
}
