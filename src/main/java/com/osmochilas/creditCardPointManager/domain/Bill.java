package com.osmochilas.creditCardPointManager.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Bill {

    private String billId;
    private String bankId;
    private String bankName;
    private String creditCardId;
    private String creditCardName;
    private LocalDate dueDate;
    private Double amountValue;
    private Double amountPoints;
    private String amountCurrency;
}
