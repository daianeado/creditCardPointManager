package com.osmochilas.creditCardPointManager.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name="bills")
@Data
public class BillEntity {

    @Id
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
